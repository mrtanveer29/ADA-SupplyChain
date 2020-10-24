package com.jmjproduction.adasupplychain;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import IRepository.AdapterListener;
import IRepository.IColor;
import IRepository.IProductList;
import IRepository.IRequisition;
import UserDefinder.ProductModelForTemplist;
import UserDefinder.RebateAndGiftModel;
import UserDefinder.RequisitionAddModel;
import UserDefinder.RequisitionAddReturnDataModel;
import UserDefinder.RequisitionGiftAndRebate;
import UserDefinder.UserCurrentbalanceModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import list_adapter.RebateGiftAdapter;

import list_adapter.RequisitionListAdapter;
import model.APIInitializer;
import model.Color;
import model.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RequisitionActivity extends AppCompatActivity {
    private static final int ADD_REQUISITION_MENU =1 ;
    @BindView(R.id.requisitionList) RecyclerView requisitionList;
    @BindView(R.id.rebateList) RecyclerView rebateListView;

    @BindView(R.id.productlist)
    Spinner productList;
    @BindView(R.id.colorlist) Spinner colorlist;
    @BindView(R.id.txtQuantity) EditText txtQuantity;
    @BindView(R.id.addRequisitionBtn) FloatingActionButton btnaddRequisition;
    @BindView(R.id.liveDymmy) Switch isLiveDymmy;
    @BindView(R.id.txtCurentBalance) TextView txtCurrentBalance;
    @BindView(R.id.requisitionInfo) TextView requisitionInfo;
    @BindView(R.id.expectedDateView) EditText expectedDateView;
    ArrayList<ProductModelForTemplist> arrayProduct=new ArrayList<ProductModelForTemplist>();
    SharedPreferences sharedPreferences;
    private Retrofit retrofit;
    private IRequisition iRequisition;
    private AdapterListener adapterListener;
    private boolean isLiveDummy;

    final Calendar c = Calendar.getInstance();

    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH);
    final int day = c.get(Calendar.DAY_OF_MONTH);

    @OnClick(R.id.expectedDateView)
    public void setExpectedDate(View view){
        setDate(expectedDateView,"Select Start Date");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisition);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        getSupportActionBar().setTitle("Requisition Form");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);
        // initialization
        retrofit=APIInitializer.initNetwork(this);
        iRequisition=retrofit.create(IRequisition.class);
        // Initialization ends

        //interface Implementation
        adapterListener=new AdapterListener() {
            @Override
            public void applyValueChanged(ArrayList<ProductModelForTemplist> list) {
                double requisitionAmount=0.0;
                for(ProductModelForTemplist tmp_product:list){
                    requisitionAmount+=tmp_product.getPrice();
                }
                requisitionInfo.setText(list.size()+" Requisition Amount: "+requisitionAmount);

            }
        };
        isLiveDymmy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    isLiveDummy=true;
                }else{
                    isLiveDummy=false;
                }
            }
        });
        LoadCurrentbalance();
        LoadProductList();
        LoadColorlist();


    }

    public void LoadProductList(){
        Toast.makeText(getApplicationContext(),"No Product data is found.",Toast.LENGTH_LONG).show();
        retrofit.create(IProductList.class).GetAllProduct().enqueue(new Callback<Product[]>() {
            @Override
            public void onResponse(Call<Product[]> call, Response<Product[]> response) {

                Log.e("Url product: ",call.request().url().toString());
                ArrayAdapter productLists=new ArrayAdapter<Product>(getApplicationContext(),android.R.layout.simple_list_item_1,response.body());
                productList.setAdapter(productLists);

            }

            @Override
            public void onFailure(Call<Product[]> call, Throwable t) {
                Log.e("Url product: ",call.request().url().toString());
            }
        });

    }
    public void LoadColorlist(){
        final Retrofit retrofit=APIInitializer.initNetwork(this);
        retrofit.create(IColor.class).GetAllColorList().enqueue(new Callback<Color[]>() {
            @Override
            public void onResponse(Call<Color[]> call, Response<Color[]> response) {
                ArrayAdapter colorArrayAdapter=new ArrayAdapter<Color>(getApplicationContext(),android.R.layout.simple_list_item_1,response.body());
                colorlist.setAdapter(colorArrayAdapter);
            }

            @Override
            public void onFailure(Call<Color[]> call, Throwable t) {

            }
        });
    }

    public void LoadCurrentbalance(){
        //Toast.makeText(this, "balance", Toast.LENGTH_SHORT).show();
        final Retrofit retrofit=APIInitializer.initNetwork(this);
        int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
        //Toast.makeText(this, "Paty Id"+partyId, Toast.LENGTH_SHORT).show();

        Call<UserCurrentbalanceModel> callback=iRequisition.GetCurrentbalanceofParty(partyId);
        //Log.e("URL",callback.request().url().toString());
        callback.enqueue(new Callback<UserCurrentbalanceModel>() {
            @Override
            public void onResponse(Call<UserCurrentbalanceModel> call, Response<UserCurrentbalanceModel> response) {
                Log.e("Retrofit",response.body().getPartyBalance().toString());
                txtCurrentBalance.setText("Balance "+response.body().getPartyBalance().toString()+" TK");
            }

            @Override
            public void onFailure(Call<UserCurrentbalanceModel> call, Throwable t) {
                Toast.makeText(RequisitionActivity.this, "Failure", Toast.LENGTH_SHORT).show();

            }
        });

    }
    @OnClick(R.id.addRequisitionBtn)
    public void AddProduct(View view){
        if (txtQuantity.getText().toString().trim().equals("")){
            Toast.makeText(this, "You forget to inout in Quantity Field.", Toast.LENGTH_SHORT).show();
        }else{

            Product tempProduct=(Product) productList.getSelectedItem();
            Color tempColor=(Color)colorlist.getSelectedItem();

            ProductModelForTemplist proList=new ProductModelForTemplist();
            proList.setProductName(tempProduct.getProductName());
            proList.setColorName(tempColor.getColorName());
            proList.setPrice(tempProduct.getMdPrice());
            int tempQty=Integer.parseInt(txtQuantity.getText().toString());
            double tempPrice=Double.parseDouble(tempProduct.getMdPrice().toString());
            double temptotalPrice=tempQty*tempPrice;
            proList.setQuantity(tempQty);
            proList.setLine_total(temptotalPrice);
            proList.setProductId(tempProduct.getProductId());
            proList.setUnitId(tempProduct.getUnitId());
            proList.setBrandId(tempProduct.getBrandId());
            proList.setColorId(tempColor.getColorId());

            proList.setIs_live_dummy(isLiveDummy);
            boolean flag=false;
            if (arrayProduct.size()>0){
                for (int i=0;i<arrayProduct.size();i++){
                    String tempProductName=arrayProduct.get(i).getProductName();
                    String tempColorName=arrayProduct.get(i).getColorName();
                    if (proList.getProductName().trim().equals(tempProductName) && proList.getColorName().trim().equals(tempColorName)){
                        Toast.makeText(this, "Duplicate Product Entry.", Toast.LENGTH_SHORT).show();
                        flag=false;
                        break;
                    }else{
                        flag=true;
                    }
                }
                if (flag==true){
                    arrayProduct.add(proList);
                    //Toast.makeText(this, "Test Data: "+arrayProduct.get(0), Toast.LENGTH_SHORT).show();
                    RequisitionListAdapter tempRequisitionList=new RequisitionListAdapter(this,arrayProduct);
                    tempRequisitionList.setAdapterListener(adapterListener);
                    requisitionList.setAdapter(tempRequisitionList);



                }
            }else{
                arrayProduct.add(proList);
                //Toast.makeText(this, "Test Data: "+arrayProduct.get(0), Toast.LENGTH_SHORT).show();
                RequisitionListAdapter tempRequisitionList=new RequisitionListAdapter(this,arrayProduct);
                requisitionList.setAdapter(tempRequisitionList);
            }
            // Call for gift and rebate



            RequisitionGiftAndRebate requisitionGiftAndRebate=new RequisitionGiftAndRebate();
            for(ProductModelForTemplist product:arrayProduct){
                RequisitionGiftAndRebate.RequisitionDetailsList requisitionDetails=requisitionGiftAndRebate.new RequisitionDetailsList();
                requisitionDetails.setProductName(product.getProductName());
                requisitionDetails.setPrice(product.getPrice().intValue());
                requisitionDetails.setQuantity(product.getQuantity());
                requisitionDetails.setColorId(product.getColorId());
                requisitionDetails.setIsLiveDummy(product.is_live_dummy());
                requisitionDetails.setLineTotal(product.getLine_total().intValue());
                requisitionDetails.setProductId(product.getProductId());
                requisitionDetails.setBrandId(product.getBrandId());


                requisitionGiftAndRebate.getRequisitionDetailsList().add(requisitionDetails);


            }
            requisitionGiftAndRebate.setIsActivePromo(true);
            // For test

            //-----------------------
            final Call<RebateAndGiftModel> giftAndRebate=iRequisition.getGiftAndRebate(requisitionGiftAndRebate);
            giftAndRebate.enqueue(new Callback<RebateAndGiftModel>() {
                @Override
                public void onResponse(Call<RebateAndGiftModel> call, Response<RebateAndGiftModel> response) {
                    RebateAndGiftModel rebategift=response.body();
                    if(rebategift==null){
                        Toast.makeText(RequisitionActivity.this, "Null", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<RebateAndGiftModel.RebateList> rebateList=rebategift.getRebateList();
                    List<RebateAndGiftModel.GiftList> giftList=rebategift.getGiftList();
                    Toast.makeText(RequisitionActivity.this, "Rebate "+rebateList.size(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(RequisitionActivity.this, "Gift "+giftList.size(), Toast.LENGTH_SHORT).show();
                    RebateGiftAdapter rebateGiftAdapter=new RebateGiftAdapter(getApplicationContext(),rebateList,giftList);
                    rebateListView.setAdapter(rebateGiftAdapter);


                }

                @Override
                public void onFailure(Call<RebateAndGiftModel> call, Throwable t) {
                    Toast.makeText(RequisitionActivity.this, "Couldnot Connect :( something wrong", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    /// Creating menu item on toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item=
        menu.add(Menu.NONE, ADD_REQUISITION_MENU, Menu.NONE, "Done");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case ADD_REQUISITION_MENU:
                RequisitionAddModel requisitionAddModel=new RequisitionAddModel();
                // add data to object

                ArrayList<ProductModelForTemplist> productList=arrayProduct;
                for(ProductModelForTemplist product:productList){
                    RequisitionAddModel.RequisitionDetailsModelForApp requisitionDetails=requisitionAddModel.new RequisitionDetailsModelForApp();
                    requisitionDetails.setProductName(product.getProductName());
                    requisitionDetails.setPrice(product.getPrice().intValue());
                    requisitionDetails.setQuantity(product.getQuantity());
                    requisitionDetails.setColorId(product.getColorId());
                    requisitionDetails.setIsLiveDummy(product.is_live_dummy());

                    requisitionAddModel.getRequisitionDetailsModelForApps().add(requisitionDetails);

                }
                addRequisition(requisitionAddModel);
                return true;

            default:
                return false;
        }
    }
    private void addRequisition(RequisitionAddModel requisitionAddModel){
        Call<RequisitionAddReturnDataModel> requisitionCallback=iRequisition.RequisitionAdd(requisitionAddModel);
        requisitionCallback.enqueue(new Callback<RequisitionAddReturnDataModel>() {
            @Override
            public void onResponse(Call<RequisitionAddReturnDataModel> call, Response<RequisitionAddReturnDataModel> response) {
                RequisitionAddReturnDataModel returnModel=(RequisitionAddReturnDataModel)response.body();
                Intent requisitionListIntent=new Intent(RequisitionActivity.this,RequisitionDetailsActivity.class);
                Toast.makeText(RequisitionActivity.this, returnModel.getMsg(), Toast.LENGTH_SHORT).show();
//                displayMessageDialog(getApplicationContext(),"Requisition Add",returnModel.getMsg(),requisitionListIntent);
            }

            @Override
            public void onFailure(Call<RequisitionAddReturnDataModel> call, Throwable t) {
                Toast.makeText(RequisitionActivity.this, "Requisition Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void loadRequisition(){}

    private void displayMessageDialog(Context context, String title, String message, final Intent successIntent){
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(successIntent!=null){
                            startActivity(successIntent);
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    public void setDate(final TextView textView, final String title){
        DatePickerDialog datePickerDialog = new DatePickerDialog(RequisitionActivity.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int month = monthOfYear + 1;
                if(month < 10 && dayOfMonth >= 10){
                    textView.setText(dayOfMonth + "/0" + month + "/" + year);
                }
                if(dayOfMonth < 10 && month >= 10) {
                    textView.setText( "0" +dayOfMonth + "/" + month+ "/" + year);
                }
                if(dayOfMonth < 10 && month < 10) {
                    textView.setText("0" + dayOfMonth + "/0" + month +"/"+ year);
                }
                if(month >= 10 && dayOfMonth >= 10){
                    textView.setText(dayOfMonth + "/" + month + "/" +year );
                }

            }
        }, year, month, day);
        datePickerDialog.setTitle(title);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();

    }
}
