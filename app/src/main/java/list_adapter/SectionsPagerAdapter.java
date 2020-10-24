package list_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Code Freak Tanveer on 20/02/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments=new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a RecieveDeliveryFragment (defined as a static inner class below).
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Not Recieved";
            case 1:
                return "Recieved";

        }
        return null;
    }
    public void setFragment(Fragment fragment){
        this.fragments.add(fragment);
    }
}