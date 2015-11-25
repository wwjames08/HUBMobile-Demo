package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Created by Jimmy.LI on 11/21/2015.
 */
public class Humidity extends SensorTile {

    private final String TITLE = "Humidity";
    private final int ICON = R.drawable.humidity_icon;
    private final String UNIT = "%";

    public Humidity(Context context) {
        super(context);
        super.setupSensorTile(TITLE, ICON, UNIT);
    }

    public Humidity(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setupSensorTile(TITLE, ICON, UNIT);
    }

    public Humidity(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        super.setupSensorTile(TITLE, ICON, UNIT);
    }

    public void updateSensorTile(String status, String statusValue) {
        String temp = null;
        switch (status) {
            case "ok":
                temp = "idle";
                break;
            case "warning_low":
            case "warning_high":
                temp = "warning";
                break;
            case "critical_low":
            case "critical_high":
                temp = "critical";
                break;
            default:
        }
        super.updateSensorTile(temp, statusValue);
    }
}
