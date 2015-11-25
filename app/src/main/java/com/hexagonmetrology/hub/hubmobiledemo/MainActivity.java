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

import com.hexagonmetrology.hub.hubmobiledemo.database.DataManager;
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

    private Realm realm;
    private DataManager data;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private ConnectedMachineAdapter connectedMachineAdapter;
    private RecyclerView connectedMachineRecyclerView;

    private static final int NUM_PAGES = 1; //The number of pages to shown.
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private HubMachineAdapter mPagerAdapter;

    /**
     * Start of application
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Instantiate a ViewPager and a PagerAdapter of connected
         * machines for the user to scroll through horizontally
         */
        mPager = (ViewPager) findViewById(R.id.hubMachinePager);
        mPagerAdapter = new HubMachineAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        /**
         * Creates the RecyclerView and Adapter for the list of connected
         * machines in the navigational drawer
         */
        connectedMachineRecyclerView = (RecyclerView) findViewById(R.id.connectedMachinesList);
        connectedMachineAdapter = new ConnectedMachineAdapter();
        connectedMachineRecyclerView.setAdapter(connectedMachineAdapter);
        connectedMachineRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /**
         * Sets each page of pageview to their respective unique machine ID
         */
/*        realm = Realm.getInstance(this);
        //Realm.deleteRealm(realm.getConfiguration());
        RealmResults<MockMachine> mockMachine = realm.where(MockMachine.class).findAll();
        //Checks if there's machine data
        if(mockMachine.size() == 0){ //If no machine data, populate it
            realm.beginTransaction(); //Start of write transaction
            for(int i = 0; i < 3; i++){ //Creates 3 pages
                MockMachine data = realm.createObject(MockMachine.class);
                data.setMachineID("" + i);
            }
            realm.commitTransaction(); //End of write transaction, committing changes/updates
            super.onCreate(savedInstanceState);
        }
        else{
            mPagerAdapter.setData(mockMachine);
            connectedMachineAdapter.setData(mockMachine);
        }*/
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


        /*Navigation Drawer toggle*/
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,             /* host Activity */
                mDrawerLayout,    /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close   /* "close drawer" description */
        ) {
            /* Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            /* Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle); // Set the drawer toggle as the DrawerListener

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

/*    @Override
    public void received(final DataManager dataManager) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                machineInfo.setupMachineInfo(dataManager);
            }
        });
    }*/

    /**
     * For viewpager
     */
    /* For when user hits the back button */
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (mPager.getCurrentItem() != 0) {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        } /*else if (mPager.getCurrentItem() == 0) {
            if (count == 0){
                Toast.makeText(getApplication(), "Press back again to exit.",
                        Toast.LENGTH_SHORT).show();
                count++;
            }else if (count == 1) {
                super.onBackPressed();
            }
        }*/ //To exit application on two back press
    }

    /**
     * A simple pager adapter that represents the HubMachineFragment objects, in
     * sequence.
     */
    private class HubMachineAdapter extends FragmentPagerAdapter {
        public HubMachineAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        /* This is where the array of connected machine data
         * is applied to a list for the adapter
         */
        List<HubDevice> data = new ArrayList<>();//data is the individual object

        /**
         * Displays the connected machine based on the position
         * of the adapter
         *
         * @param position position in the recyclerview
         * @return the Fragment associated with a specified position
         */
        @Override
        public Fragment getItem(int position) {
            return HubMachineFragment.newInstance(data.get(position));
        }

        /**
         * Gets the size of the array list holding the
         * connecting machine (The amount of machines
         * that are connected)
         *
         * @return the number of views available.
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
