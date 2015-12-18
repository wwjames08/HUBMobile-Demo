package com.hexagonmetrology.hub.hubmobiledemo.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * This class handles the Settings of the application.
 * The user can set the temperature units or navigate into
 * the notification settings, about, term of use and privacy.
 */
public class Settings extends Activity {
    private int mNumber;
    private String tempUnit;
    private TextView tempUnitView;

    public static final String APP_PREFS = "applicationPrefs";
    SharedPreferences settings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        tempUnitView = (TextView) findViewById(R.id.tempUnit);
        tempUnit = tempUnitView.getText().toString();
        settings = getSharedPreferences(APP_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();

        //For first time initialization of app, when there
        //is no value inside the tempUnit the app preference
        if(tempUnit.equals(null)) {
            tempUnit = "°C";
            tempUnitView.setText(tempUnit);
            mNumber = 0;
            editor.putString("tempUnit", tempUnit);
            editor.commit();
        }else{
            //If tempUnit equals to C, then set the radio button to C
            //else if tempUnit equals to F, then set the radio button to F
            if(tempUnit.equals("°C")){
                tempUnitView.setText("°C");
                mNumber = 0;
            }else if(tempUnit.equals("°F")){
                tempUnitView.setText("°F");
                mNumber = 1;
            }
        }
    }

    public void openNotification(View view) {
        startActivity(new Intent(this, Notification.class));
    }

    public void openAbout(View view) {
        Toast.makeText(getApplicationContext(), "Opens About Settings",
                Toast.LENGTH_SHORT).show();
    }

    public void openTou(View view) {
        Toast.makeText(getApplicationContext(), "Opens Terms of Use Settings",
                Toast.LENGTH_SHORT).show();
    }

    public void openPrivacy(View view) {
        Toast.makeText(getApplicationContext(), "Opens Privacy Settings",
                Toast.LENGTH_SHORT).show();
    }

    public void onClickTempUnit(View view) {

        final AlertDialog.Builder tempChangeAlert = new AlertDialog.Builder(this);
        tempChangeAlert.setTitle("TemperatureTile Units")
                .setSingleChoiceItems(R.array.tempUnitsArray, mNumber,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TypedArray unit = getResources().obtainTypedArray(R.array.tempUnitsArray);
                                tempUnit = unit.getNonResourceString(which);
                                mNumber = which;
                                unit.recycle();
                            }
                        })
                // Set the action buttons
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor editor = settings.edit();
                        String temp = null;
                        if (mNumber == 0) {
                            temp = "C";
                        }
                        if (mNumber == 1) {
                            temp = "F";
                        }
                        tempUnitView.setText("°" + temp);
                        editor.putString("tempUnit", temp);

                        editor.commit();
                    }
                });

        // Show the alert dialog
        tempChangeAlert.show();
    }
}
