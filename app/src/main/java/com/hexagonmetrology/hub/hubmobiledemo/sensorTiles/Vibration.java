package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Created by Jimmy.LI on 11/21/2015.
 */
public class Vibration extends SensorTile {

    private final String TITLE = "Vibration";
    private final int ICON = R.drawable.vibration_icon;

    public Vibration(Context context) {
        super(context);
        super.setupSensorTile(TITLE, ICON);
    }

    public Vibration(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setupSensorTile(TITLE, ICON);
    }

    public Vibration(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        super.setupSensorTile(TITLE, ICON);
    }

    public void updateSensorTile(String status) {
        String temp = null;
        switch (status) {
            case "low":
                temp = "idle";
                break;
            case "med":
                temp = "warning";
                break;
            case "high":
                temp = "critical";
                break;
            default:
        }
        super.updateSensorTile(temp, status);
    }
}
