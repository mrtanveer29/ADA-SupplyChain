package com.jmjproduction.adasupplychain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.bohush.geometricprogressview.GeometricProgressView;

import IRepository.IPromotion;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import list_adapter.PromotionListAdapter;
import model.APIInitializer;
import model.Promotion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.promotionListView) RecyclerView promotionListView;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.placeholderImage) ImageView placeholderImage;
    @BindView(R.id.placeHolderLayout) View placeHolderLayout;
    @BindView(R.id.progressView) GeometricProgressView progressView;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    View hederLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Promotion Information");
        hederLayout=navigationView.getHeaderView(0);
        LoadHeaderInformation(hederLayout);

        loadPromotion();
        setSwipeRefreshLayoutListener();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setSwipeRefreshLayoutListener(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadPromotion();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private Call<Promotion[]> getPromotionCallback(){
        Retrofit retrofit= APIInitializer.initNetwork(this);
        IPromotion promotion=retrofit.create(IPromotion.class);
        Call<Promotion[]> promotionCallback= promotion.GetAllPromotion();
        return  promotionCallback;
    }
    private void loadPromotion(){

        getPromotionCallback().enqueue(new Callback<Promotion[]>() {
            @Override
            public void onResponse(Call<Promotion[]> call, Response<Promotion[]> response) {
                if(response.body()==null || response.body().length==0){
                    placeholderImage.setVisibility(View.VISIBLE);
                    progressView.setVisibility(View.GONE);
                    return;
                }
                placeHolderLayout.setVisibility(View.GONE);
                PromotionListAdapter promotionListAdapter=new PromotionListAdapter(getApplicationContext(),response.body());
                SlideInLeftAnimator animator=new SlideInLeftAnimator();
                animator.setAddDuration(1000);
                promotionListView.setItemAnimator(animator);
                promotionListView.setAdapter(promotionListAdapter);
            }

            @Override
            public void onFailure(Call<Promotion[]> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"No Promotion data is found.",Toast.LENGTH_LONG).show();
                placeholderImage.setVisibility(View.VISIBLE);
                progressView.setVisibility(View.GONE);
                Log.e("Url: ",call.request().url().toString());
            }
        });

    }
    public void LoadHeaderInformation(View headerlayout){

        TextView txtUserName=(TextView)hederLayout.findViewById(R.id.txtuser_name);
        TextView txtrolename=(TextView)hederLayout.findViewById(R.id.txtrolename);
        String full_name=sharedPreferences.getString("full_name","JMJ");
        txtUserName.setText(full_name);
        txtrolename.setText("Master Dealer");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_requistion) {
            // Handle the camera action
            Intent intent=new Intent(this,RequisitionDetailsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_delivery) {
            int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
            Intent intent=new Intent(this,DeliveryActivity.class);
            intent.putExtra("party_id",partyId);
            startActivity(intent);


        } else if (id == R.id.nav_inventory) {
            Intent intent=new Intent(this,InventoryActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_accounts) {
            Intent intent=new Intent(this,AccountsActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_payment) {
            Intent intent=new Intent(this,PaymentListActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_sign_out) {
            editor=sharedPreferences.edit();
            editor.clear();
            editor.commit();
            finish();
            Intent intent=new Intent(this,SplashScreenActivity.class);
            startActivity(intent);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
