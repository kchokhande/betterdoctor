package com.radixhealth.betterdoctor.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public final class JsonUtil {

  private static final Gson GSON = new Gson();
  private static final JsonParser JSON_PARSER = new JsonParser();

  private final JsonElement json;

  public JsonUtil(String jsonS) {

    this(jsonS == null ? null : new StringReader(jsonS));
  }

  public JsonUtil(Reader reader) {

    this(reader == null ? new JsonObject() : JSON_PARSER.parse(reader));
  }

  public JsonUtil(InputStream inputStream) {

    this(inputStream == null ? null : new InputStreamReader(inputStream));
  }

  public JsonUtil(JsonElement json) {

    this.json = json != null && !json.isJsonNull() ? json : new JsonObject();
  }

  @Override
  public final String toString() {

    return json == null || json.isJsonNull() ? null
        : json.isJsonPrimitive() ? json.getAsString() : json.toString();
  }

  public final boolean contains(String paramName) {

    JsonObject jsonO = getAsJsonO();
    return jsonO != null && jsonO.has(paramName);
  }

  public final void setParam(String paramName, String paramValue) {

    JsonObject jsonO = getAsJsonO();
    if (jsonO != null) {
      jsonO.addProperty(paramName, paramValue);
    }
  }

  public final void setParam(String paramName, Number paramValue) {

    JsonObject jsonO = getAsJsonO();
    if (jsonO != null) {
      jsonO.addProperty(paramName, paramValue);
    }
  }

  public final void setParam(String paramName, Boolean paramValue) {

    JsonObject jsonO = getAsJsonO();
    if (jsonO != null) {
      jsonO.addProperty(paramName, paramValue);
    }
  }

  public final String getValue(String paramName) {

    JsonObject jsonO = getAsJsonO();
    JsonElement jsonE = jsonO == null ? null : jsonO.get(paramName);
    return jsonE == null || jsonE.isJsonNull() ? null
        : jsonE.isJsonPrimitive() ? jsonE.getAsString() : jsonE.toString();
  }

  public final String removeParam(String paramName) {

    JsonObject jsonO = getAsJsonO();
    JsonElement value = jsonO == null ? null : jsonO.remove(paramName);
    return value == null || value.isJsonNull() ? null
        : value.isJsonPrimitive() ? value.getAsString() : value.toString();
  }

  public final String getAsString() {

    return json == null || json.isJsonNull() ? null
        : json.isJsonPrimitive() ? json.getAsString() : json.toString();
  }

  public final JsonArray getAsJsonA() {

    return json == null || !json.isJsonArray() ? null : json.getAsJsonArray();
  }

  public final JsonObject getAsJsonO() {

    return json == null || !json.isJsonObject() ? null : json.getAsJsonObject();
  }

  public final JsonArray getAsJsonA(String paramName) {

    JsonObject jsonO = getAsJsonO();
    JsonElement jsonE = jsonO == null ? null : jsonO.get(paramName);

    return jsonE == null || !jsonE.isJsonArray() ? null : jsonE.getAsJsonArray();
  }

  public final JsonObject getAsJsonO(String paramName) {

    JsonObject jsonO = getAsJsonO();
    JsonElement jsonE = jsonO == null ? null : jsonO.get(paramName);
    return jsonE == null || !jsonE.isJsonObject() ? null : jsonE.getAsJsonObject();
  }

  public final JsonElement getAsJsonE(String paramName) {

    JsonObject jsonO = getAsJsonO();
    return jsonO == null ? null : jsonO.get(paramName);
  }

  public final JsonPrimitive getAsJsonP(String paramName) {

    JsonObject jsonO = getAsJsonO();
    JsonElement jsonE = jsonO == null ? null : jsonO.get(paramName);
    return jsonE == null || !jsonE.isJsonPrimitive() ? null : jsonE.getAsJsonPrimitive();
  }

  public final byte getAsByte(String paramName) {

    JsonPrimitive jsonP = getAsJsonP(paramName);

    String value = jsonP == null ? null : jsonP.getAsString();
    return value == null || value.trim().isEmpty() ? 0 : Byte.parseByte(value);
  }

  public final short getAsShort(String paramName) {

    JsonPrimitive jsonP = getAsJsonP(paramName);

    String value = jsonP == null ? null : jsonP.getAsString();
    return value == null || value.trim().isEmpty() ? 0 : Short.parseShort(value);
  }

  public final int getAsInt(String paramName) {

    JsonPrimitive jsonP = getAsJsonP(paramName);

    String value = jsonP == null ? null : jsonP.getAsString();
    return value == null || value.trim().isEmpty() ? 0 : Integer.parseInt(value);
  }

  public final long getAsLong(String paramName) {

    JsonPrimitive jsonP = getAsJsonP(paramName);

    String value = jsonP == null ? null : jsonP.getAsString();
    return value == null || value.trim().isEmpty() ? 0 : Long.parseLong(value);
  }

  public final float getAsFloat(String paramName) {

    JsonPrimitive jsonP = getAsJsonP(paramName);

    String value = jsonP == null ? null : jsonP.getAsString();
    return value == null || value.trim().isEmpty() ? 0.0f : Float.parseFloat(value);
  }

  public final double getAsDouble(String paramName) {

    JsonPrimitive jsonP = getAsJsonP(paramName);

    String value = jsonP == null ? null : jsonP.getAsString();
    return value == null || value.trim().isEmpty() ? 0.0 : Double.parseDouble(value);
  }

  public final boolean getAsBoolean(String paramName) {

    JsonPrimitive jsonP = getAsJsonP(paramName);

    String value = jsonP == null ? "false" : jsonP.getAsString();
    return "1".equals(value) || "Y".equalsIgnoreCase(value) || "T".equalsIgnoreCase(value)
        || Boolean.parseBoolean(value);
  }

  public final <E> E getAsBean(Class<E> classOfE) {

    return GSON.fromJson(json, classOfE);
  }

  public final <E> E getAsBean(String paramName, Class<E> classOfE) {

    JsonElement jsonE = getAsJsonE(paramName);
    return jsonE == null || jsonE.isJsonNull() ? null : GSON.fromJson(jsonE, classOfE);
  }

  public final <E> List<E> getAsBeans(Class<E> classOfE) {

    JsonArray jsonA = getAsJsonA();
    List<E> listOfE = new ArrayList<>();
    if (jsonA != null) {
      jsonA.forEach(jsonE -> listOfE.add(GSON.fromJson(jsonE, classOfE)));
    }
    return listOfE;
  }

  public final <E> List<E> getAsBeans(String paramName, Class<E> classOfE) {

    JsonArray jsonA = getAsJsonA(paramName);
    List<E> listOfE = new ArrayList<>();
    if (jsonA != null) {
      jsonA.forEach(jsonE -> listOfE.add(GSON.fromJson(jsonE, classOfE)));
    }
    return listOfE;
  }

}

