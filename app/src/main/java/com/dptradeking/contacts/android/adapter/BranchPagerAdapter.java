package com.dptradeking.contacts.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dptradeking.contacts.android.fragment.BranchFragment;
import com.dptradeking.contacts.android.model.Branch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Creator: vbarad
 * Date: 2016-10-18
 * Project: DP-TradeKING-Contacts
 */

public class BranchPagerAdapter extends FragmentPagerAdapter {
  private ArrayList<Branch> branches;

  public BranchPagerAdapter(FragmentManager fragmentManager, ArrayList<Branch> branches) {
    super(fragmentManager);
    //Sort the branch-list alphabetically according to their alias
    this.branches = branches;
    Collections.sort(this.branches, new Comparator<Branch>() {
      @Override
      public int compare(Branch b1, Branch b2) {
        return b1.getAlias().compareTo(b2.getAlias());
      }
    });
  }

  @Override
  public Fragment getItem(int position) {
    BranchFragment fragment;
    fragment = BranchFragment.newInstance(this.branches.get(position));
    return fragment;
  }

  @Override
  public int getCount() {
    return this.branches.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return this.branches.get(position).getAlias();
  }
}
