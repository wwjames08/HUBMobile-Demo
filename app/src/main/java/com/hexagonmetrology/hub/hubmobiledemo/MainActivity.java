package com.hexagonmetrology.hub.hubmobiledemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.hexagonmetrology.hub.hubmobiledemo.database.HubDevice;
import com.hexagonmetrology.hub.hubmobiledemo.hubMachine.HubMachineFragment;
import com.hexagonmetrology.hub.hubmobiledemo.settings.Settings;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Start of the application and where everything goes through
 */
public class MainActivity extends FragmentActivity { //implements HttpManager.CloudCallback

    /* Database instance */
    private Realm realm;

    /* Navigation Drawer */
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    /* Adapters */
    private ConnectedMachineAdapter connectedMachineAdapter;
    private RecyclerView connectedMachineRecyclerView;

    /* ViewPager */
    private ViewPager mPager; //Widget; handles animation and allows swiping horizontally
    private HubMachinePagerAdapter mPagerAdapter; //Adapter; provides the pages to the view pager widget

    /**
     * Start of application
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Instantiate a ViewPager and a PagerAdapter of connected
           machines for the user to scroll through horizontally */
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mPagerAdapter = new HubMachinePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        /* Creates the RecyclerView and Adapter for the list of connected
           machines in the navigational drawer */
        connectedMachineRecyclerView = (RecyclerView) findViewById(R.id.connectedMachinesList);
        connectedMachineAdapter = new ConnectedMachineAdapter();
        connectedMachineRecyclerView.setAdapter(connectedMachineAdapter);
        connectedMachineRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /* Creates HubDevice objects for the database */
        realm = Realm.getInstance(this);
        RealmResults<HubDevice> hubDevices = realm.where(HubDevice.class).findAll();
        if (hubDevices.size() == 0) {
            realm.beginTransaction(); //Start of write transaction
            for (int i = 0; i < 4; i++) { //Creates 3 pages
                HubDevice data = realm.createObject(HubDevice.class);
                data.setMachineID("" + i);
                data.setMachineStatus("running");
                data.setMachineType("7.10.7");
                data.setMachineLocation("Quonset");
                data.setCdStatus("bump");
                data.setVibrationStatus("high");
                data.setTemperatureStatus("ok");
                data.setTemperatureValue("25");
                data.setHumidityStatus("critical_low");
                data.setHumidityValue("78");
//                data.setEventTimestamp(event_timestamp);
//                data.setEventStatus(event_status);
            }
            realm.commitTransaction(); //End of write transaction, committing changes/updates
            super.onCreate(savedInstanceState);
        } else {
            mPagerAdapter.setData(hubDevices);
            connectedMachineAdapter.setData(hubDevices);
        }

        /* Navigation Drawer toggle*/
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,             /* host Activity */
                mDrawerLayout,    /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close   /* "close drawer" description */
        ) {
            /* Closes navigation drawer */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            /* Open navigation drawer */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle); // Set the drawer toggle as the DrawerListener

        /* Shows the navigation drawer button */
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    /**
     * When back button is pressed: closes the navigation drawer
     * or goes back a page in the ViewPager.
     */
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (mPager.getCurrentItem() != 0) {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents the HubMachineFragment objects, in
     * sequence.
     */
    private class HubMachinePagerAdapter extends FragmentPagerAdapter {
        public HubMachinePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        /* This is where the array of connected machine data
         * is applied to a list for the adapter
         */
        List<HubDevice> data = new ArrayList<>();

        /**
         * Creates the HubMachineFragement at the current
         * position of the ViewPager
         * @param position position in the ViewPager
         * @return the Fragment associated with a specified position
         */
        @Override
        public Fragment getItem(int position) {
            return HubMachineFragment.newInstance(data.get(position));
        }

        /**
         * Creates the number of pages based on the
         * size of the connected machine list array.
         * @return the size of the connected machine array
         */
        @Override
        public int getCount() {
            return data.size();
        }

        public void setData(List<HubDevice> listData) {
            data = listData;
            notifyDataSetChanged();
        }
    }

    /**
     * Other Stuff
     */
    public void openSettings(View view) {
        startActivity(new Intent(this, Settings.class));
    }
}
