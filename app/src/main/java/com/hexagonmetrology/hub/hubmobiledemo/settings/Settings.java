package com.hexagonmetrology.hub.hubmobiledemo.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Created by jimmy.li on 7/16/2015.
 */
public class Settings extends Activity {
    int mNumber;
    TextView tempUnit;

    public static final String APP_PREFS = "applicationPrefs";
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        tempUnit = (TextView) findViewById(R.id.tempUnit);
        settings = getSharedPreferences(APP_PREFS, 0);
        editor = settings.edit();

        if(tempUnit.getText().toString() == null){
            tempUnit.setText(settings.getString("tempUnit", null));
            String t = tempUnit.getText().toString();
            if(t == "C°"){
                mNumber = 1;
            }
        }
      /*  if (tempUnit.getText().toString() == null) {
            mNumber = 0;
            tempUnit.setText("C°");
        } else {
            tempUnit.setText(settings.getString("tempUnit", "C") + "°");
            if (tempUnit.getText().toString() == "C°") {
                mNumber = 0;
            }
            if (tempUnit.getText().toString() == "F°") {
                mNumber = 1;
            }
        }*/
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
        AlertDialog.Builder tempChangeAlert = new AlertDialog.Builder(this);
        tempChangeAlert.setTitle("TemperatureTile Units")
                .setSingleChoiceItems(R.array.tempUnitsArray, mNumber,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mNumber = which;
                            }
                        })
                        // Set the action buttons
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String temp = null;
                        if (mNumber == 0) {
                            temp = "C";
                        }
                        if (mNumber == 1) {
                            temp = "F";
                        }
                        tempUnit.setText("°" + temp);
                        editor.putString("tempUnit", temp);

                        editor.commit();
                    }
                });

        // Show the alert dialog
        tempChangeAlert.show();
    }
}
