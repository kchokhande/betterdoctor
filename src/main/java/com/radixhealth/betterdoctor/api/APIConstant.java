package com.radixhealth.betterdoctor.api;

public final class APIConstant {

  public static final String API_BASE_SITE_URL = "https://api.betterdoctor.com/2016-03-01";

  public static final String GET_PRACTICES = "/practices";
  public static final String GET_PRACTICES_BY_UID = "/practices/%s";
  public static final String GET_PRACTICES_BY_NPI = "/practices/npi/%s";
  public static final String GET_DOCTORS = "/doctors";
  public static final String GET_DOCTOR_BY_UID = "/doctors/%s";
  public static final String GET_DOCTOR_BY_NPI = "/doctors/npi/%s";
  public static final String GET_DOCTORS_BY_PRACTIC_UID = "/practices/%s/doctors";
  public static final String GET_DOCTORS_BY_PRACTIC_NPI = "/practices/npi/%s/doctors";
  public static final String GET_SPECIALTIES = "/specialties";
  public static final String GET_CONDITIONS = "/conditions";
  public static final String GET_INSURANCE_PROVIDERS_AND_PLANS = "/insurances";

}
