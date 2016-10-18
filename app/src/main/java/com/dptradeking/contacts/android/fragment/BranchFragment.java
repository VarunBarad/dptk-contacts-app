package com.dptradeking.contacts.android.fragment;


import android.os.Bundle;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dptradeking.contacts.android.R;
import com.dptradeking.contacts.android.adapter.EmployeeAdapter;
import com.dptradeking.contacts.android.model.Branch;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BranchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BranchFragment extends Fragment implements View.OnClickListener {
  static {
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
  }

  private Branch branch;
  private View rootView;
  private LinearLayoutCompat viewGroupDetails;
  private AppCompatTextView textViewBranchName;
  private AppCompatImageButton imageButtonToggleBranchDetails;
  private AppCompatTextView textViewBranchMobile;
  private AppCompatTextView textViewBranchAddress;
  private RecyclerView recyclerViewBranches;
  private EmployeeAdapter employeeAdapter;
  private boolean isDetailsVisible;

  public BranchFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param branch Branch to be displayed in this fragment.
   * @return A new instance of fragment SubBrokerFragment.
   */
  public static BranchFragment newInstance(Branch branch) {
    BranchFragment fragment = new BranchFragment();
    fragment.branch = branch;
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    this.rootView = inflater.inflate(R.layout.fragment_branch, container, false);

    this.viewGroupDetails = (LinearLayoutCompat) this.rootView.findViewById(R.id.branchDetailsContent);
    this.textViewBranchName = (AppCompatTextView) this.rootView.findViewById(R.id.textView_branchDetails_name);
    this.imageButtonToggleBranchDetails = (AppCompatImageButton) this.rootView.findViewById(R.id.imageButton_branchDetails_toggle);
    this.textViewBranchMobile = (AppCompatTextView) this.rootView.findViewById(R.id.textView_branchDetails_mobile);
    this.textViewBranchAddress = (AppCompatTextView) this.rootView.findViewById(R.id.textView_branchDetails_address);
    this.recyclerViewBranches = (RecyclerView) this.rootView.findViewById(R.id.recyclerView_branchEmployee);
    this.recyclerViewBranches.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
    this.employeeAdapter = new EmployeeAdapter(this.branch.getExecutives(), this.getActivity());
    this.recyclerViewBranches.setAdapter(this.employeeAdapter);

    this.isDetailsVisible = false;
    this.setBranchDetails();
    this.imageButtonToggleBranchDetails.setOnClickListener(this);

    return this.rootView;
  }

  private void setBranchDetails() {
    this.textViewBranchName.setText(this.branch.getName());
    this.textViewBranchMobile.setText(this.branch.getContactNumber());
    this.textViewBranchAddress.setText(this.branch.getAddress());
  }

  @Override
  public void onClick(View view) {
    this.toggleDetails();
  }

  private void toggleDetails() {
    TransitionManager.beginDelayedTransition((ViewGroup) this.rootView);

    if (isDetailsVisible) {
      this.imageButtonToggleBranchDetails.setImageResource(R.drawable.ic_expand_up_black);
      this.viewGroupDetails.setVisibility(View.GONE);
    } else {
      this.imageButtonToggleBranchDetails.setImageResource(R.drawable.ic_expand_down_black);
      this.viewGroupDetails.setVisibility(View.VISIBLE);
    }

    isDetailsVisible = !isDetailsVisible;
  }
}
