package com.jmjproduction.adasupplychain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import IRepository.IInventoryList;
import UserDefinder.InventoryListModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import list_adapter.InventoryAdapter;
import model.APIInitializer;
import model.Inventory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InventoryDetailsActivity extends AppCompatActivity {
    @BindView(R.id.inventoryDetailsListView)
    RecyclerView inventoryDetailsListView;
    String productName="";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        setContentView(R.layout.activity_inventory_details);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        productName=getIntent().getStringExtra("product_name");
        getSupportActionBar().setTitle(productName +" Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);

        initToolbar(productName);
        loadInventory(productName);
    }
    private void initToolbar(String productName){
        getSupportActionBar().setTitle(productName);
    }
    private void loadInventory(final String productName){
        final Retrofit retrofit= APIInitializer.initNetwork(this);
        int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
        int role_id=Integer.parseInt(sharedPreferences.getString("role_id","0"));
        retrofit.create(IInventoryList.class).GetAllInventoryList(role_id,partyId).enqueue(new Callback<Inventory[]>() {
            @Override
            public void onResponse(Call<Inventory[]> call, Response<Inventory[]> response) {
                Inventory inventory[]=response.body();
                ArrayList<InventoryListModel> inventoryListModelArrayList=new ArrayList<InventoryListModel>();

                for (int i=0;i<inventory.length;i++){
                    String tempProductName=inventory[i].getProductName();
                    int tempStockQty=0;
                    String tempUnitname=inventory[i].getUnitName();
                    tempStockQty=inventory[i].getStockQuantity();
                    String tempColor=inventory[i].getColorName();
                    if (tempProductName.equals(productName)){
                        inventoryListModelArrayList.add(new InventoryListModel(tempProductName,tempStockQty,tempUnitname,tempColor));
                    }
                }
                InventoryAdapter inventoryAdapter=new InventoryAdapter(getApplicationContext(),"inventory_details",inventoryListModelArrayList);
               inventoryDetailsListView.setAdapter(inventoryAdapter);

            }

            @Override
            public void onFailure(Call<Inventory[]> call, Throwable t) {

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this,InventoryActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
