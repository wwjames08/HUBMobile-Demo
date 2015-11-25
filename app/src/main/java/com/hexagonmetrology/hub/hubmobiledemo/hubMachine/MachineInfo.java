package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * This class will handle all the instructions for implementing the
 * Machine Info section of the app.
 */
public class MachineInfo extends FrameLayout {

    private ImageView machineStatusIcon;
    private TextView machineLocationText;
    private TextView machineSerialNumber;

    public MachineInfo(Context context) {
        super(context);
        initLayout(context);
    }

    public MachineInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public MachineInfo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout(context);
    }

    private void initLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_machine_status, this);

        machineStatusIcon = (ImageView) findViewById(R.id.machineStatusIcon);
        machineLocationText = (TextView) findViewById(R.id.machineStatusLocationText);
        machineSerialNumber = (TextView) findViewById(R.id.machineStatusSerialNumber);

        setDefaults();
    }

    private void setDefaults() {
        setMachineStatus("disconnected");
        setMachineLocation("n/a");
        setMachineSerial("n/a");
    }

    public void setMachineInfo() {
        setMachineStatus("running");
    }

    public void setMachineInfo(String machineStatus,
                               String machineLocation,
                               String machineSerial) {
        setMachineStatus(machineStatus);
        setMachineLocation(machineLocation);
        setMachineSerial(machineSerial);
    }

    /* Setting the Machine Status Icon and Text Status */
    private void setMachineStatus(String machineStatus) {
        // Changes the ImageView depending on the Machine Status received
        // TODO: Create icons drawables for all machine status
        switch (machineStatus) {
            case "idle":
                machineStatusIcon.setImageResource(R.drawable.ms_idle);
                break;
            case "running":
                machineStatusIcon.setImageResource(R.drawable.ms_running);
                break;
            case "warning":
                machineStatusIcon.setImageResource(R.drawable.ms_warning);
                break;
            case "critical":
                machineStatusIcon.setImageResource(R.drawable.ms_error);
                break;
            case "disconnected":
                machineStatusIcon.setImageResource(R.drawable.ms_offline);
                break;
        }
    }

    // Sets the Machine Location TextView
    private void setMachineLocation(String machineLocation) {
        machineLocationText.setText(machineLocation);
    }

    // Sets the Machine Serial TextView
    private void setMachineSerial(String machineSerial) {
        machineSerialNumber.setText(machineSerial);
    }
}
