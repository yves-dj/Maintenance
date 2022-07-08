package com.example.maintenance.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.maintenance.data.entities.Vehicle
import com.example.maintenance.data.entities.VehicleWithMaintenanceTask

@Dao
interface IVehicleDao {
    @Insert
    suspend fun insertVehicle(item: Vehicle)

    @Update
    suspend fun updateVehicle(item: Vehicle)

    @Delete
    suspend fun deleteVehicle(item: Vehicle)

//    @Transaction
//    @Query("SELECT * FROM vehicles WHERE vehicleId =:id")
//    suspend fun getVehicleById(id: Int): VehicleWithMaintenanceTask

    @Query("SELECT * FROM vehicles")
    fun getAllVehicles(): LiveData<List<Vehicle>>
}