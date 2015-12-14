package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Creates the Humidity sensor tile
 */
public class Humidity extends SensorTile {

    private final String TITLE = "Humidity";
    private final int ICON = R.drawable.humidity_icon;
    private final String UNIT_TEXT = "%";
    private final int DEFAULT_RING = R.drawable.st_gray_ring;
    private final String DEFAULT_TEXT = "Disconnected";

    public Humidity(Context context) {
        super(context);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    public Humidity(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    public Humidity(Context context, AttributeSet attrs, int defStyle) {
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
//        switch (status) {
//            case "ok":
//                status = "idle";
//                break;
//            case "warning_low":
//            case "warning_high":
//                status = "warning";
//                break;
//            case "critical_low":
//            case "critical_high":
//                status = "critical";
//                break;
//            default:
//                status = "disconnected";
//        }
        super.setSensorTile(ringStatus, textStatus);
    }
}
