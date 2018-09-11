package com.radixhealth.betterdoctor.api;

import com.google.gson.JsonParser;
import com.radixhealth.betterdoctor.BetterDoctorAPILogger;
import com.radixhealth.betterdoctor.bean.HttpResponse;
import com.radixhealth.betterdoctor.util.JsonUtil;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * <p>
 * The class <b>APIConnection</b> is used to call BetterDoctor API
 *
 * @author kchokhande
 */
public final class APIConnection {

  private static final JsonParser JSON_PARSER = new JsonParser();

  private final BetterDoctorAPILogger logger;
  private final String apiAccessKey, apiBaseUrl;

  public APIConnection(String apiAccessKey, String apiBaseUrl, BetterDoctorAPILogger logger) {

    apiBaseUrl = apiBaseUrl == null ? null : apiBaseUrl.trim();
    apiAccessKey = apiAccessKey == null ? null : apiAccessKey.trim();

    this.logger = Objects.requireNonNull(logger, "BetterDoctorAPILogger must be required");
    this.apiBaseUrl = Objects.requireNonNull(apiBaseUrl, "API base URL must be required");
    this.apiAccessKey = Objects.requireNonNull(apiAccessKey, "API access key must be required");
  }


  public final HttpResponse get(String apiSubUrl, Map<String, String> parameters) throws Exception {

    if (apiSubUrl == null || apiSubUrl.trim().isEmpty()) {
      throw new RuntimeException("Error: API sub URL must be required");
    }

    StringBuilder builder = new StringBuilder();
    builder.append("user_key=").append(URLEncoder.encode(apiAccessKey, "UTF-8"));

    if (parameters != null && !parameters.isEmpty()) {
      for (Entry<String, String> entry : parameters.entrySet()) {
        String paramName = entry.getKey();
        String paramValue = entry.getValue();
        if (paramName != null && !paramName.trim().isEmpty() && paramValue != null) {
          builder.append("&").append(paramName.trim()).append("=");
          builder.append(URLEncoder.encode(paramValue.trim(), "UTF-8"));
        }
      }
    }

    Timestamp startedTs = new Timestamp(System.currentTimeMillis());

    String API_GET_URL = apiBaseUrl + apiSubUrl.trim();
    URL url = new URL(API_GET_URL + "?" + builder);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setDoOutput(true);
    conn.setConnectTimeout(20000);
    conn.setRequestProperty("Content-Type", "application/json");

    JsonUtil response;
    boolean isSuccess = true;
    try {
      response = new JsonUtil(conn.getInputStream());
    } catch (Exception exc) {
      isSuccess = false;
      exc.printStackTrace();
      response = new JsonUtil(conn.getErrorStream());
    }

    Timestamp completedTs = new Timestamp(System.currentTimeMillis());
    logger.logRequest(API_GET_URL, builder.toString(), response.toString(), startedTs, completedTs);

    JsonUtil meta = new JsonUtil(response.getAsJsonE("meta"));
    if (meta.getAsBoolean("error")) {
      response = meta;
    } else {
      response = new JsonUtil(response.getAsJsonE("data"));
    }
    return new HttpResponse(conn.getResponseCode(), isSuccess, response);
  }

}