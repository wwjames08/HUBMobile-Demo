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
}
