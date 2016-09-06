package com.dptradeking.contacts.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dptradeking.contacts.android.fragment.SubBrokerFragment;
import com.dptradeking.contacts.android.model.SubBroker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Creator: vbarad
 * Date: 2016-09-07
 * Project: DP TradeKING Contacts
 */
public class SubBrokerPagerAdapter extends FragmentPagerAdapter {
  private HashMap<String, ArrayList<SubBroker>> subBrokers;
  private ArrayList<String> subBrokerTitles;
  
  public SubBrokerPagerAdapter(FragmentManager fragmentManager, ArrayList<SubBroker> subBrokers) {
    super(fragmentManager);
    this.categorizeSubBrokers(subBrokers);
  }
  
  @Override
  public Fragment getItem(int position) {
    SubBrokerFragment fragment;
    fragment = SubBrokerFragment.newInstance(this.subBrokers.get(this.subBrokerTitles.get(position)));
    return fragment;
  }
  
  @Override
  public int getCount() {
    return this.subBrokerTitles.size();
  }
  
  @Override
  public CharSequence getPageTitle(int position) {
    return this.subBrokerTitles.get(position);
  }
  
  private void categorizeSubBrokers(ArrayList<SubBroker> subBrokers) {
    this.subBrokers = new HashMap<>();
    for (SubBroker s : subBrokers) {
      String key = s.getName().substring(0, 1).toUpperCase();

      if (!this.subBrokers.containsKey(key)) {
        this.subBrokers.put(key, new ArrayList<SubBroker>());
      }

      this.subBrokers.get(key).add(s);
    }

    this.subBrokerTitles = new ArrayList<>();
    this.subBrokerTitles.addAll(this.subBrokers.keySet());
    Collections.sort(this.subBrokerTitles);

    for (int i = 0; i < this.subBrokerTitles.size(); i++) {
      ArrayList<SubBroker> temp = this.subBrokers.get(this.subBrokerTitles.get(i));
      Collections.sort(temp, new Comparator<SubBroker>() {
        @Override
        public int compare(SubBroker s1, SubBroker s2) {
          return s1.getName().compareTo(s2.getName());
        }
      });
      this.subBrokers.put(this.subBrokerTitles.get(i), temp);
    }
  }
}
