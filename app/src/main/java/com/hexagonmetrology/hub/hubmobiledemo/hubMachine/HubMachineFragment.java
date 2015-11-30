package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hexagonmetrology.hub.hubmobiledemo.R;
import com.hexagonmetrology.hub.hubmobiledemo.database.HubDevice;

/**
 * Fragment: Creates and handles the layout of a connected machine
 * for the viewpager
 */
public class HubMachineFragment extends Fragment {

    private final String DEFAULT = "n/a";

    ImageView mMachineStatusIcon;
    TextView mMachineLocation;
    TextView mMachineSerial;

    private ProgramStatusAdapter programStatusAdapter;
    private RecyclerView programStatusRecyclerView;

    View crashDetectionView;
    TextView mCdStatusText;
    ImageView mCdStatusRing;
    View vibrationView;
    TextView mVibrationStatusText;
    ImageView mVibrationStatusRing;
    View temperatureView;
    TextView mTemperatureStatus;
    ImageView mTemperatureRing;
    View humidityView;
    TextView mHumidityStatus;
    ImageView mHumidityRing;

    public static HubMachineFragment newInstance(HubDevice hubDevice) {
        Bundle bundle = new Bundle();
        HubMachineFragment fragment = new HubMachineFragment();
        bundle.putString("machineId", hubDevice.getMachineID());
        bundle.putString("machineStatus", hubDevice.getMachineStatus());
        bundle.putString("machineType", hubDevice.getMachineType());
        bundle.putString("machineLocation", hubDevice.getMachineLocation());
//        bundle.putStringArrayList("eventTimestamp", (ArrayList) hubDevice.getEventTimestamp());
//        bundle.putStringArrayList("eventStatus", (ArrayList) hubDevice.getEventStatus());
        bundle.putString("cdStatus", hubDevice.getCdStatus());
        bundle.putString("vibrationStatus", hubDevice.getVibrationStatus());
        bundle.putString("temperatureStatus", hubDevice.getTemperatureStatus());
        bundle.putString("temperatureValue", hubDevice.getTemperatureValue());
        bundle.putString("humidityStatus", hubDevice.getHumidityStatus());
        bundle.putString("humidityValue", hubDevice.getHumidityValue());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_hub_machine, container, false);

        mMachineStatusIcon = (ImageView) rootView.findViewById(R.id.machineStatusIcon);
        mMachineLocation = (TextView) rootView.findViewById(R.id.machineStatusLocation);
        mMachineSerial = (TextView) rootView.findViewById(R.id.machineStatusSerial);


        crashDetectionView = rootView.findViewById(R.id.crashDetectionTile);
        mCdStatusText = (TextView) crashDetectionView.findViewById(R.id.tileStatusText);
        mCdStatusRing = (ImageView) crashDetectionView.findViewById(R.id.tileStatusRing);

        vibrationView = rootView.findViewById(R.id.vibrationTile);
        mVibrationStatusText = (TextView) vibrationView.findViewById(R.id.tileStatusText);
        mVibrationStatusRing = (ImageView) vibrationView.findViewById(R.id.tileStatusRing);

        temperatureView = rootView.findViewById(R.id.temperatureTile);
        mTemperatureStatus = (TextView) temperatureView.findViewById(R.id.tileStatusText);
        mTemperatureRing = (ImageView) temperatureView.findViewById(R.id.tileStatusRing);

        humidityView = rootView.findViewById(R.id.humidityTile);
        mHumidityStatus = (TextView) humidityView.findViewById(R.id.tileStatusText);
        mHumidityRing = (ImageView) humidityView.findViewById(R.id.tileStatusRing);

        setMachineInfo(getArguments().getString("machineStatus"),
                getArguments().getString("machineLocation"),
                getArguments().getString("machineId"));

        mCdStatusText.setText(getArguments().getString("cdStatus", DEFAULT));
        mCdStatusRing.setImageResource(R.drawable.st_green_ring);
        return rootView;
    }// end onCreate()


    /* Machine Info */
    private void setMachineInfo(String machineStatus, String machineLocation, String machineText){

        setMachineStatus(machineStatus);
        mMachineLocation.setText(getArguments().getString("machineLocation", DEFAULT));
        mMachineSerial.setText(getArguments().getString("machineId", DEFAULT));
    }

    /* Setting the Machine Status Icon and Text Status */
    private void setMachineStatus(String machineStatus) {
        // Changes the ImageView depending on the Machine Status received
        switch (machineStatus) {
            case "idle":
                mMachineStatusIcon.setImageResource(R.drawable.ms_idle);
                break;
            case "running":
                mMachineStatusIcon.setImageResource(R.drawable.ms_running);
                break;
            case "warning":
                mMachineStatusIcon.setImageResource(R.drawable.ms_warning);
                break;
            case "critical":
                mMachineStatusIcon.setImageResource(R.drawable.ms_error);
                break;
            case "disconnected":
                mMachineStatusIcon.setImageResource(R.drawable.ms_offline);
                break;
            default:
                mMachineStatusIcon.setImageResource(R.drawable.ms_offline);
        }


        /* Program Status */


/*        programStatusRecyclerView = (RecyclerView) findViewById(R.id.event_history_list);
        programStatusAdapter = new ProgramStatusAdapter();
        programStatusRecyclerView.setAdapter(programStatusAdapter);
        programStatusRecyclerView.setLayoutManager(new LinearLayoutManager(context));*/

        /* Sensor Tiles */


    }

















}


/***************
 * Misc. Stuff *
 ***************/

    /*    public void openGraphCd(View view) {
        Intent intent = new Intent(this, GraphActivity.class);
        intent.putExtra("sensorType", "Crash Detection");
        intent.putExtra("sensorStatus", "Clear");
        startActivity(intent);
    }

    public void openGraphV(View view) {
        Intent intent = new Intent(this, GraphActivity.class);
        intent.putExtra("sensorType", "VibrationTile");
        intent.putExtra("sensorStatus", "High");
        startActivity(intent);
    }

    public void openGraphT(View view) {
        Intent intent = new Intent(this, GraphActivity.class);
        intent.putExtra("sensorType", "TemperatureTile");
        intent.putExtra("sensorStatus", "22°");
        startActivity(intent);
    }

    public void openGraphH(View view) {
        Intent intent = new Intent(this, GraphActivity.class);
        intent.putExtra("sensorType", "Humidity");
        intent.putExtra("sensorStatus", "47%");
        startActivity(intent);
    }*/



