package com.dptradeking.contacts.android.util;

/**
 * Creator: vbarad
 * Date: 2016-09-04
 * Project: DP TradeKING Contacts
 */
public final class APIHelper {
  private static final String baseUrl = "http://192.168.1.102:8080";
  private static final String endpointSubBrokers = "/api/sub-brokers";
  private static final String endpointAll = "/api/all";

  public static String getSubBrokersUrl() {
    return APIHelper.baseUrl + APIHelper.endpointSubBrokers;
  }

  public static String getAllUrl() {
    return APIHelper.baseUrl + APIHelper.endpointAll;
  }
}
