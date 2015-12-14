package com.hexagonmetrology.hub.hubmobiledemo.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 *This class is a Realm Object that will store the
 * data for each connected machine
 */
public class HubDevice extends RealmObject {

    @PrimaryKey
    private String machineID;

    private String machineStatus,
                    machineType,
                    machineLocation,
                    cdStatus,
                    vibrationStatus,
                    temperatureStatus,
                    temperatureValue,
                    humidityStatus,
                    humidityValue;


    public String getMachineID() {
        return machineID;
    }

    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachineLocation() {
        return machineLocation;
    }

    public void setMachineLocation(String machineLocation) {
        this.machineLocation = machineLocation;
    }

    public String getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }

    public String getVibrationStatus() {
        return vibrationStatus;
    }

    public void setVibrationStatus(String vibrationStatus) {
        this.vibrationStatus = vibrationStatus;
    }

    public String getTemperatureStatus() {
        return temperatureStatus;
    }

    public void setTemperatureStatus(String temperatureStatus) {
        this.temperatureStatus = temperatureStatus;
    }

    public String getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(String temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public String getHumidityStatus() {
        return humidityStatus;
    }

    public void setHumidityStatus(String humidityStatus) {
        this.humidityStatus = humidityStatus;
    }

    public String getHumidityValue() {
        return humidityValue;
    }

    public void setHumidityValue(String humidityValue) {
        this.humidityValue = humidityValue;
    }
}
