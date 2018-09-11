package com.radixhealth.betterdoctor.bean;

public final class Speciality {

  private final String uid;
  private final String name;
  private final String description;
  private final String category;
  private final String actor;
  private final String actors;

  public Speciality(String uid, String name, String description, String category, String actor,
      String actors) {
    this.uid = uid;
    this.name = name;
    this.description = description;
    this.category = category;
    this.actor = actor;
    this.actors = actors;
  }

  public String getUid() {
    return uid;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getCategory() {
    return category;
  }

  public String getActor() {
    return actor;
  }

  public String getActors() {
    return actors;
  }
}
