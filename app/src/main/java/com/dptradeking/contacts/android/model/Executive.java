package com.dptradeking.contacts.android.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Creator: vbarad
 * Date: 2016-10-01
 * Project: DP-TradeKING-Contacts
 */

public class Executive {
  @Expose
  @SerializedName("_id")
  private String id;
  @Expose
  @SerializedName("name")
  private String name;
  @Expose
  @SerializedName("contactNumber")
  private String contactNumber;
  @Expose
  @SerializedName("email")
  private String email;
  @Expose
  @SerializedName("designation")
  private String designation;

  public static Executive getInstance(String executiveJson) {
    Executive executive;
    Gson gson = new Gson();
    try {
      executive = gson.fromJson(executiveJson, Executive.class);
    } catch (JsonSyntaxException e) {
      executive = null;
      e.printStackTrace();
    }
    return executive;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getDesignation() {
    return designation;
  }
}
