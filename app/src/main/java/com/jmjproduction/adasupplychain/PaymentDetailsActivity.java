package com.jmjproduction.adasupplychain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import IRepository.IPayment;
import UserDefinder.PaymentListModel;
import butterknife.ButterKnife;
import model.APIInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by jmjsa on 20/03/2017.
 */

public class PaymentDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        ButterKnife.bind(this);
    }
    public void LoadPaymentList(){
        final Retrofit retrofit= APIInitializer.initNetwork(this);
        retrofit.create(IPayment.class).GetAllPaymentList(54).enqueue(new Callback<PaymentListModel[]>() {
            @Override
            public void onResponse(Call<PaymentListModel[]> call, Response<PaymentListModel[]> response) {

            }

            @Override
            public void onFailure(Call<PaymentListModel[]> call, Throwable t) {

            }
        });
    }

}
