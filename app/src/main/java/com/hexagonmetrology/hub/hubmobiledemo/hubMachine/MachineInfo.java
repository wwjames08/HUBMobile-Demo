package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Creates the Machine Info widget
 */
public class MachineInfo extends FrameLayout {

    ImageView mMachineStatusIcon;
    TextView mMachineLocation;
    TextView mMachineSerial;

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

        mMachineStatusIcon = (ImageView) findViewById(R.id.machineStatusIcon);
        mMachineLocation = (TextView) findViewById(R.id.machineStatusLocation);
        mMachineSerial = (TextView) findViewById(R.id.machineStatusSerial);
    }

    /**
     * Setup MachineInfo
     * @param statusIcon status icon (resource id)
     * @param location location of the machine
     * @param serial serial number of the machine
     */
    public void setup(int statusIcon, String location, String serial){
        mMachineStatusIcon.setImageResource(statusIcon);
        mMachineLocation.setText(location);
        mMachineSerial.setText(serial);
    }

    /**
     * Sets the machine status icon
     * @param statusIcon updated resource id for icon
     */
    public void setMachineStatus(int statusIcon){
        mMachineStatusIcon.setImageResource(statusIcon);
    }

}
