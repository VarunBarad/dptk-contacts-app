package com.dptradeking.contacts.android.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Creator: vbarad
 * Date: 2016-09-04
 * Project: DP TradeKING Contacts
 */
public final class APIHelper {
  private static final String baseUrl = "https://dp-tradeking-contacts.firebaseio.com";
  private static final String endpointSubBrokers = "/subBrokers.json";
  private static final String endpointAll = "/.json";

  public static String getSubBrokersUrl() {
    return APIHelper.baseUrl + APIHelper.endpointSubBrokers;
  }

  public static String getAllUrl() {
    return APIHelper.baseUrl + APIHelper.endpointAll;
  }

  public static void fetchAllData(Context context, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
    String url = APIHelper.getAllUrl();

    JsonObjectRequest fetchDataRequest =
        new JsonObjectRequest(Request.Method.GET, url, null, responseListener, errorListener);
    VolleySingleton.getInstance(context).addToRequestQueue(fetchDataRequest);
  }
}
