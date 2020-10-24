package com.jmjproduction.adasupplychain;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.Toast;


import net.bohush.geometricprogressview.GeometricProgressView;

import IRepository.IRequisition;
import UserDefinder.RequisitionList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import list_adapter.RequisitionDetailListAdapter;
import model.APIInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.jmjproduction.adasupplychain.R.id.container;

public class RequisitionDetailsActivity extends AppCompatActivity {
    @BindView(R.id.requisitionList)
    RecyclerView requisitionList;
    @BindView(R.id.progressView) GeometricProgressView progressView;
    @BindView(R.id.placeholderImage) ImageView placeholderImage;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisition_details);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        getSupportActionBar().setTitle("Requisition List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_remove_white);
        viewRequisition();
        setSwipeRefreshLayout();
    }
    private void  setSwipeRefreshLayout(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO
                viewRequisition();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
    private void viewRequisition() {

        final Retrofit retrofit= APIInitializer.initNetwork(this);
        int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
        retrofit.create(IRequisition.class).GetAllRequisiTionByPartyId(partyId).enqueue(new Callback<RequisitionList[]>() {
            @Override
            public void onResponse(Call<RequisitionList[]> call, Response<RequisitionList[]> response) {
                if(response.body()==null || response.body().length==0){
                    placeholderImage.setVisibility(View.VISIBLE);
                    progressView.setVisibility(View.GONE);
                    return;
                }
                RequisitionDetailListAdapter adapter=new RequisitionDetailListAdapter(RequisitionDetailsActivity.this,response.body());
                requisitionList.setAdapter(adapter);
                requisitionList.setVisibility(View.VISIBLE);
                progressView.setVisibility(View.GONE);
                placeholderImage.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<RequisitionList[]> call, Throwable t) {
                requisitionList.setVisibility(View.GONE);
                progressView.setVisibility(View.GONE);
                placeholderImage.setVisibility(View.VISIBLE);
            }
        });

    }
    @OnClick(R.id.btnRequisitionAdd)
    public void GotoRequisitionPage(){
        Intent intent=new Intent(this,RequisitionActivity.class);
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
