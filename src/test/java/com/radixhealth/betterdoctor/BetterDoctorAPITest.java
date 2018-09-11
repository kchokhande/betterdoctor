package com.radixhealth.betterdoctor;

import com.radixhealth.betterdoctor.bean.Condition;
import com.radixhealth.betterdoctor.bean.InsuranceProvider;
import com.radixhealth.betterdoctor.bean.Speciality;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BetterDoctorAPITest {

  @BeforeClass
  public static void init() {
    String apiAccessKey = "62f5d84b5d04d14932ce4485293b8750";
    BetterDoctorAPI.init(apiAccessKey, (url, payload, response, startedTs, completedTs) -> {
      System.out.println("===========================================================");
      System.out.println("URL: " + url);
      System.out.println("Payload: " + payload);
      System.out.println("Response: " + response);
      System.out.println("===========================================================");
    });
  }

  @Test
  public void testGetSpecialties() throws Exception {
    Thread.sleep(500);
    List<Speciality> specialities = BetterDoctorAPI.getSpecialties(1, 3);
    Assert.assertNotNull("Error: getSpecialties result is NULL", specialities);
  }

  @Test
  public void testGetConditions() throws Exception {
    Thread.sleep(500);
    List<Condition> conditions = BetterDoctorAPI.getConditions(1, 3);
    Assert.assertNotNull("Error: getConditions result is NULL", conditions);
  }

  @Test
  public void testGetInsuranceProviders() throws Exception {
    Thread.sleep(500);
    List<InsuranceProvider> providers = BetterDoctorAPI.getInsuranceProviders(1, 3);
    Assert.assertNotNull("Error: getInsuranceProviders result is NULL", providers);
  }

  @Test
  public void testGetInsuranceProviderAndPlans() throws Exception {
    Thread.sleep(500);
    List<InsuranceProvider> providersAndPlans = BetterDoctorAPI.getInsuranceProviderAndPlans(1, 2);
    Assert.assertNotNull("Error: getInsuranceProviderAndPlans result is NULL", providersAndPlans);
  }
}
