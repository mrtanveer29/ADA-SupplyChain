package com.jmjproduction.adasupplychain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Array;
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

public class InventoryActivity extends AppCompatActivity {
    @BindView(R.id.inventoryListView) RecyclerView inventortListView;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        setContentView(R.layout.activity_inventory);
        ButterKnife.bind(this);
        initToolbar();
        sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        getSupportActionBar().setTitle("Inventory List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_remove_white);
        loadInventory();
    }
    private void initToolbar(){}
    private void loadInventory(){
        int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
        int role_id=Integer.parseInt(sharedPreferences.getString("role_id","0"));
        final Retrofit retrofit= APIInitializer.initNetwork(this);
        Log.e("Inventory URL",retrofit.create(IInventoryList.class).GetAllInventoryList(role_id,partyId).request().url().toString());
        retrofit.create(IInventoryList.class).GetAllInventoryList(role_id,partyId).enqueue(new Callback<Inventory[]>() {
            @Override
            public void onResponse(Call<Inventory[]> call, Response<Inventory[]> response) {

                Inventory inventory[]=response.body();
                ArrayList<InventoryListModel> inventoryListModelArrayList=new ArrayList<InventoryListModel>();
                for (int i=0;i<inventory.length;i++){
                    String tempProductName=inventory[i].getProductName();
                    int temptotalLineQty=0;
                    String tempUnitname=inventory[i].getUnitName();
                    temptotalLineQty=inventory[i].getStockQuantity();
                    boolean flag=false;
                    for (int k=0;k<inventoryListModelArrayList.size();k++){
                        String lookingForProductname=inventoryListModelArrayList.get(k).getProductName();
                        Log.e("ProductName",lookingForProductname);
                        if (lookingForProductname.equals(tempProductName)){
                            flag=true;
                            break;
                        }else{
                            flag=false;
                        }
                    }
                    Log.e("Flag",flag+"");
                    if (flag ==false){
                        for (int j=0;j<inventory.length;j++){
                            if (tempProductName.equals(inventory[j].getProductName()) && inventory[i].getColorId() !=inventory[j].getColorId()){
                                temptotalLineQty+=inventory[j].getStockQuantity();
                                Log.e("TempQty",temptotalLineQty+"");
                            }else{
                                continue;
                            }
                        }
                        inventoryListModelArrayList.add(new InventoryListModel(tempProductName,temptotalLineQty,tempUnitname));
                    }
                }
                InventoryAdapter inventoryAdapter=new InventoryAdapter(getApplicationContext(),"inventory",inventoryListModelArrayList);
                inventortListView.setAdapter(inventoryAdapter);

            }

            @Override
            public void onFailure(Call<Inventory[]> call, Throwable t) {

            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
