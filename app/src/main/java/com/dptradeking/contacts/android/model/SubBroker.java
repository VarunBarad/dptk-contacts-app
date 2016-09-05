package com.dptradeking.contacts.android.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Creator: vbarad
 * Date: 2016-09-04
 * Project: DP TradeKING Contacts
 */
public class SubBroker {

  @Expose
  @SerializedName("id")
  private String id;
  @Expose
  @SerializedName("name")
  private String name;
  @Expose
  @SerializedName("address")
  private String address;
  @Expose
  @SerializedName("contactNumber")
  private String contactNumber;
  @Expose
  @SerializedName("email")
  private String email;
  @Expose
  @SerializedName("registrationNumber")
  private String registrationNumber;
  @Expose
  @SerializedName("incorporationDate")
  private String incorporationDate;

  public static SubBroker getInstance(String subBrokerJson) {
    SubBroker subBroker;
    Gson gson = new Gson();
    try {
      subBroker = gson.fromJson(subBrokerJson, SubBroker.class);
    } catch (JsonSyntaxException e) {
      subBroker = null;
      e.printStackTrace();
    }
    return subBroker;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public String getIncorporationDate() {
    return incorporationDate;
  }
}
