package com.dptradeking.contacts.android.util.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Creator: vbarad
 * Date: 2016-09-05
 * Project: DP TradeKING Contacts
 */
public class StorageHelper {
  private static final String FILE_NAME = "dp-contacts-prefs";
  private static final String KEY_SUB_BROKERS = "sub-brokers";

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

  public String getSubBrokersJson() {
    return this.preferences.getString(KEY_SUB_BROKERS, null);
  }

  public StorageHelper setSubBrokersJson(String subBrokersJson) {
    this.preferences.edit().putString(KEY_SUB_BROKERS, subBrokersJson).apply();
    return this;
  }
}
