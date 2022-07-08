package com.example.maintenance.vehicle

import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.data.entities.Vehicle
import com.example.maintenance.data.entities.VehicleWithMaintenanceTask
import com.example.maintenance.databinding.VehicleViewholderBinding

class VehicleViewHolder(
    var vehicleView: VehicleViewholderBinding,
    var onClickListener: VehicleListAdapter.IVehicleOnClickListener
) : RecyclerView.ViewHolder(vehicleView.root) {

    fun bindValues(vehicleWithTasks: VehicleWithMaintenanceTask) {
        with(vehicleView) {
            vehicleWithTasks.vehicle.let { vehicle ->
                vehicleName.text = vehicle.vehicleName
                root.setOnClickListener { onClickListener.addOnClickListener(vehicle) }
            }
            vehicleDetail.text = vehicleWithTasks.maintenanceTasks.let {
                if (it.isNotEmpty()) it[0].description
                else "Nothing To Do"
            }
        }

    }
}
