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
import com.dptradeking.contacts.android.model.SubBroker;
import com.dptradeking.contacts.android.util.Helper;

import java.util.ArrayList;

/**
 * Creator: vbarad
 * Date: 2016-09-06
 * Project: DP TradeKING Contacts
 */
public class SubBrokerAdapter extends RecyclerView.Adapter<SubBrokerAdapter.ViewHolder> {

  private ArrayList<SubBroker> subBrokers;
  private Activity activity;

  public SubBrokerAdapter(ArrayList<SubBroker> subBrokers, Activity activity) {
    this.subBrokers = subBrokers;
    this.activity = activity;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_brokers_sub_broker, parent, false);
    ViewHolder viewHolder = new ViewHolder(cardView, this);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    SubBroker subBroker = this.subBrokers.get(position);

    holder.textViewName.setText(subBroker.getName());
    holder.textViewRegistrationNumber.setText(subBroker.getRegistrationNumber());
    holder.textViewMobile.setText(subBroker.getContactNumber());
    holder.textViewEmail.setText(subBroker.getEmail());
    holder.textViewAddress.setText(subBroker.getAddress());
  }

  @Override
  public int getItemCount() {
    return this.subBrokers.size();
  }

  private void makeCall(int position) {
    Helper.makeCall(this.subBrokers.get(position).getContactNumber(), this.activity);
  }

  private void sendEmail(int position) {
    Helper.sendEmail(this.subBrokers.get(position).getEmail(), this.activity);
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private CardView cardItem;
    private SubBrokerAdapter adapter;

    private AppCompatTextView textViewName;
    private AppCompatTextView textViewRegistrationNumber;
    private AppCompatImageButton imageButtonToggle;
    private LinearLayoutCompat viewGroupDetails;
    private AppCompatTextView textViewMobile;
    private AppCompatTextView textViewEmail;
    private AppCompatTextView textViewAddress;
    private AppCompatImageButton imageButtonCall;
    private AppCompatImageButton imageButtonEmail;

    private boolean isDetailsVisible;

    public ViewHolder(CardView cardItem, SubBrokerAdapter adapter) {
      super(cardItem);
      this.cardItem = cardItem;
      this.adapter = adapter;

      this.isDetailsVisible = false;

      this.textViewName = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_subBroker_name);
      this.textViewRegistrationNumber = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_subBroker_registrationNumber);
      this.imageButtonToggle = (AppCompatImageButton) this.cardItem.findViewById(R.id.imageButton_subBroker_toggle);
      this.viewGroupDetails = (LinearLayoutCompat) this.cardItem.findViewById(R.id.viewGroup_subBroker_details);
      this.textViewMobile = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_subBroker_mobile);
      this.textViewEmail = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_subBroker_email);
      this.textViewAddress = (AppCompatTextView) this.cardItem.findViewById(R.id.textView_subBroker_address);
      this.imageButtonCall = (AppCompatImageButton) this.cardItem.findViewById(R.id.imageButton_subBroker_call);
      this.imageButtonEmail = (AppCompatImageButton) this.cardItem.findViewById(R.id.imageButton_subBroker_email);

      this.imageButtonToggle.setOnClickListener(this);
      this.imageButtonCall.setOnClickListener(this);
      this.imageButtonEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()) {
        case R.id.imageButton_subBroker_toggle:
          this.toggleDetails();
          break;
        case R.id.imageButton_subBroker_call:
          this.adapter.makeCall(this.getAdapterPosition());
          break;
        case R.id.imageButton_subBroker_email:
          this.adapter.sendEmail(this.getAdapterPosition());
          break;
      }
    }

    private void toggleDetails() {
      TransitionManager.beginDelayedTransition(this.cardItem);

      if (isDetailsVisible) {
        this.imageButtonToggle.setImageResource(R.drawable.ic_expand_more_black);
        this.viewGroupDetails.setVisibility(View.GONE);
      } else {
        this.imageButtonToggle.setImageResource(R.drawable.ic_expand_less_black);
        this.viewGroupDetails.setVisibility(View.VISIBLE);
      }

      isDetailsVisible = !isDetailsVisible;
    }
  }
}
