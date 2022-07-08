package com.example.maintenance.vehicle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.data.Vehicle
import com.example.maintenance.databinding.VehicleViewholderBinding


class VehicleListAdapter(var inputList: MutableList<Vehicle>, val onClickListener: IVehicleOnClickListener): RecyclerView.Adapter<VehicleViewHolder>() {

    fun interface IVehicleOnClickListener {
        fun addOnClickListener(vehicle: Vehicle)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val binding = VehicleViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VehicleViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.BindValues(inputList[position])
    }

    override fun getItemCount(): Int {
        return inputList.size
    }
}