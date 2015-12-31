package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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

    public static final String APP_PREFS = "applicationPrefs";
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    final String DEFAULT = "n/a";

    ImageView mMachineStatusIcon;
    TextView mMachineLocation;
    TextView mMachineSerial;

    ProgramStatusAdapter programStatusAdapter;
    RecyclerView programStatusRecyclerView;

    View crashDetectionView;
    TextView mCdStatusText;
    ImageView mCdStatusRing;
    View vibrationView;
    TextView mVibrationStatusText;
    ImageView mVibrationStatusRing;
    View temperatureView;
    TextView mTemperatureStatus;
    ImageView mTemperatureRing;
    TextView mTemperatureUnit;
    View humidityView;
    TextView mHumidityStatus;
    ImageView mHumidityRing;

//    static ArrayList<String> timeStamps = new ArrayList<>(),
//                             eventStatuses = new ArrayList<>();

    public static HubMachineFragment newInstance(HubDevice hubDevice) {
        Bundle bundle = new Bundle();

        HubMachineFragment fragment = new HubMachineFragment();
        bundle.putString("machineId", hubDevice.getMachineID());
        bundle.putString("machineStatus", hubDevice.getMachineStatus());
        bundle.putString("machineType", hubDevice.getMachineType());
        bundle.putString("machineLocation", hubDevice.getMachineLocation());
//        bundle.putStringArrayList("eventTimestamp", timeStamps);
//        bundle.putStringArrayList("eventStatus", eventStatuses);
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

        settings = getActivity().getSharedPreferences(APP_PREFS, 0);
        editor = settings.edit();

        mMachineStatusIcon = (ImageView) rootView.findViewById(R.id.machineInfoIcon);
        mMachineLocation = (TextView) rootView.findViewById(R.id.machineInfoLocation);
        mMachineSerial = (TextView) rootView.findViewById(R.id.machineInfoSerial);

        programStatusRecyclerView = (RecyclerView) rootView.findViewById(R.id.event_history_list);
        programStatusAdapter = new ProgramStatusAdapter();
        programStatusRecyclerView.setAdapter(programStatusAdapter);
        programStatusRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        crashDetectionView = rootView.findViewById(R.id.crashDetectionTile);
        mCdStatusText = (TextView) crashDetectionView.findViewById(R.id.tileStatusText);
        mCdStatusRing = (ImageView) crashDetectionView.findViewById(R.id.tileStatusRing);

        vibrationView = rootView.findViewById(R.id.vibrationTile);
        mVibrationStatusText = (TextView) vibrationView.findViewById(R.id.tileStatusText);
        mVibrationStatusRing = (ImageView) vibrationView.findViewById(R.id.tileStatusRing);

        temperatureView = rootView.findViewById(R.id.temperatureTile);
        mTemperatureStatus = (TextView) temperatureView.findViewById(R.id.tileStatusText);
        mTemperatureRing = (ImageView) temperatureView.findViewById(R.id.tileStatusRing);
        mTemperatureUnit = (TextView) temperatureView.findViewById(R.id.tileUnitText);

        humidityView = rootView.findViewById(R.id.humidityTile);
        mHumidityStatus = (TextView) humidityView.findViewById(R.id.tileStatusText);
        mHumidityRing = (ImageView) humidityView.findViewById(R.id.tileStatusRing);

        setMachineInfo(getArguments().getString("machineStatus", "disconnected"),
                getArguments().getString("machineLocation", DEFAULT),
                getArguments().getString("machineId", DEFAULT));

        programStatusAdapter.setData(getArguments().getStringArrayList("eventTimestamp"),
                getArguments().getStringArrayList("eventStatus"));

        setSensorTiles(getArguments().getString("cdStatus", DEFAULT),
                getArguments().getString("vibrationStatus", DEFAULT),
                getArguments().getString("temperatureValue", DEFAULT),
                getArguments().getString("temperatureStatus", DEFAULT),
                getArguments().getString("humidityValue", DEFAULT),
                getArguments().getString("humidityStatus", DEFAULT));

        mTemperatureUnit.setText(settings.getString("tempUnit", "°C"));

        return rootView;
    }// end onCreateView()

    /**
     * When the fragment is resumed
     */
    @Override
    public void onResume(){
        setMachineInfo(getArguments().getString("machineStatus", "disconnected"),
                getArguments().getString("machineLocation", DEFAULT),
                getArguments().getString("machineId", DEFAULT));

        programStatusAdapter.setData(getArguments().getStringArrayList("eventTimestamp"),
                getArguments().getStringArrayList("eventStatus"));

        setSensorTiles(getArguments().getString("cdStatus", DEFAULT),
                getArguments().getString("vibrationStatus", DEFAULT),
                getArguments().getString("temperatureValue", DEFAULT),
                getArguments().getString("temperatureStatus", DEFAULT),
                getArguments().getString("humidityValue", DEFAULT),
                getArguments().getString("humidityStatus", DEFAULT));

        mTemperatureUnit.setText(settings.getString("tempUnit", "°C"));
        super.onResume();
    }

    /* Machine Info */
    private void setMachineInfo(String machineStatus, String machineLocation, String machineText){

        setMachineStatus(machineStatus);
        mMachineLocation.setText(machineLocation);
        mMachineSerial.setText(machineText);
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
    }
        /* Program Status */
        //Here you'll want to implement the code for the recyclerview to
        //list the events that have pasted.

        /* Sensor Tiles */

    private void setSensorTiles(String cdStatus, String vibrationStatus,
                                String temperatureValue, String temperatureStatus,
                                String humidityValue, String humidityStatus){
        setCdTileStatus(cdStatus);
        setVibrationTileStatus(vibrationStatus);
        setTemperatureTileStatus(temperatureValue, temperatureStatus);
        setHumidityTileStatus(humidityValue, humidityStatus);
    }


    private void setCdTileStatus(String cdStatus){
        mCdStatusText.setText(String.format("%s%s", cdStatus.substring(0, 1).toUpperCase(), cdStatus.substring(1)));
        switch (cdStatus) {
            case "clear":
                mCdStatusRing.setImageResource(R.drawable.st_blue_ring);
                break;
            case "bump":
                mCdStatusRing.setImageResource(R.drawable.st_yellow_ring);
                break;
            case "crash":
                mCdStatusRing.setImageResource(R.drawable.st_red_ring);
                break;
            case "disconnected":
                mCdStatusRing.setImageResource(R.drawable.st_gray_ring);
                break;
            default:
                mCdStatusRing.setImageResource(R.drawable.st_gray_ring);
                break;
        }
    }

    private void setVibrationTileStatus(String vibrationStatus){
        mVibrationStatusText.setText(String.format("%s%s", vibrationStatus.substring(0, 1).toUpperCase(), vibrationStatus.substring(1)));
        switch (vibrationStatus) {
            case "low":
                mVibrationStatusRing.setImageResource(R.drawable.st_blue_ring);
                break;
            case "med":
                mVibrationStatusRing.setImageResource(R.drawable.st_yellow_ring);
                break;
            case "high":
                mVibrationStatusRing.setImageResource(R.drawable.st_red_ring);
                break;
            case "disconnected":
                mVibrationStatusRing.setImageResource(R.drawable.st_gray_ring);
                break;
            default:
                mVibrationStatusRing.setImageResource(R.drawable.st_gray_ring);
                break;
        }
    }

    private void setTemperatureTileStatus(String temperatureValue, String temperatureStatus){
        mTemperatureStatus.setText(String.format("%s°", temperatureValue));
        switch (temperatureStatus) {
            case "ok":
                mTemperatureRing.setImageResource(R.drawable.st_blue_ring);
                break;
            case "warning_low":
            case "warning_high":
                mTemperatureRing.setImageResource(R.drawable.st_yellow_ring);
                break;
            case "critical_low":
            case "critical_high":
            case "1hr_temp_swing":
            case "24hr_temp_swing":
                mTemperatureRing.setImageResource(R.drawable.st_red_ring);
                break;
            case "disconnected":
                mTemperatureRing.setImageResource(R.drawable.st_gray_ring);
                break;
            default:
                mTemperatureRing.setImageResource(R.drawable.st_gray_ring);
                break;
        }
    }
    private void setHumidityTileStatus(String humidityValue, String humidityStatus){
        mHumidityStatus.setText(String.format("%s%%", humidityValue));
        switch (humidityStatus) {
            case "ok":
                mHumidityRing.setImageResource(R.drawable.st_blue_ring);
                break;
            case "warning_low":
            case "warning_high":
                mHumidityRing.setImageResource(R.drawable.st_yellow_ring);
                break;
            case "critical_low":
            case "critical_high":
                mHumidityRing.setImageResource(R.drawable.st_red_ring);
                break;
            case "disconnected":
                mHumidityRing.setImageResource(R.drawable.st_gray_ring);
                break;
            default:
                mHumidityRing.setImageResource(R.drawable.st_gray_ring);
                break;
        }
    }
}//Class ends


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



