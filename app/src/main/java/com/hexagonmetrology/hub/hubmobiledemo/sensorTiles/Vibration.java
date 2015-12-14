package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Creates the Vibration sensor tile
 */
public class Vibration extends SensorTile {

    //Default values for the Vibration sensor
    private final String TITLE = "Vibration";
    private final int ICON = R.drawable.vibration_icon;
    private final String UNIT_TEXT = "";
    private final int DEFAULT_RING = R.drawable.st_gray_ring;
    private final String DEFAULT_TEXT = "Disconnected";

    public Vibration(Context context) {
        super(context);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    public Vibration(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    public Vibration(Context context, AttributeSet attrs, int defStyle) {
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
//            case "low":
//                status = "idle";
//                break;
//            case "med":
//                status = "warning";
//                break;
//            case "high":
//                status = "critical";
//                break;
//            default:
//        }
        super.setSensorTile(ringStatus, textStatus);
    }
}
