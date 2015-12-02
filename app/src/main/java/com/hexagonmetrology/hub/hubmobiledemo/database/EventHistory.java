package com.hexagonmetrology.hub.hubmobiledemo.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jimmy.li on 12/2/2015.
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
