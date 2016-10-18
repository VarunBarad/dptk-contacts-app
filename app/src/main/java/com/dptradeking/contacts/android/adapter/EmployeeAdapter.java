package com.dptradeking.contacts.android.adapter;

import android.app.Activity;
import android.support.transition.TransitionManager;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dptradeking.contacts.android.R;
import com.dptradeking.contacts.android.model.Executive;
import com.dptradeking.contacts.android.util.Helper;

import java.util.ArrayList;

/**
 * Creator: vbarad
 * Date: 2016-10-18
 * Project: DP-TradeKING-Contacts
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

  private ArrayList<Executive> executives;
  private Activity activity;

  public EmployeeAdapter(ArrayList<Executive> executives, Activity activity) {
    this.executives = executives;
    this.activity = activity;
  }

  @Override
  public EmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
    EmployeeAdapter.ViewHolder viewHolder = new EmployeeAdapter.ViewHolder(cardView, this);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(EmployeeAdapter.ViewHolder holder, int position) {
    Executive executive = this.executives.get(position);

    holder.textViewName.setText(executive.getName());
    holder.textViewDesignation.setText(executive.getDesignation());
    holder.textViewMobile.setText(executive.getContactNumber());
    holder.textViewEmail.setText(executive.getEmail());
  }

  @Override
  public int getItemCount() {
    return this.executives.size();
  }

  private void makeCall(int position) {
    Helper.makeCall(this.executives.get(position).getContactNumber(), this.activity);
  }

  private void sendEmail(int position) {
    Helper.sendEmail(this.executives.get(position).getEmail(), this.activity);
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private CardView cardItem;
    private EmployeeAdapter adapter;

    private AppCompatTextView textViewName;
    private AppCompatTextView textViewDesignation;
    private AppCompatImageButton imageButtonToggle;
    private LinearLayoutCompat viewGroupDetails;
    private AppCompatTextView textViewMobile;
    private AppCompatTextView textViewEmail;
    private AppCompatImageButton imageButtonCall;
    private AppCompatImageButton imageButtonEmail;

    private boolean isDetailsVisible;

    public ViewHolder(CardView cardItem, EmployeeAdapter adapter) {
      super(cardItem);
      this.cardItem = cardItem;
      this.adapter = adapter;

      this.isDetailsVisible = false;

      this.textViewName = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_employee_name);
      this.textViewDesignation = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_employee_designation);
      this.imageButtonToggle = (AppCompatImageButton) this.cardItem.findViewById(R.id.imageButton_employee_toggle);
      this.viewGroupDetails = (LinearLayoutCompat) this.cardItem.findViewById(R.id.viewGroup_employee_details);
      this.textViewMobile = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_employee_mobile);
      this.textViewEmail = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_employee_email);
      this.imageButtonCall = (AppCompatImageButton) this.cardItem.findViewById(R.id.imageButton_employee_call);
      this.imageButtonEmail = (AppCompatImageButton) this.cardItem.findViewById(R.id.imageButton_employee_email);

      this.imageButtonToggle.setOnClickListener(this);
      this.imageButtonCall.setOnClickListener(this);
      this.imageButtonEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()) {
        case R.id.imageButton_employee_toggle:
          this.toggleDetails();
          break;
        case R.id.imageButton_employee_call:
          this.adapter.makeCall(this.getAdapterPosition());
          break;
        case R.id.imageButton_employee_email:
          this.adapter.sendEmail(this.getAdapterPosition());
          break;
      }
    }

    private void toggleDetails() {
      TransitionManager.beginDelayedTransition(this.cardItem);

      if (isDetailsVisible) {
        this.imageButtonToggle.setImageResource(R.drawable.ic_expand_down_black);
        this.viewGroupDetails.setVisibility(View.GONE);
      } else {
        this.imageButtonToggle.setImageResource(R.drawable.ic_expand_up_black);
        this.viewGroupDetails.setVisibility(View.VISIBLE);
      }

      isDetailsVisible = !isDetailsVisible;
    }
  }
}
