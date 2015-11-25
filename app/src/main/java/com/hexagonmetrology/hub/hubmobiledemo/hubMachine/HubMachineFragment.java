package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hexagonmetrology.hub.hubmobiledemo.R;
import com.hexagonmetrology.hub.hubmobiledemo.sensorTiles.CrashDetection;
import com.hexagonmetrology.hub.hubmobiledemo.sensorTiles.Humidity;
import com.hexagonmetrology.hub.hubmobiledemo.sensorTiles.Temperature;
import com.hexagonmetrology.hub.hubmobiledemo.sensorTiles.Vibration;
import com.hexagonmetrology.hub.hubmobiledemo.database.HubDevice;

/**
 * Fragment: Creates and handles the layout of a connected machine
 * for the viewpager
 */
public class HubMachineFragment extends Fragment {

    MachineInfo machineInfo;
    ProgramStatus programStatus;
    CrashDetection crashDetection;
    Vibration vibration;
    Temperature temperature;
    Humidity humidity;

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

        machineInfo = new MachineInfo(getContext());
        crashDetection = new CrashDetection(getContext());
        vibration = new Vibration(getContext());
        temperature = new Temperature(getContext());
        humidity = new Humidity(getContext());

        machineInfo.setMachineInfo(getArguments().getString("machineStatus"),
                getArguments().getString("machineLocation"),
                getArguments().getString("machineId"));
/*
//        programStatus.setProgramStatus(getArguments().getStringArrayList("eventTimestamp"),
//                getArguments().getStringArrayList("eventStatus"));
*/
        crashDetection.updateSensorTile(getArguments().getString("cdStatus"));
        vibration.updateSensorTile(getArguments().getString("vibrationStatus"));
        temperature.updateSensorTile(getArguments().getString("temperatureStatus"),
                getArguments().getString("temperatureValue"));
        humidity.updateSensorTile(getArguments().getString("humidityStatus"),
                getArguments().getString("humidityValue"));


        return rootView;
    }// end onCreate()
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



