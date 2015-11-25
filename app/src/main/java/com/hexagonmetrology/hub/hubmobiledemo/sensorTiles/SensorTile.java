package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hexagonmetrology.hub.hubmobiledemo.R;

public class SensorTile extends FrameLayout {

    private TextView sensorTileTitle;
    private ImageView sensorTileIcon;
    private ImageView sensorTileStatusRing;
    private TextView sensorTileStatusText;
    private TextView sensorTileUnitText;

    public SensorTile(Context context) {
        super(context);
        initLayout(context);
    }

    public SensorTile(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public SensorTile(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout(context);
    }

    /**
     * Initializes the sensor tile
     *
     * @param context
     */
    private void initLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_sensor_tile, this);

        sensorTileTitle = (TextView) findViewById(R.id.tileTitle);
        sensorTileIcon = (ImageView) findViewById(R.id.tileStatusIcon);
        sensorTileStatusRing = (ImageView) findViewById(R.id.tileStatusRing);
        sensorTileStatusText = (TextView) findViewById(R.id.tileStatusText);
        sensorTileUnitText = (TextView) findViewById(R.id.tileUnitText);
    }

    /**
     * For setting up sensor tiles without unit text
     */
    public void setupSensorTile(String tileTitle, int tileIcon) {
        sensorTileTitle.setText(tileTitle);
        sensorTileIcon.setImageResource(tileIcon);
        setSensorTileRing("grey");
        setSensorTileStatusText("disconnected");
    }

    /**
     * For setting up sensor tiles with unit text
     */
    public void setupSensorTile(String tileTitle, int tileIcon, String tileUnitText) {
        sensorTileTitle.setText(tileTitle);
        sensorTileIcon.setImageResource(tileIcon);
        setSensorTileRing("grey");
        setSensorTileStatusText("disconnected");
        setSensorTileUnitText(tileUnitText);
    }

    /**
     * @param ringStatus color to change to
     * @param textStatus text to change to
     */
    protected void updateSensorTile(String ringStatus, String textStatus) {
        setSensorTileRing(ringStatus);
        setSensorTileStatusText(textStatus);
    }

    /**
     * Sets sensor tile status textfield
     *
     * @param tileStatusText sensor tile status
     */
    private void setSensorTileStatusText(String tileStatusText) {
        sensorTileStatusText.setText(tileStatusText.substring(0, 1).toUpperCase()
                + tileStatusText.substring(1));
    }

    /**
     * Sets sensor tile status ring color
     *
     * @param sensorStatus status of sensor
     */
    private void setSensorTileRing(String sensorStatus) {
        switch (sensorStatus) {
            case "idle":
                sensorTileStatusRing.setImageResource(R.drawable.st_blue_ring);
                break;
            case "warning":
                sensorTileStatusRing.setImageResource(R.drawable.st_yellow_ring);
                break;
            case "critical":
                sensorTileStatusRing.setImageResource(R.drawable.st_red_ring);
                break;
            case "disconnected":
                sensorTileStatusRing.setImageResource(R.drawable.st_gray_ring);
                break;
            default:
                sensorTileStatusRing.setImageResource(R.drawable.st_gray_ring);
                break;
        }
    }

    /**
     * Sets sensor tile unit textfield
     *
     * @param unitText sensor tile unit text
     */
    protected void setSensorTileUnitText(String unitText) {
        sensorTileUnitText.setText(unitText);
    }

    /**
     * @return sensor tile unit textfield value
     */
    protected String getSensorTileUnitText() {
        return sensorTileUnitText.getText().toString();
    }
}
