package com.hexagonmetrology.hub.hubmobiledemo.sensorTiles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * This is the parent class for all Sensor tiles
 */
public class SensorTile extends FrameLayout {

    //Declare references for all the views in the tile
    private TextView sensorTileTitle;
    private ImageView sensorTileIcon;
    private ImageView sensorTileStatusRing;
    private TextView sensorTileStatusText;
    private TextView sensorTileUnitText;

    protected SensorTile(Context context) {
        super(context);
        initLayout(context);
    }

    protected SensorTile(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    protected SensorTile(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout(context);
    }

    /**
     * Initializes the sensor tile
     * @param context
     */
    private void initLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_sensor_tile, this);

        //Assign references to their views in the XML
        sensorTileTitle = (TextView) findViewById(R.id.tileTitle);
        sensorTileIcon = (ImageView) findViewById(R.id.tileStatusIcon);
        sensorTileStatusRing = (ImageView) findViewById(R.id.tileStatusRing);
        sensorTileStatusText = (TextView) findViewById(R.id.tileStatusText);
        sensorTileUnitText = (TextView) findViewById(R.id.tileUnitText);
    }

    /**
     * Setup the sensor tile
     * @param tileTitle tile's title
     * @param tileIcon tile's icon (resource id)
     * @param tileUnitText tile's unit (if applicable)
     * @param tileStatusRing tile's ring color status (resource id)
     * @param tileStatusText tile's status text
     */
    protected void setupSensorTile(String tileTitle,
                                   int tileIcon,
                                   String tileUnitText,
                                   int tileStatusRing,
                                   String tileStatusText) {
        sensorTileTitle.setText(tileTitle);
        sensorTileIcon.setImageResource(tileIcon);
        sensorTileStatusRing.setImageResource(tileStatusRing);
        sensorTileStatusText.setText(tileStatusText.substring(0, 1).toUpperCase()
                + tileStatusText.substring(1));
        sensorTileUnitText.setText(tileUnitText);
    }
}
