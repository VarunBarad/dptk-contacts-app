package com.dptradeking.contacts.android.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

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

  public static void makeCall(String phoneNumber, Activity activity) {
    Intent intent = new Intent(Intent.ACTION_DIAL);
    intent.setData(Uri.parse("tel:" + phoneNumber));
    activity.startActivity(intent);
  }

  public static void sendEmail(String recipientEmail, Activity activity) {
    Uri emailUri = Uri.parse("mailto:" + recipientEmail);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, emailUri);
    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipientEmail});
    activity.startActivity(Intent.createChooser(emailIntent, "Send mail"));
  }
}
