package com.example.maintenance.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.maintenance.data.entities.Vehicle

@Dao
interface IVehicleDao {
    @Insert
    suspend fun insertVehicle(item: Vehicle)

    @Update
    suspend fun updateVehicle(item: Vehicle)

    @Delete
    suspend fun deleteVehicle(item: Vehicle)

    @Query("SELECT * FROM vehicles WHERE vehicleId =:id")
    suspend fun getVehicleById(id: Int): Vehicle

    @Query("SELECT * FROM vehicles ORDER BY id ASC")
    fun getAllVehicles(): LiveData<List<Vehicle>>
}