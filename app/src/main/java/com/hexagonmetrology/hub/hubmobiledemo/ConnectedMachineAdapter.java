package com.hexagonmetrology.hub.hubmobiledemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hexagonmetrology.hub.hubmobiledemo.database.HubDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Populates the navigation drawer recycler view
 * for the connected machines
 */
public class ConnectedMachineAdapter extends RecyclerView.Adapter<ConnectedMachineAdapter.ViewHolder> {

    View connectedMachine;
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
     * List the number of connected machines
     * @return the number of connected machines
     */
    @Override
    public int getItemCount() {
        return hubDevices.size();
    }

    /**
     * This is where you bind the data to the recyclerview.
     * @param holder updates the contents of the item at the given position in the data set.
     * @param position the position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HubDevice data = hubDevices.get(position);
        ImageView icon = (ImageView) connectedMachine.findViewById(R.id.connectedMachineIcon);
        TextView type = (TextView) connectedMachine.findViewById(R.id.connectedMachineType);
        TextView location = (TextView) connectedMachine.findViewById(R.id.connectedMachineLocation);
        TextView serial = (TextView) connectedMachine.findViewById(R.id.connectedMachineSerial);
        ImageView status = (ImageView) connectedMachine.findViewById(R.id.connectedMachineStatus);

        icon.setImageResource(R.drawable.icon_7107);
        type.setText(data.getMachineType());
        location.setText(data.getMachineLocation());
        serial.setText(data.getMachineID());
        status.setImageResource(R.drawable.ic_idle);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            connectedMachine = itemView;
        }
    }

    public void setData(List<HubDevice> hubDevices) {
        this.hubDevices = hubDevices;
        notifyDataSetChanged();
    }

}
