package com.hexagonmetrology.hub.hubmobiledemo.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * This class is a Realm Object that will store
 * the data for each timestamp and program status
 * event of the connected machine.
 */
public class EventHistory extends RealmObject {

    @PrimaryKey
    private String timeStamp;
    private String statusEvent;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatusEvent() {
        return statusEvent;
    }

    public void setStatusEvent(String statusEvent) {
        this.statusEvent = statusEvent;
    }

}
