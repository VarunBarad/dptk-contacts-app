package com.dptradeking.contacts.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.dptradeking.contacts.android.R;
import com.dptradeking.contacts.android.adapter.DepartmentPagerAdapter;
import com.dptradeking.contacts.android.model.Department;
import com.dptradeking.contacts.android.util.storage.StorageHelper;

import java.util.ArrayList;

public class DepartmentsActivity extends AppCompatActivity {
  private TabLayout tabLayout;
  private ViewPager viewPager;
  private DepartmentPagerAdapter departmentPagerAdapter;
  private ArrayList<Department> departments;

  public static void launchActivity(AppCompatActivity currentActivity) {
    Intent intent = new Intent(currentActivity, DepartmentsActivity.class);
    currentActivity.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.initialize(savedInstanceState);
  }

  private void initialize(Bundle savedInstanceState) {
    this.setContentView(R.layout.activity_departments);

    ActionBar actionBar = this.getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.departments_name);
    }

    StorageHelper storageHelper = new StorageHelper(this);
    this.departments = storageHelper.getDepartments();

    this.tabLayout = (TabLayout) this.findViewById(R.id.tabs_departments);
    this.viewPager = (ViewPager) this.findViewById(R.id.viewPager_departments);
    this.departmentPagerAdapter = new DepartmentPagerAdapter(this.getSupportFragmentManager(), this.departments);
    this.viewPager.setAdapter(this.departmentPagerAdapter);
    this.tabLayout.setupWithViewPager(this.viewPager, true);
  }
}
