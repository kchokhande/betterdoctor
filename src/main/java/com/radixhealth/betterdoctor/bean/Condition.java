package com.radixhealth.betterdoctor.bean;

public final class Condition {

  private final String uid;
  private final String name;
  private final String url;
  private final boolean active;

  public Condition(String uid, String name, String url, boolean active) {
    this.uid = uid;
    this.name = name;
    this.url = url;
    this.active = active;
  }

  public String getUid() {
    return uid;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public boolean isActive() {
    return active;
  }
}
