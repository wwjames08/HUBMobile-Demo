package com.hexagonmetrology.hub.hubmobiledemo.database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    /*********************
     * Mock Machine Data *
     *********************/

    private JSONArray mockData = new JSONArray();


    private JSONObject getJsonObj1() {
        JSONObject mockMachine1 = new JSONObject();
        JSONArray sensorData1 = new JSONArray();
        try {
            sensorData1.put(0, "bump");      //CD
            sensorData1.put(1, "low");      //Vib
            sensorData1.put(2, "24");       //Tem
            sensorData1.put(3, "ok");
            sensorData1.put(4, "89");       //Hum
            sensorData1.put(5, "critical");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            mockMachine1.put("time_stamp", "12:00:00");
            mockMachine1.put("machine_serial", "101");
            mockMachine1.put("machine_type", "4.5.4");
            mockMachine1.put("machine_location", "Quonset");
            mockMachine1.put("event_timestamp", "12:01:00");
            mockMachine1.put("event_description", "running");
            mockMachine1.put("sensor_data", sensorData1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mockMachine1;
    }

    private JSONObject getJsonObj2() {
        JSONObject mockMachine2 = new JSONObject();
        JSONArray sensorData2 = new JSONArray();
        try {
            sensorData2.put(0, "clear");     //CD
            sensorData2.put(1, "high");       //Vib
            sensorData2.put(2, "30");       //Tem
            sensorData2.put(3, "warning");
            sensorData2.put(4, "51");       //Hum
            sensorData2.put(5, "ok");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            mockMachine2.put("time_stamp", "12:00:00");
            mockMachine2.put("machine_serial", "102");
            mockMachine2.put("machine_type", "7.10.7");
            mockMachine2.put("machine_location", "Quonset");
            mockMachine2.put("event_timestamp", "12:01:00");
            mockMachine2.put("event_description", "running");
            mockMachine2.put("sensor_data", sensorData2);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mockMachine2;
    }

    public JSONArray getMockData() {
        mockData.put(getJsonObj1());
        mockData.put(getJsonObj2());
        return mockData;
    }


}
