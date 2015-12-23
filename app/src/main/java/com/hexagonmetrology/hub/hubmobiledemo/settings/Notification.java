package com.hexagonmetrology.hub.hubmobiledemo.settings;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Created by jimmy.li on 7/16/2015.
 */
public class Notification extends Activity {

    public static final String APP_PREFS = "applicationPrefs";
    SharedPreferences settings;

    CheckBox cdWarningBtn,
             cdCriticalBtn,
             vWarningBtn,
             vCriticalBtn,
             tWarningBtn,
             tCriticalBtn,
             hWarningBtn,
             hCriticalBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        settings = getSharedPreferences(APP_PREFS, 0);

        cdWarningBtn = (CheckBox) findViewById(R.id.crashDetectionWarningButton);
        cdCriticalBtn = (CheckBox) findViewById(R.id.crashDetectionCriticalButton);
        vWarningBtn = (CheckBox) findViewById(R.id.vibrationWarningButton);
        vCriticalBtn = (CheckBox) findViewById(R.id.vibrationCriticalButton);
        tWarningBtn = (CheckBox) findViewById(R.id.temperatureWarningButton);
        tCriticalBtn = (CheckBox) findViewById(R.id.temperatureCriticalButton);
        hWarningBtn = (CheckBox) findViewById(R.id.humidityWarningButton);
        hCriticalBtn = (CheckBox) findViewById(R.id.humidityCriticalButton);

        cdWarningBtn.setChecked(settings.getBoolean("cdWarningNotification", false));
        cdCriticalBtn.setChecked(settings.getBoolean("cdCriticalNotification", false));
        vWarningBtn.setChecked(settings.getBoolean("vWarningNotification", false));
        vCriticalBtn.setChecked(settings.getBoolean("vCriticalNotification", false));
        tWarningBtn.setChecked(settings.getBoolean("tWarningNotification", false));
        tCriticalBtn.setChecked(settings.getBoolean("tCriticalNotification", false));
        hWarningBtn.setChecked(settings.getBoolean("hWarningNotification", false));
        hCriticalBtn.setChecked(settings.getBoolean("hCriticalNotification", false));

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onResume(){

        cdWarningBtn.setChecked(settings.getBoolean("cdWarningNotification", false));
        cdCriticalBtn.setChecked(settings.getBoolean("cdCriticalNotification", false));
        vWarningBtn.setChecked(settings.getBoolean("vWarningNotification", false));
        vCriticalBtn.setChecked(settings.getBoolean("vCriticalNotification", false));
        tWarningBtn.setChecked(settings.getBoolean("tWarningNotification", false));
        tCriticalBtn.setChecked(settings.getBoolean("tCriticalNotification", false));
        hWarningBtn.setChecked(settings.getBoolean("hWarningNotification", false));
        hCriticalBtn.setChecked(settings.getBoolean("hCriticalNotification", false));

        super.onResume();
    }

    /* Crash Detection Notification */
    public void selectCrashDetectionNotification(View view) {
        SharedPreferences.Editor editor = settings.edit();

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.crashDetectionWarningButton:
                if (checked) {
                    editor.putBoolean("cdWarningNotification", true);
                    Toast.makeText(getApplicationContext(), "Crash Detection Warning selected!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    editor.putBoolean("cdWarningNotification", false);
                    Toast.makeText(getApplicationContext(), "Crash Detection Warning deselected!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.crashDetectionCriticalButton:
                if (checked) {
                    editor.putBoolean("cdCriticalNotification", true);
                    Toast.makeText(getApplicationContext(), "Crash Detection Critical selected!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    editor.putBoolean("cdCriticalNotification", false);
                    Toast.makeText(getApplicationContext(), "Crash Detection Critical deselected!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
        editor.commit();
    }

    /* VibrationTile Notification */
    public void selectVibrationNotification(View view) {
        SharedPreferences.Editor editor = settings.edit();
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.vibrationWarningButton:
                if (checked) {
                    editor.putBoolean("vWarningNotification", true);
                    Toast.makeText(getApplicationContext(), "VibrationTile Warning selected!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    editor.putBoolean("vWarningNotification", false);
                    Toast.makeText(getApplicationContext(), "VibrationTile Warning deselected!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.vibrationCriticalButton:
                if (checked) {
                    editor.putBoolean("vCriticalNotification", true);
                    Toast.makeText(getApplicationContext(), "VibrationTile Critical selected!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    editor.putBoolean("vCriticalNotification", false);
                    Toast.makeText(getApplicationContext(), "VibrationTile Critical deselected!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }

        editor.commit();
    }

    /* TemperatureTile Notification */
    public void selectTemperatureNotification(View view) {
        SharedPreferences.Editor editor = settings.edit();

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.temperatureWarningButton:
                if (checked) {
                    editor.putBoolean("tWarningNotification", true);
                    Toast.makeText(getApplicationContext(), "TemperatureTile Warning selected!",
                            Toast.LENGTH_SHORT).show();
                }else {
                    editor.putBoolean("tWarningNotification", false);
                    Toast.makeText(getApplicationContext(), "TemperatureTile Warning deselected!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.temperatureCriticalButton:
                if (checked) {
                    editor.putBoolean("tCriticalNotification", true);
                    Toast.makeText(getApplicationContext(), "TemperatureTile Critical selected!",
                            Toast.LENGTH_SHORT).show();
                }else {
                    editor.putBoolean("tCriticalNotification", false);
                    Toast.makeText(getApplicationContext(), "TemperatureTile Critical deselected!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
        editor.commit();
    }

    /* Humidity Notification */
    public void selectHumidityNotification(View view) {
        SharedPreferences.Editor editor = settings.edit();

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.humidityWarningButton:
                if (checked) {
                    editor.putBoolean("hWarningNotification", true);
                    Toast.makeText(getApplicationContext(), "Humidity Warning selected!",
                            Toast.LENGTH_SHORT).show();
                }else {
                    editor.putBoolean("hWarningNotification", false);
                    Toast.makeText(getApplicationContext(), "Humidity Warning deselected!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.humidityCriticalButton:
                if (checked) {
                    editor.putBoolean("hCriticalNotification", true);
                    Toast.makeText(getApplicationContext(), "Humidity Critical selected!",
                            Toast.LENGTH_SHORT).show();
                }else {
                    editor.putBoolean("hCriticalNotification", false);
                    Toast.makeText(getApplicationContext(), "Humidity Critical deselected!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }

        editor.commit();
    }
}

