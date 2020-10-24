package com.jmjproduction.adasupplychain;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import IRepository.IDeliveryChallanReport;
import IRepository.IdeliveryListInfo;
import UserDefinder.DeliveryChallanReportModel;
import UserDefinder.ReceivedDeliveryModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import list_adapter.DeliveryChallanListAdapter;
import model.APIInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DeliveryChalanActivity extends AppCompatActivity {
    @BindView(R.id.deliveryItemListView) RecyclerView deliveryItemListView;
    @BindView(R.id.txtDeliveryCode)
    TextView txtDeliveryCode;
    @BindView(R.id.txtDeliveryDate) TextView txtDeliveryDate;
    @BindView(R.id.txtRequisitionCodeChallan) TextView txtRequisitionCode;
    @BindView(R.id.txtTotalDeliveryItem) TextView txtTotalDeliveryItem;
    @BindView(R.id.txtCouriername) TextView txtCouriername;
    @BindView(R.id.btnReceivedFromChallan)
    FloatingActionButton btnReceivedFromChallan;
    int delivery_master_id=0;
    String delivery_status="";
SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_chalan);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        getSupportActionBar().setTitle("Delivery Challan List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back_withoutline);
        delivery_master_id=getIntent().getIntExtra("delivery_master_id",0);
        delivery_status=getIntent().getStringExtra("delivery_status");

        //Toast.makeText(this, "Deliver Master Id"+delivery_master_id, Toast.LENGTH_SHORT).show();
       loadDeliveryItem(delivery_master_id);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this,DeliveryActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    private void loadDeliveryItem(int delivery_master_id){
        Retrofit retrofit= APIInitializer.initNetwork(this);
        final IDeliveryChallanReport deliveryChallanReport=retrofit.create(IDeliveryChallanReport.class);
        deliveryChallanReport.GetAllDeliveryReportData(delivery_master_id).enqueue(new Callback<DeliveryChallanReportModel[]>() {
            @Override
            public void onResponse(Call<DeliveryChallanReportModel[]> call, Response<DeliveryChallanReportModel[]> response) {

                DeliveryChallanReportModel deliveryChallanReportModels[]=response.body();
                txtDeliveryCode.setText(deliveryChallanReportModels[0].getDeliveryNo());
                txtDeliveryDate.setText(deliveryChallanReportModels[0].getDeliveryDate());
                txtRequisitionCode.setText(deliveryChallanReportModels[0].getRequisitionCode());
                int totaldfeliveryItem=0;
                for (int i=0;i<deliveryChallanReportModels.length;i++){
                    totaldfeliveryItem+=deliveryChallanReportModels[i].getDeliveredQuantity();
                    Log.e("Delivery item",deliveryChallanReportModels[i].getDeliverableQuantity()+"");
                }
                txtTotalDeliveryItem.setText(totaldfeliveryItem+" "+"Pcs");
                DeliveryChallanListAdapter deliveryChallanListAdapter=new DeliveryChallanListAdapter(getApplicationContext(),response.body());
                if (delivery_status.equals("Received")){
                    btnReceivedFromChallan.setVisibility(View.GONE);
                }

                deliveryItemListView.setAdapter(deliveryChallanListAdapter);
            }

            @Override
            public void onFailure(Call<DeliveryChallanReportModel[]> call, Throwable throwable) {
                Toast.makeText(DeliveryChalanActivity.this, "No Data Found.", Toast.LENGTH_SHORT).show();
            }
        });
        //RequisitionListAdapter requisitionListAdapter=new RequisitionListAdapter(this);
        //deliveryItemListView.setAdapter(requisitionListAdapter);
    }
    @OnClick(R.id.btnReceivedFromChallan)
    public void ReceivedDelivery(){
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.icon_alert)
                .setTitle("Confirmation")
                .setMessage("Are you sure you want to Receive this Delivery?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Retrofit retrofit= APIInitializer.initNetwork(DeliveryChalanActivity.this);
                        retrofit.create(IdeliveryListInfo.class).ReceivedDelivery(delivery_master_id,22).enqueue(new Callback<ReceivedDeliveryModel>() {
                            @Override
                            public void onResponse(Call<ReceivedDeliveryModel> call, Response<ReceivedDeliveryModel> response) {
                                if (response.body().getOutput().equals("success")){
                                    Toast.makeText(DeliveryChalanActivity.this, "Delivery is received successfully.", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(DeliveryChalanActivity.this,DeliveryActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(DeliveryChalanActivity.this, "Something is went wrong.", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(DeliveryChalanActivity.this,DeliveryActivity.class);
                                    startActivity(intent);
                                }



                            }

                            @Override
                            public void onFailure(Call<ReceivedDeliveryModel> call, Throwable t) {

                            }
                        });
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
