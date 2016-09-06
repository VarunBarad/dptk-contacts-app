package com.dptradeking.contacts.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.dptradeking.contacts.android.R;
import com.dptradeking.contacts.android.adapter.SubBrokerPagerAdapter;
import com.dptradeking.contacts.android.model.SubBroker;
import com.dptradeking.contacts.android.util.storage.StorageHelper;

import java.util.ArrayList;

public class SubBrokersActivity extends AppCompatActivity {
  private TabLayout tabLayout;
  private ViewPager viewPager;
  private SubBrokerPagerAdapter subBrokerPagerAdapter;
  private ArrayList<SubBroker> subBrokers;

  public static void launchActivity(AppCompatActivity currentActivity) {
    Intent intent = new Intent(currentActivity, SubBrokersActivity.class);
    currentActivity.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.initialize(savedInstanceState);
  }

  private void initialize(Bundle savedInstanceState) {
    this.setContentView(R.layout.activity_sub_brokers);

    ActionBar actionBar = this.getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.subBrokers_name);
    }

    StorageHelper storageHelper = new StorageHelper(this);
    this.subBrokers = storageHelper.getSubBrokers();

    this.tabLayout = (TabLayout) this.findViewById(R.id.tabs_subBrokers);
    this.viewPager = (ViewPager) this.findViewById(R.id.viewPager_subBrokers);
    this.subBrokerPagerAdapter = new SubBrokerPagerAdapter(this.getSupportFragmentManager(), this.subBrokers);
    this.viewPager.setAdapter(this.subBrokerPagerAdapter);
    this.tabLayout.setupWithViewPager(this.viewPager, true);
  }
}
