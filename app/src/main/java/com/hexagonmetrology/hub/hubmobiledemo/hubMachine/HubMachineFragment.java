package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.content.SharedPreferences;
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
import com.hexagonmetrology.hub.hubmobiledemo.sensorTiles.CrashDetection;
import com.hexagonmetrology.hub.hubmobiledemo.sensorTiles.Humidity;
import com.hexagonmetrology.hub.hubmobiledemo.sensorTiles.Temperature;
import com.hexagonmetrology.hub.hubmobiledemo.sensorTiles.Vibration;

/**
 * Fragment: Creates and handles the layout of a connected machine
 * for the viewpager
 */
public class HubMachineFragment extends Fragment {

    public static final String APP_PREFS = "applicationPrefs";
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    final String DEFAULT = "n/a";

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

    MachineInfo machineInfo;
    CrashDetection cdTile;
    Vibration vTile;
    Temperature tTile;
    Humidity hTile;

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

        machineInfo = new MachineInfo(rootView.getContext());
        cdTile = new CrashDetection(getContext());
        vTile = new Vibration(getContext());
        tTile = new Temperature(getContext());
        hTile = new Humidity(getContext());

        machineInfo.setup(setMachineStatusIcon(getArguments().getString("machineStatus", "disconnected")),
                            getArguments().getString("machineLocation", "Hello"),
                            getArguments().getString("machineId", DEFAULT));

       // cdTile.updateSensorTile();
       // cdTile.updateSensorTile(getArguments().get);
        super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }// end onCreate()

    /* Machine Info */

    /* Setting the Machine Status Icon and Text Status */
    private int setMachineStatusIcon(String machineStatus) {
        int imageResource = 0;
        // Changes the ImageView depending on the Machine Status received
        switch (machineStatus) {
            case "idle":
               imageResource = R.drawable.ms_idle;
                break;
            case "running":
               imageResource = R.drawable.ms_running;
                break;
            case "warning":
                imageResource = R.drawable.ms_warning;
                break;
            case "critical":
                imageResource = R.drawable.ms_error;
                break;
            case "disconnected":
                imageResource = R.drawable.ms_offline;
                break;
            default:
                imageResource = R.drawable.ms_offline;
        }
        return  imageResource;
    }
        /* Program Status */

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



