package com.jmjproduction.adasupplychain;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import IRepository.ITransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import list_adapter.TransactionListAdapter;
import model.APIInitializer;
import model.Transaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AccountsActivity extends AppCompatActivity {
    @BindView(R.id.accountStartDate)
    TextView accountStartDate;
    @BindView(R.id.accountEndDate) TextView accountEndDate;
    @BindView(R.id.transactionList) RecyclerView transactionList;
    @BindView(R.id.closingBalance) TextView closingBalance;
    @BindView(R.id.openingBalance) TextView openingBalance;
    SharedPreferences sharedPreferences;
    final Calendar c = Calendar.getInstance();

    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH);
    final int day = c.get(Calendar.DAY_OF_MONTH);

    @OnClick(R.id.accountStartDate)
    public void setAccountStartDate(View view){
        setDate(accountStartDate,"Select Start Date");

    }
    @OnClick(R.id.accountEndDate)
    public void setAccountEndDate(View view){
        setDate(accountEndDate,"Select End Date");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        getSupportActionBar().setTitle("Accounts Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_remove_white);

    }

    private void loadTransaction() {
        Retrofit retrofit= APIInitializer.initNetwork(this);
        ITransaction transactionListener=retrofit.create(ITransaction.class);
        int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
        transactionListener.getTransactionBuId(partyId,accountStartDate.getText().toString(),accountEndDate.getText().toString()).enqueue(new Callback<Transaction[]>() {
            @Override
            public void onResponse(Call<Transaction[]> call, Response<Transaction[]> response) {
                if(response.body()==null || response.body().length==0){
                    Toast.makeText(AccountsActivity.this, "No Data!!", Toast.LENGTH_SHORT).show();
                }else{

                    Transaction transaction=(Transaction)response.body()[0];
                    double opening=transaction.getOpeningBalance();
                    transaction=(Transaction)response.body()[response.body().length-1];
                    double closing=transaction.getClosingBalance();
                    openingBalance.setText(opening+" TK");
                    closingBalance.setText(closing+" TK");

                    TransactionListAdapter transactionListAdapter=new TransactionListAdapter(getApplicationContext(),response.body());
                    transactionList.setAdapter(transactionListAdapter);
                }

            }

            @Override
            public void onFailure(Call<Transaction[]> call, Throwable t) {
                Toast.makeText(AccountsActivity.this, "Something went wrong !! Couldnot fetch data", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setDate(final TextView textView, final String title){
        DatePickerDialog datePickerDialog = new DatePickerDialog(AccountsActivity.this, new DatePickerDialog.OnDateSetListener() {

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
                if(title.equals("Select End Date")){
                    loadTransaction();
                }
            }
        }, year, month, day);
        datePickerDialog.setTitle(title);
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
