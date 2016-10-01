package com.dptradeking.contacts.android.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Creator: vbarad
 * Date: 2016-10-01
 * Project: DP-TradeKING-Contacts
 */

public class Branch {
  @Expose
  @SerializedName("_id")
  private String id;
  @Expose
  @SerializedName("name")
  private String name;
  @Expose
  @SerializedName("alias")
  private String alias;
  @Expose
  @SerializedName("contactNumber")
  private String contactNumber;
  @Expose
  @SerializedName("executives")
  private ArrayList<Executive> executives;

  public static Branch getInstance(String branchJson) {
    Branch branch;
    Gson gson = new Gson();
    try {
      branch = gson.fromJson(branchJson, Branch.class);
    } catch (JsonSyntaxException e) {
      branch = null;
      e.printStackTrace();
    }
    return branch;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAlias() {
    return alias;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public ArrayList<Executive> getExecutives() {
    return executives;
  }
}
