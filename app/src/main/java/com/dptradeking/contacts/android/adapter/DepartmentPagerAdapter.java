package com.dptradeking.contacts.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dptradeking.contacts.android.fragment.DepartmentFragment;
import com.dptradeking.contacts.android.model.Department;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Creator: vbarad
 * Date: 2016-10-18
 * Project: DP-TradeKING-Contacts
 */

public class DepartmentPagerAdapter extends FragmentPagerAdapter {
  private ArrayList<Department> departments;

  public DepartmentPagerAdapter(FragmentManager fragmentManager, ArrayList<Department> departments) {
    super(fragmentManager);
    //Sort the department-list alphabetically according to their alias
    this.departments = departments;
    Collections.sort(this.departments, new Comparator<Department>() {
      @Override
      public int compare(Department d1, Department d2) {
        return d1.getAlias().compareTo(d2.getAlias());
      }
    });
  }

  @Override
  public Fragment getItem(int position) {
    DepartmentFragment fragment;
    fragment = DepartmentFragment.newInstance(this.departments.get(position));
    return fragment;
  }

  @Override
  public int getCount() {
    return this.departments.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return this.departments.get(position).getAlias();
  }
}
