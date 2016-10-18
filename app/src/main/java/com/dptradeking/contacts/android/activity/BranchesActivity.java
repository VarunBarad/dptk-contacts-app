package com.dptradeking.contacts.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.dptradeking.contacts.android.R;
import com.dptradeking.contacts.android.adapter.BranchPagerAdapter;
import com.dptradeking.contacts.android.model.Branch;
import com.dptradeking.contacts.android.util.storage.StorageHelper;

import java.util.ArrayList;

public class BranchesActivity extends AppCompatActivity {
  private TabLayout tabLayout;
  private ViewPager viewPager;
  private BranchPagerAdapter branchPagerAdapter;
  private ArrayList<Branch> branches;

  public static void launchActivity(AppCompatActivity currentActivity) {
    Intent intent = new Intent(currentActivity, BranchesActivity.class);
    currentActivity.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.initialize(savedInstanceState);
  }

  private void initialize(Bundle savedInstanceState) {
    this.setContentView(R.layout.activity_branches);

    ActionBar actionBar = this.getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.branches_name);
    }

    StorageHelper storageHelper = new StorageHelper(this);
    this.branches = storageHelper.getBranches();

    this.tabLayout = (TabLayout) this.findViewById(R.id.tabs_branches);
    this.viewPager = (ViewPager) this.findViewById(R.id.viewPager_branches);
    this.branchPagerAdapter = new BranchPagerAdapter(this.getSupportFragmentManager(), this.branches);
    this.viewPager.setAdapter(this.branchPagerAdapter);
    this.tabLayout.setupWithViewPager(this.viewPager, true);
  }
}
