package com.radixhealth.betterdoctor.bean;

import java.util.List;

public final class InsuranceProvider {

  private final String uid;
  private final String name;
  private final List<InsurancePlan> plans;

  public InsuranceProvider(String uid, String name, List<InsurancePlan> plans) {
    this.uid = uid;
    this.name = name;
    this.plans = plans;
  }

  public String getUid() {
    return uid;
  }

  public String getName() {
    return name;
  }

  public List<InsurancePlan> getPlans() {
    return plans;
  }
}
