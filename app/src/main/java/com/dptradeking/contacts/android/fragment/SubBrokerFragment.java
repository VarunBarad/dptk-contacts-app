package com.dptradeking.contacts.android.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dptradeking.contacts.android.R;
import com.dptradeking.contacts.android.adapter.SubBrokerAdapter;
import com.dptradeking.contacts.android.model.SubBroker;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SubBrokerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubBrokerFragment extends Fragment {
  static {
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
  }

  private ArrayList<SubBroker> subBrokers;
  private View rootView;
  private RecyclerView recyclerViewSubBrokers;
  private SubBrokerAdapter subBrokerAdapter;

  public SubBrokerFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param subBrokers SubBrokers to be displayed in this fragment.
   * @return A new instance of fragment SubBrokerFragment.
   */
  public static SubBrokerFragment newInstance(ArrayList<SubBroker> subBrokers) {
    SubBrokerFragment fragment = new SubBrokerFragment();
    fragment.subBrokers = subBrokers;
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    this.rootView = inflater.inflate(R.layout.fragment_sub_broker, container, false);

    this.recyclerViewSubBrokers = (RecyclerView) this.rootView.findViewById(R.id.recyclerView_subBrokers);
    this.recyclerViewSubBrokers.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
    this.subBrokerAdapter = new SubBrokerAdapter(this.subBrokers, this.getActivity());
    this.recyclerViewSubBrokers.setAdapter(this.subBrokerAdapter);

    return this.rootView;
  }

}
