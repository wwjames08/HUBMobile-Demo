package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Created by Jimmy.LI on 11/21/2015.
 */
public class CrashDetection extends SensorTile {

    private final String TITLE = "Crash Detection";
    private final int ICON = R.drawable.crash_detection_icon;

    public CrashDetection(Context context) {
        super(context);
        super.setupSensorTile(TITLE, ICON);
    }

    public CrashDetection(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setupSensorTile(TITLE, ICON);
    }

    public CrashDetection(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        super.setupSensorTile(TITLE, ICON);
    }

    public void updateSensorTile(String status) {
        String temp = null;
        switch (status) {
            case "clear":
                temp = "idle";
                break;
            case "bump":
                temp = "warning";
                break;
            case "crash":
                temp = "critical";
                break;
            default:
        }
        super.updateSensorTile(temp, status);
    }

}
