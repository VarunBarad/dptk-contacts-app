package com.dptradeking.contacts.android.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.dptradeking.contacts.android.R;
import com.dptradeking.contacts.android.util.APIHelper;
import com.dptradeking.contacts.android.util.Helper;
import com.dptradeking.contacts.android.util.storage.StorageHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {

  private ProgressDialog progressDialog;
  private StorageHelper storageHelper;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.initialize(savedInstanceState);
  }

  private void initialize(Bundle savedInstanceState) {
    this.setContentView(R.layout.activity_home);

    this.findViewById(R.id.button_home_departments).setOnClickListener(this);
    this.findViewById(R.id.button_home_branches).setOnClickListener(this);
    this.findViewById(R.id.button_home_subBrokers).setOnClickListener(this);

    this.storageHelper = new StorageHelper(this);

    if (Helper.isConnectedToInternet(this)) {
      this.showProgressDialog();
      APIHelper.fetchAllData(this, this, this);
    } else if (!this.storageHelper.hasSubBrokersJson()) {
      this.blockUserInterface("No contacts available");
    }
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.button_home_departments:
        break;
      case R.id.button_home_branches:
        break;
      case R.id.button_home_subBrokers:
        SubBrokersActivity.launchActivity(this);
        break;
    }
  }

  private void showProgressDialog() {
    if (this.progressDialog != null && this.progressDialog.isShowing()) {
      this.progressDialog.dismiss();
    }

    this.progressDialog = new ProgressDialog(this);
    this.progressDialog.setIndeterminate(true);
    this.progressDialog.setCancelable(false);
    this.progressDialog.setTitle("Updating contacts");
    this.progressDialog.setMessage("Please wait, contacts are being updated!");
    this.progressDialog.show();
  }

  private void dismissProgressDialog() {
    if (this.progressDialog != null && this.progressDialog.isShowing()) {
      this.progressDialog.dismiss();
    }
    this.progressDialog = null;
  }

  @Override
  public void onResponse(JSONObject response) {
    this.dismissProgressDialog();
    try {
      String subBrokersJson = response.getJSONObject("message").getJSONArray("subBrokers").toString();
      this.storageHelper
          .setSubBrokersJson(subBrokersJson);
    } catch (JSONException e) {
      e.printStackTrace();
      this.onErrorResponse(new VolleyError());
    }
  }

  @Override
  public void onErrorResponse(VolleyError error) {
    this.dismissProgressDialog();
    if (!this.storageHelper.hasSubBrokersJson()) {
      this.blockUserInterface("Couldn't connect to server");
    }
  }

  private void blockUserInterface(String message) {
    this.findViewById(R.id.button_home_departments).setEnabled(false);
    this.findViewById(R.id.button_home_branches).setEnabled(false);
    this.findViewById(R.id.button_home_subBrokers).setEnabled(false);
    Snackbar.make(this.findViewById(R.id.button_home_departments), message, Snackbar.LENGTH_INDEFINITE).show();
  }
}
