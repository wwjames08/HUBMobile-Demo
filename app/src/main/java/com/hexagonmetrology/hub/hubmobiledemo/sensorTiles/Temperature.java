package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Created by Jimmy.LI on 11/21/2015.
 */
public class Temperature extends SensorTile {

    private final String TITLE = "Temperature";
    private final int ICON = R.drawable.temperature_icon;
    private String unitText = "°C";

    public static final String APP_PREFS = "applicationPrefs";
    SharedPreferences settings;

    public Temperature(Context context) {
        super(context);
        super.setupSensorTile(TITLE, ICON, unitText);

        settings = context.getSharedPreferences(APP_PREFS, 0);
    }

    public Temperature(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setupSensorTile(TITLE, ICON, unitText);

        settings = context.getSharedPreferences(APP_PREFS, 0);
    }

    public Temperature(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        super.setupSensorTile(TITLE, ICON, unitText);

        settings = context.getSharedPreferences(APP_PREFS, 0);
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
            case "1hr_swing":
            case "24hr_swing":
                temp = "critical";
                break;
            default:
        }
        super.updateSensorTile(temp, statusValue);
    }

    /**
     * Flips the sensor tile temperature unit
     * between F and C
     */
    protected void changeTemperatureUnitText() {
        if (getSensorTileUnitText() == "°F") {
            unitText = "°C";
            setSensorTileUnitText(unitText);
        } else if (getSensorTileUnitText() == "°C") {
            unitText = "°F";
            setSensorTileUnitText(unitText);
        }
    }
}
