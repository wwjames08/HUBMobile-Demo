package com.hexagonmetrology.hub.hubmobiledemo.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 *
 */
public class MockMachine extends RealmObject {

    @PrimaryKey //Sets unique identifier for each page
    private String machineID;

    public String getMachineID() {
        return machineID;
    }

    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }

}
