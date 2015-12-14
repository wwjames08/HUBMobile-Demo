package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Creates the Crash Detection sensor tile
 */
public class CrashDetection extends SensorTile {

    //Default values for the Crash Detection sensor
    private final String TITLE = "Crash Detection";
    private final int ICON = R.drawable.crash_detection_icon;
    private final String UNIT_TEXT = "";
    private final int DEFAULT_RING = R.drawable.st_gray_ring;
    private final String DEFAULT_TEXT = "Disconnected";

    public CrashDetection(Context context) {
        super(context);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    public CrashDetection(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    public CrashDetection(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    /**
     * Updates the sensor tile's ring color and text status
     * @param ringStatus updated resource id for ring color
     * @param textStatus updated text for the text field
     */
    public void updateSensorTile(int ringStatus, String textStatus) {
//        String status = null;
//        switch (textStatus) {
//            case "clear":
//                status = "idle";
//                break;
//            case "bump":
//                status = "warning";
//                break;
//            case "crash":
//                status = "critical";
//                break;
//            default:
//        }
        super.setSensorTile(ringStatus, textStatus);
    }
}
