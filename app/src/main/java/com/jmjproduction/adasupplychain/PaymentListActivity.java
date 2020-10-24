package com.jmjproduction.adasupplychain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import net.bohush.geometricprogressview.GeometricProgressView;

import IRepository.IPayment;
import IRepository.IRequisition;
import UserDefinder.PaymentListModel;
import UserDefinder.RequisitionList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import list_adapter.PaymentListAdapter;
import list_adapter.RequisitionDetailListAdapter;
import model.APIInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by ASUS on 5/8/2017.
 */

public class PaymentListActivity extends AppCompatActivity {
    @BindView(R.id.paymentList)
    RecyclerView paymentList;
    @BindView(R.id.progressView) GeometricProgressView progressView;
    @BindView(R.id.placeholderImage) ImageView placeholderImage;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        getSupportActionBar().setTitle("Payment List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_remove_white);
        viewRequisition();
    }
    private void viewRequisition() {

        final Retrofit retrofit= APIInitializer.initNetwork(this);
        int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
        retrofit.create(IPayment.class).GetAllPaymentList(partyId).enqueue(new Callback<PaymentListModel[]>() {
            @Override
            public void onResponse(Call<PaymentListModel[]> call, Response<PaymentListModel[]> response) {
                if(response.body()==null || response.body().length==0){
                    placeholderImage.setVisibility(View.VISIBLE);
                    progressView.setVisibility(View.GONE);
                    return;
                }
                PaymentListAdapter adapter=new PaymentListAdapter(PaymentListActivity.this,response.body());
                paymentList.setAdapter(adapter);
                progressView.setVisibility(View.GONE);
                placeholderImage.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<PaymentListModel[]> call, Throwable t) {
                progressView.setVisibility(View.GONE);
                placeholderImage.setVisibility(View.VISIBLE);
            }
        });

    }
    @OnClick(R.id.btnpaymentAdd)
    public void GotoRequisitionPage(){
        Intent intent=new Intent(this,PaymentActivity.class);
        startActivity(intent);
    }
    public void hideClick(View view) {

        // or avi.smoothToHide();
    }

    public void showClick(View view) {

        // or avi.smoothToShow();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
