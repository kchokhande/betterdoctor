package com.radixhealth.betterdoctor.bean;

import java.util.List;

public final class InsurancePlan {

  private final String uid;
  private final String name;
  private final List<String> category;

  public InsurancePlan(String uid, String name, List<String> category) {
    this.uid = uid;
    this.name = name;
    this.category = category;
  }

  public String getUid() {
    return uid;
  }

  public String getName() {
    return name;
  }

  public List<String> getCategory() {
    return category;
  }
}
