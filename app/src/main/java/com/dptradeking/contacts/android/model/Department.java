package com.dptradeking.contacts.android.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Creator: vbarad
 * Date: 2016-10-21
 * Project: DP-TradeKING-Contacts
 */

public class Department {
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
  @SerializedName("executives")
  private ArrayList<Executive> executives;

  public static Department getInstance(String departmentJson) {
    Department department;
    Gson gson = new Gson();
    try {
      department = gson.fromJson(departmentJson, Department.class);
    } catch (JsonSyntaxException e) {
      department = null;
      e.printStackTrace();
    }
    return department;
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

  public ArrayList<Executive> getExecutives() {
    return executives;
  }
}
