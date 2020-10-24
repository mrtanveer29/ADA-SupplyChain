package com.jmjproduction.adasupplychain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import IRepository.IdeliveryListInfo;
import butterknife.BindView;
import list_adapter.DeliveryListAdapter;
import list_adapter.SectionsPagerAdapter;
import model.APIInitializer;
import model.DeliveryListInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DeliveryActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private TabLayout tablayout;
    //SharedPreferences sharedPreferences=getSharedPreferences("ADASCM",DeliveryActivity.MODE_PRIVATE);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        //sharedPreferences=getSharedPreferences("ADASCM",MODE_PRIVATE);
        getSupportActionBar().setTitle("Delivery List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_remove_white);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        int partyId=getIntent().getIntExtra("party_id",0);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.setFragment(PendingDeliveryFragment.newInstance(partyId));
        mSectionsPagerAdapter.setFragment(RecieveDeliveryFragment.newInstance());


        // Set up the ViewPager with the sections adapter.
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tablayout.setupWithViewPager(mViewPager);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delivery, menu);
        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class RecieveDeliveryFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        SharedPreferences sharedPreferences;
        private static final String ARG_SECTION_NUMBER = "section_number";
        public RecieveDeliveryFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static RecieveDeliveryFragment newInstance() {
            RecieveDeliveryFragment fragment = new RecieveDeliveryFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_delivery, container, false);
            RecyclerView deliveryRecieveList= (RecyclerView) rootView.findViewById(R.id.receivedDeliverylist);
            //DeliveryListAdapter deliveryListAdapter=new DeliveryListAdapter(getActivity(),);
            //deliveryRecieveList.setAdapter(deliveryListAdapter);
            return rootView;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

}


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

    }
class PendingDeliveryFragment extends Fragment {
    private int partyId;
    /**

     * The fragment argument representing the section number for this
     * fragment.
     */

    private static final String ARG_SECTION_NUMBER = "section_number";
    @BindView(R.id.notReceivedlist) RecyclerView notReceivedList;
    public PendingDeliveryFragment(int id) {
        partyId=id;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PendingDeliveryFragment newInstance(int id) {
        PendingDeliveryFragment fragment = new PendingDeliveryFragment(id);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delivery, container, false);
        final RecyclerView deliveryRecieveList= (RecyclerView) rootView.findViewById(R.id.notReceivedlist);
//        int partyId=Integer.parseInt(sharedPreferences.getString("party_id","0"));
        final Retrofit retrofit= APIInitializer.initNetwork(getActivity());
        retrofit.create(IdeliveryListInfo.class).GetAllDeliveryListInfo(partyId).enqueue(new Callback<DeliveryListInfo[]>() {
            @Override
            public void onResponse(Call<DeliveryListInfo[]> call, Response<DeliveryListInfo[]> response) {
                DeliveryListAdapter deliveryListAdapter=new DeliveryListAdapter(getActivity(),response.body());
                deliveryRecieveList.setAdapter(deliveryListAdapter);
            }

            @Override
            public void onFailure(Call<DeliveryListInfo[]> call, Throwable t) {
                Toast.makeText(getActivity(), "No Data Found!!", Toast.LENGTH_LONG).show();
            }
        });
        //DeliveryListAdapter deliveryListAdapter=new DeliveryListAdapter(getActivity());
        //deliveryRecieveList.setAdapter(deliveryListAdapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




}