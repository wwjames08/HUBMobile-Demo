package com.hexagonmetrology.hub.hubmobiledemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hexagonmetrology.hub.hubmobiledemo.database.HubDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Populates the navigation drawer recycler view
 * for the connected machines
 */
public class ConnectedMachineAdapter extends RecyclerView.Adapter<ConnectedMachineAdapter.ViewHolder> {

    List<HubDevice> hubDevices = new ArrayList<>();

    public ConnectedMachineAdapter() {
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
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.machine_item_layout, parent, false));
    }

    /**
     * Gets the size of the array of data
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return hubDevices.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setData(List<HubDevice> hubDevices) {
        this.hubDevices = hubDevices;
        notifyDataSetChanged();
    }
}
