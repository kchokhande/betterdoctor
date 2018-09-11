package com.radixhealth.betterdoctor;

import com.radixhealth.betterdoctor.api.APIConnection;
import com.radixhealth.betterdoctor.api.APIConstant;
import com.radixhealth.betterdoctor.bean.Condition;
import com.radixhealth.betterdoctor.bean.Doctor;
import com.radixhealth.betterdoctor.bean.InsuranceProvider;
import com.radixhealth.betterdoctor.bean.Practice;
import com.radixhealth.betterdoctor.bean.Speciality;
import com.radixhealth.betterdoctor.service.BetterDoctorService;
import java.util.List;
import org.apache.log4j.Logger;

public final class BetterDoctorAPI {

  private static BetterDoctorService betterDoctorService;

  public static void init(String apiAccessKey, BetterDoctorAPILogger betterDoctorAPILogger) {

    Logger LOGGER = Logger.getLogger(BetterDoctorService.class);
    BetterDoctorAPILogger logger = betterDoctorAPILogger != null ? betterDoctorAPILogger
        : (url, payload, result, startTs, endTs) -> LOGGER.info("BetterDoctor API called: " + url);

    APIConnection connection;
    connection = new APIConnection(apiAccessKey, APIConstant.API_BASE_SITE_URL, logger);
    betterDoctorService = new BetterDoctorService(connection);

    LOGGER.info("BetterDoctorAPI initialized successfully.");
  }

  private static void verifyInitialization() {

    if (betterDoctorService == null) {
      String error = "Error: BetterDoctorAPI not yet initialized, please initialize it before use";
      throw new RuntimeException(error);
    }
  }

  public static List<Practice> getPractices() throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return null;
  }

  public static List<Practice> getPracticesByUID(String practiceUid) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return null;
  }

  public static List<Practice> getPracticesByNPI(String practiceNpi) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return null;
  }

  public static List<Doctor> getDoctors() throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return null;
  }

  public static Doctor getDoctorByUID(String doctorUid) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return null;
  }

  public static Doctor getDoctorByNPI(String doctorNpi) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return null;
  }

  public static List<Doctor> getDoctorsByPracticeUID(String practiceUid) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return null;
  }

  public static List<Doctor> getDoctorsByPracticeNPI(String practiceNpi) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return null;
  }

  public static List<Speciality> getSpecialties(int paginateFromIndex, int limit) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return betterDoctorService.getSpecialties(paginateFromIndex, limit);
  }

  public static List<Condition> getConditions(int paginateFromIndex, int limit) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return betterDoctorService.getConditions(paginateFromIndex, limit);
  }

  public static List<InsuranceProvider> getInsuranceProviders(int paginateFromIndex, int limit)
      throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return betterDoctorService.getInsuranceProviders(paginateFromIndex, limit);
  }

  public static List<InsuranceProvider> getInsuranceProviderAndPlans(int paginateFromIndex,
      int limit) throws Exception {

    BetterDoctorAPI.verifyInitialization();

    return betterDoctorService.getInsuranceProviderAndPlans(paginateFromIndex, limit);
  }
}
