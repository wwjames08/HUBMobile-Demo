package com.hexagonmetrology.hub.hubmobiledemo.settings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Created by jimmy.li on 7/16/2015.
 */
public class Notification extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    /* Crash Detection Notification */
    public void selectCrashDetectionNotification(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.crashDetectionWarningButton:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Crash Detection Warning selected!",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Crash Detection Warning deselected!",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.crashDetectionCriticalButton:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Crash Detection Critical selected!",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Crash Detection Critical deselected!",
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /* VibrationTile Notification */
    public void selectVibrationNotification(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.vibrationWarningButton:
                if (checked)
                    Toast.makeText(getApplicationContext(), "VibrationTile Warning selected!",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "VibrationTile Warning deselected!",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.vibrationCriticalButton:
                if (checked)
                    Toast.makeText(getApplicationContext(), "VibrationTile Critical selected!",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "VibrationTile Critical deselected!",
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /* TemperatureTile Notification */
    public void selectTemperatureNotification(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.temperatureWarningButton:
                if (checked)
                    Toast.makeText(getApplicationContext(), "TemperatureTile Warning selected!",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "TemperatureTile Warning deselected!",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.temperatureCriticalButton:
                if (checked)
                    Toast.makeText(getApplicationContext(), "TemperatureTile Critical selected!",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "TemperatureTile Critical deselected!",
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /* Humidity Notification */
    public void selectHumidityNotification(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.humidityWarningButton:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Humidity Warning selected!",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Humidity Warning deselected!",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.humidityCriticalButton:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Humidity Critical selected!",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Humidity Critical deselected!",
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

