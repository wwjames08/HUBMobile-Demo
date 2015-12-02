package com.hexagonmetrology.hub.hubmobiledemo.database;

import java.util.List;

import io.realm.Realm;

/**
 * Handles the data downloaded from the cloud
 * and parse it to their respective variable holders
 */
public class DataManager {

    private Realm realm;

    private List<String> machine_id;

    private String machine_status,
            machine_type,
            machine_location,
            cd_status,
            vibration_status,
            temperature_status,
            temperature_value,
            humidity_status,
            humidity_value;

    private List<String> event_timestamp,
            event_status;

    public void parseCloudData(Realm realm) {
        for (int i = 0; i < 3; i++) {
            event_timestamp.add(i, "12:00:00");
            event_status.add(i, "Program Running");
        }
        //Realm.deleteRealm(realm.getConfiguration());
        //Checks if there's machine data
        realm.beginTransaction(); //Start of write transaction
        for (int i = 0; i < 3; i++) { //Creates 3 pages
            HubDevice data = realm.createObject(HubDevice.class);
            data.setMachineID("" + i);
            data.setMachineStatus("running");
            data.setMachineType("7.10.7");
            data.setMachineLocation("Quonset");
            data.setCdStatus("bump");
            data.setVibrationStatus("high");
            data.setTemperatureStatus("ok");
            data.setTemperatureValue("25");
            data.setHumidityStatus("critical");
            data.setHumidityValue("78");
//                data.setEventTimestamp(event_timestamp);
//                data.setEventStatus(event_status);
        }
        realm.commitTransaction(); //End of write transaction, committing changes/updates

    }
}
