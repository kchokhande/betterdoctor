package com.radixhealth.betterdoctor.service;

import com.radixhealth.betterdoctor.api.APIConnection;
import com.radixhealth.betterdoctor.api.APIConstant;
import com.radixhealth.betterdoctor.bean.Condition;
import com.radixhealth.betterdoctor.bean.Doctor;
import com.radixhealth.betterdoctor.bean.HttpResponse;
import com.radixhealth.betterdoctor.bean.InsuranceProvider;
import com.radixhealth.betterdoctor.bean.Practice;
import com.radixhealth.betterdoctor.bean.Speciality;
import com.radixhealth.betterdoctor.util.JsonUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class BetterDoctorService {

  private final APIConnection connection;

  public BetterDoctorService(APIConnection connection) {
    this.connection = Objects.requireNonNull(connection, "APIConnection must be required");
  }

  public List<Practice> getPractices() throws Exception {

    return null;
  }

  public List<Practice> getPracticesByUID(String practiceUid) throws Exception {

    return null;
  }

  public List<Practice> getPracticesByNPI(String practiceNpi) throws Exception {

    return null;
  }

  public List<Doctor> getDoctors() throws Exception {

    return null;
  }

  public Doctor getDoctorByUID(String doctorUid) throws Exception {

    return null;
  }

  public Doctor getDoctorByNPI(String doctorNpi) throws Exception {

    return null;
  }

  public List<Doctor> getDoctorsByPracticeUID(String practiceUid) throws Exception {

    return null;
  }

  public List<Doctor> getDoctorsByPracticeNPI(String practiceNpi) throws Exception {

    return null;
  }

  public List<Speciality> getSpecialties(int paginateFromIndex, int limit) throws Exception {

    Map<String, String> parameters = new HashMap<>();
    parameters.put("limit", String.valueOf(limit));
    parameters.put("skip", String.valueOf(paginateFromIndex));

    HttpResponse res = connection.get(APIConstant.GET_SPECIALTIES, parameters);

    JsonUtil content = res.getContent();
    if (res.isSuccess()) {
      return content.getAsBeans(Speciality.class);
    }
    throw new RuntimeException(content.getValue("message"));
  }

  public List<Condition> getConditions(int paginateFromIndex, int limit) throws Exception {

    Map<String, String> parameters = new HashMap<>();
    parameters.put("limit", String.valueOf(limit));
    parameters.put("skip", String.valueOf(paginateFromIndex));

    HttpResponse res = connection.get(APIConstant.GET_CONDITIONS, parameters);

    JsonUtil content = res.getContent();
    if (res.isSuccess()) {
      return content.getAsBeans(Condition.class);
    }
    throw new RuntimeException(content.getValue("message"));
  }

  public List<InsuranceProvider> getInsuranceProviders(int paginateFromIndex, int limit)
      throws Exception {

    Map<String, String> parameters = new HashMap<>();
    parameters.put("fields", "uid,name");
    parameters.put("limit", String.valueOf(limit));
    parameters.put("skip", String.valueOf(paginateFromIndex));

    return getInsuranceProviderAndPlans(parameters);
  }

  public List<InsuranceProvider> getInsuranceProviderAndPlans(int paginateFromIndex, int limit)
      throws Exception {

    Map<String, String> parameters = new HashMap<>();
    parameters.put("limit", String.valueOf(limit));
    parameters.put("skip", String.valueOf(paginateFromIndex));

    return getInsuranceProviderAndPlans(parameters);
  }

  private List<InsuranceProvider> getInsuranceProviderAndPlans(Map<String, String> parameters)
      throws Exception {

    HttpResponse res = connection.get(APIConstant.GET_INSURANCE_PROVIDERS_AND_PLANS, parameters);

    JsonUtil content = res.getContent();
    if (res.isSuccess()) {
      return content.getAsBeans(InsuranceProvider.class);
    }
    throw new RuntimeException(content.getValue("message"));
  }
}
