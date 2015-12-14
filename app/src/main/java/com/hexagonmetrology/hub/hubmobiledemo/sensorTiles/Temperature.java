package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Creates the Temperature sensor tile
 */
public class Temperature extends SensorTile {

    private final String TITLE = "Temperature";
    private final int ICON = R.drawable.temperature_icon;
    private final String UNIT_TEXT = "°C";
    private final int DEFAULT_RING = R.drawable.st_gray_ring;
    private final String DEFAULT_TEXT = "Disconnected";


    public Temperature(Context context) {
        super(context);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    public Temperature(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setupSensorTile(TITLE, ICON, UNIT_TEXT, DEFAULT_RING, DEFAULT_TEXT);
    }

    public Temperature(Context context, AttributeSet attrs, int defStyle) {
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
//            case "ok":
//                status = "idle";
//                break;
//            case "warning_low":
//            case "warning_high":
//                status = "warning";
//                break;
//            case "critical_low":
//            case "critical_high":
//            case "1hr_swing":
//            case "24hr_swing":
//                status = "critical";
//                break;
//            default:
//                status = "disconnected";
//        }
        super.setSensorTile(ringStatus, textStatus);
    }

    /**
     * Sets the Unit text of the tile
     */
    public void setUnitText(String newUnit) {
       super.setSensorTileUnitText(newUnit);
    }
}
