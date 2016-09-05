package com.dptradeking.contacts.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Creator: vbarad
 * Date: 2016-09-05
 * Project: DP TradeKING Contacts
 */
public final class Helper {
  public static boolean isConnectedToInternet(Context context) {
    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

    boolean isConnected;

    isConnected = (activeNetwork != null) && activeNetwork.isConnected();

    return isConnected;
  }
}
