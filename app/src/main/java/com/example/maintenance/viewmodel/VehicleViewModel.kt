package com.example.maintenance.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.maintenance.data.dao.IVehicleDao
import com.example.maintenance.data.db.VehicleDB
import com.example.maintenance.data.entities.Vehicle

class VehicleViewModel(private val dbDao: IVehicleDao, application: Application) : AndroidViewModel(application) {

    val allVehicles = dbDao.getAllVehicles()

    suspend fun insertNewVehicle(vehicle: Vehicle) {
        dbDao.insertVehicle(vehicle)
    }
}