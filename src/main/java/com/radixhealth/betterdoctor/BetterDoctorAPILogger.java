package com.radixhealth.betterdoctor;

import java.sql.Timestamp;

public interface BetterDoctorAPILogger {

  void logRequest(String url, String payload, String response, Timestamp startedTs, Timestamp completedTs);
}
