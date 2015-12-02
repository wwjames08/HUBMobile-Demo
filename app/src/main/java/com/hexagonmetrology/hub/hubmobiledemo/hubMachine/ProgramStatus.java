package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.hexagonmetrology.hub.hubmobiledemo.R;

/**
 * Creates the Program Status widget
 */
public class ProgramStatus extends FrameLayout {

    public ProgramStatus(Context context) {
        super(context);
        initLayout(context);
    }

    public ProgramStatus(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public ProgramStatus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout(context);
    }

    private void initLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_program_status, this);
    }
}
