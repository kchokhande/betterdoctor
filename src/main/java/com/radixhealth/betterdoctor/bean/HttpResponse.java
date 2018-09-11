package com.radixhealth.betterdoctor.bean;

import com.radixhealth.betterdoctor.util.JsonUtil;

public final class HttpResponse {

  private final int statusCode;
  private final boolean success;
  private final JsonUtil content;

  public HttpResponse(int statusCode, boolean success, JsonUtil content) {
    this.statusCode = statusCode;
    this.success = statusCode < 400 && success;
    this.content = content;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public boolean isSuccess() {
    return success;
  }

  public JsonUtil getContent() {
    return content;
  }
}
