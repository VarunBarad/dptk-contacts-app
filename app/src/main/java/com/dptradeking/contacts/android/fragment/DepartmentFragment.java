package com.dptradeking.contacts.android.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dptradeking.contacts.android.R;
import com.dptradeking.contacts.android.adapter.EmployeeAdapter;
import com.dptradeking.contacts.android.model.Department;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DepartmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DepartmentFragment extends Fragment {
  static {
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
  }

  private Department department;
  private View rootView;
  private AppCompatTextView textViewDepartmentName;
  private RecyclerView recyclerViewDepartments;
  private EmployeeAdapter employeeAdapter;

  public DepartmentFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param department Department to be displayed in this fragment.
   * @return A new instance of fragment DepartmentFragment.
   */
  public static DepartmentFragment newInstance(Department department) {
    DepartmentFragment fragment = new DepartmentFragment();
    fragment.department = department;
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    this.rootView = inflater.inflate(R.layout.fragment_department, container, false);

    this.textViewDepartmentName = (AppCompatTextView) this.rootView.findViewById(R.id.textView_departmentDetails_name);
    this.recyclerViewDepartments = (RecyclerView) this.rootView.findViewById(R.id.recyclerView_departmentEmployee);
    this.recyclerViewDepartments.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
    this.employeeAdapter = new EmployeeAdapter(this.department.getExecutives(), this.getActivity());
    this.recyclerViewDepartments.setAdapter(this.employeeAdapter);

    this.setDepartmentDetails();

    return this.rootView;
  }

  private void setDepartmentDetails() {
    this.textViewDepartmentName.setText(this.department.getName());
  }
}
