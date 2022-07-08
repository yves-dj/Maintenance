package com.example.maintenance.vehicle

import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.data.entities.Vehicle
import com.example.maintenance.databinding.VehicleViewholderBinding

class VehicleViewHolder(var vehicleView: VehicleViewholderBinding, var onClickListener: VehicleListAdapter.IVehicleOnClickListener): RecyclerView.ViewHolder(vehicleView.root) {

    fun BindValues(vehicle: Vehicle) {
        with(vehicleView) {
            vehicleName.text = vehicle.vehicleName
            if (vehicle.maintenanceTaskList.size != 0)
                vehicleDetail.text = vehicle.maintenanceTaskList[0].description
            else
                vehicleDetail.text = "Nothing To Do"
            root.setOnClickListener { onClickListener.addOnClickListener(vehicle) }
        }

    }
}
