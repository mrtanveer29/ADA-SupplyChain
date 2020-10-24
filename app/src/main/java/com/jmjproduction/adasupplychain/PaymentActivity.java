package com.jmjproduction.adasupplychain;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import IRepository.IPayment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.APIInitializer;
import model.Bank;
import model.PaymentMethod;
import model.SalesRepresentative;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PaymentActivity extends AppCompatActivity {
    @BindView(R.id.uploadFile)
    Button uploadButton;
    @BindView(R.id.spinpaymentMethod)
    Spinner spinpaymentMethod;
    @BindView(R.id.spinBankname)
    Spinner spinBankname;
    @BindView(R.id.spinSalesRepresentative)
    Spinner spinSalesRepresentative;
    @BindView(R.id.edittxtDepositDate) EditText edittxtdepositDate;
    private static String imagePath;
    private static final int GALLERY_REQUST =12223 ;
    private CameraPhoto cameraPhoto;
    private GalleryPhoto galleryPhoto;
    private final int CAMERA_REQUEST=13323;
    private DatePickerDialog datePicker;
    @OnClick(R.id.uploadFile)
    public void uploadFile(View view){
        uploadButton.performLongClick();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payment");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);
        LoadPaymentMethod();

        edittxtdepositDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePicker = new DatePickerDialog(PaymentActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                edittxtdepositDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePicker.show();
        }
        });
        //LoadSalesRepresentative();
        registerForContextMenu(uploadButton);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnPaymentPost);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Upload Option");
        menu.add(Menu.NONE, 1, Menu.NONE, "Choose From Camera");
        menu.add(Menu.NONE, 2, Menu.NONE, "Choose From Gallery");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK){
            if(requestCode==CAMERA_REQUEST){
                imagePath=cameraPhoto.getPhotoPath();
                try {
                    Bitmap image= ImageLoader.init().from(imagePath).requestSize(128,128).getBitmap();
//                    imgProfile.setImageBitmap(image);
                } catch (FileNotFoundException e) {
                    Toast.makeText(PaymentActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }else if(requestCode==GALLERY_REQUST){
                Uri uri=data.getData();
                galleryPhoto.setPhotoUri(uri);
                imagePath=galleryPhoto.getPath();
                try {
                    Bitmap image= ImageLoader.init().from(imagePath).requestSize(128,128).getBitmap();
//                    imgProfile.setImageBitmap(image);
                } catch (FileNotFoundException e) {
                    Toast.makeText(PaymentActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public void LoadPaymentMethod(){
            final Retrofit retrofit= APIInitializer.initNetwork(this);
        retrofit.create(IPayment.class).GetAllPaymentMethod().enqueue(new Callback<PaymentMethod[]>() {
            @Override
            public void onResponse(Call<PaymentMethod[]> call, Response<PaymentMethod[]> response) {


                ArrayAdapter paymethodList=new ArrayAdapter<PaymentMethod>(getApplicationContext(),android.R.layout.simple_list_item_1,response.body());
                spinpaymentMethod.setAdapter(paymethodList);
                spinpaymentMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String tempItem=spinpaymentMethod.getSelectedItem().toString();
                        Toast.makeText(PaymentActivity.this, "Selected Item"+tempItem, Toast.LENGTH_SHORT).show();
                        if (tempItem.equals("Cash")){
                            LinearLayout cashlayout = (LinearLayout) findViewById(R.id.cashLayout);
                            LinearLayout banklayout = (LinearLayout) findViewById(R.id.bankLayout);
                            banklayout.animate().translationY(0);
                            banklayout.setVisibility(View.GONE);
                            cashlayout.animate().alpha(1.0f);
                            cashlayout.setVisibility(View.VISIBLE);

                            LoadSalesRepresentative();

                        }else if (tempItem.equals("Bank") || tempItem.equals("Cheque")){
                            LinearLayout banklayout = (LinearLayout) findViewById(R.id.bankLayout);
                            LinearLayout cashlayout = (LinearLayout) findViewById(R.id.cashLayout);
                            cashlayout.animate().translationY(0);
                            cashlayout.setVisibility(View.GONE);
                            banklayout.animate().alpha(1.0f);
                            banklayout.setVisibility(View.VISIBLE);
                            LoadBank();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }


                });


            }

            @Override
            public void onFailure(Call<PaymentMethod[]> call, Throwable t) {

            }
        });
    }
    public void LoadBank(){
        final Retrofit retrofit= APIInitializer.initNetwork(this);
        retrofit.create(IPayment.class).GetAllBank().enqueue(new Callback<Bank[]>() {
            @Override
            public void onResponse(Call<Bank[]> call, Response<Bank[]> response) {
                ArrayAdapter bankList=new ArrayAdapter<Bank>(getApplicationContext(),android.R.layout.simple_list_item_1,response.body());
                spinBankname.setAdapter(bankList);
            }

            @Override
            public void onFailure(Call<Bank[]> call, Throwable t) {

            }
        });
    }
    public void LoadSalesRepresentative(){
        final Retrofit retrofit= APIInitializer.initNetwork(this);
        retrofit.create(IPayment.class).GetAllSalesRepresentative("Master Dealer").enqueue(new Callback<SalesRepresentative[]>() {
            @Override
            public void onResponse(Call<SalesRepresentative[]> call, Response<SalesRepresentative[]> response) {
                ArrayAdapter empList=new ArrayAdapter<SalesRepresentative>(getApplicationContext(),android.R.layout.simple_list_item_1,response.body());
                spinSalesRepresentative.setAdapter(empList);
            }

            @Override
            public void onFailure(Call<SalesRepresentative[]> call, Throwable t) {

            }
        });
    }



}
