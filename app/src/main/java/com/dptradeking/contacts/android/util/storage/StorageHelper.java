package com.dptradeking.contacts.android.util.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.dptradeking.contacts.android.model.Branch;
import com.dptradeking.contacts.android.model.SubBroker;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Creator: vbarad
 * Date: 2016-09-05
 * Project: DP TradeKING Contacts
 */
public class StorageHelper {
  private static final String FILE_NAME = "dp-contacts-prefs";
  private static final String KEY_SUB_BROKERS = "sub-brokers";
  private static final String KEY_BRANCHES = "branches";

  private SharedPreferences preferences;

  public StorageHelper(Context context) {
    this.preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
  }

  public void clear() {
    this.preferences.edit().clear().apply();
  }

  public boolean hasSubBrokersJson() {
    return this.preferences.contains(KEY_SUB_BROKERS);
  }

  public boolean hasBranchesJson() {
    return this.preferences.contains(KEY_BRANCHES);
  }

  public String getSubBrokersJson() {
    return this.preferences.getString(KEY_SUB_BROKERS, null);
  }

  public StorageHelper setSubBrokersJson(String subBrokersJson) {
    this.preferences.edit().putString(KEY_SUB_BROKERS, subBrokersJson).apply();
    return this;
  }

  public String getBranchesJson() {
    return this.preferences.getString(KEY_BRANCHES, null);
  }

  public StorageHelper setBranchesJson(String branchesJson) {
    this.preferences.edit().putString(KEY_BRANCHES, branchesJson).apply();
    return this;
  }

  public ArrayList<SubBroker> getSubBrokers() {
    Gson gson = new Gson();
    ArrayList<SubBroker> subBrokers = new ArrayList<>(Arrays.asList(gson.fromJson(this.getSubBrokersJson(), SubBroker[].class)));
    return subBrokers;
  }

  public ArrayList<Branch> getBranches() {
    Gson gson = new Gson();
    ArrayList<Branch> branches = new ArrayList<>(Arrays.asList(gson.fromJson(this.getBranchesJson(), Branch[].class)));
    return branches;
  }
}
