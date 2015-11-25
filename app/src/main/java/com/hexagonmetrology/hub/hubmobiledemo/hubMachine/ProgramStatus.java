package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hexagonmetrology.hub.hubmobiledemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimmy.li on 8/27/2015.
 */
public class ProgramStatus extends FrameLayout {
    private String mTimestamp;
    private String mEventDescription;

    private List<String> mTimestampList;
    private List<String> mEventDescriptionList;

    List<String> mockTimeStamps = new ArrayList<>();
    List<String> mockProgramEvents = new ArrayList<>();

    private TextView programStatusTimestamp;
    private TextView programStatusEventDesc;

    private ProgramStatusAdapter programStatusAdapter;
    private RecyclerView programStatusRecyclerView;

    private RecyclerView recyclerView;

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

        programStatusTimestamp = (TextView) findViewById(R.id.row1col1);
        programStatusEventDesc = (TextView) findViewById(R.id.row1col2);

        programStatusRecyclerView = (RecyclerView) findViewById(R.id.event_history_list);
        programStatusAdapter = new ProgramStatusAdapter();
        programStatusRecyclerView.setAdapter(programStatusAdapter);
        programStatusRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        for (int i = 0; i < 5; i++) {

        }

        setDefault();
    }

    private void setDefault() {
        mTimestamp = "n/a";
        mEventDescription = "n/a";
    }


    public void setProgramStatus(List<String> timeStamp, List<String> eventStatus) {
        mTimestampList = timeStamp;
        mEventDescriptionList = eventStatus;
    }
}
