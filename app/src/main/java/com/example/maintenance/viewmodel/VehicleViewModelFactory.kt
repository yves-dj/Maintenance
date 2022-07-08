package com.example.maintenance.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.maintenance.data.dao.IVehicleDao
import com.example.maintenance.data.entities.Vehicle
import javax.sql.DataSource

class VehicleViewModelFactory(
    private val dataSource: IVehicleDao,
    private val application: Application) : ViewModelProvider.Factory  {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VehicleViewModel::class.java)) {
            return VehicleViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}