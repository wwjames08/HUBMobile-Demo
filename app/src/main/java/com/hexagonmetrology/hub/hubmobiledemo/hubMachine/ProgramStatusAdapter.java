package com.hexagonmetrology.hub.hubmobiledemo.hubMachine;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hexagonmetrology.hub.hubmobiledemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimmy.li on 10/26/2015.
 */
public class ProgramStatusAdapter extends RecyclerView.Adapter<ProgramStatusAdapter.ViewHolder> {

    List<String> timeStamps = new ArrayList<>();
    List<String> programEvents = new ArrayList<>();


    public ProgramStatusAdapter() {
        super();
    }

    /**
     * Inflates the machine_item_layout each item
     * in the recyclerview
     *
     * @param parent   gets the context of the parent view the adapter is attached too
     * @param viewType if there are multiple view types for the recyclerview
     * @return the selected layout viewtype
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.program_status_entry_layout, parent, false));
    }

    /**
     * Gets the size of the array of data
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return timeStamps.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setData(List<String> timeStamps, List<String> programEvents) {
        this.timeStamps = timeStamps;
        this.programEvents = programEvents;
        notifyDataSetChanged();
    }

}
