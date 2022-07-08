package com.example.maintenance.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.maintenance.data.dao.IVehicleDao
import com.example.maintenance.data.entities.MaintenanceTask
import com.example.maintenance.data.entities.Vehicle

@Database(entities = [Vehicle::class, MaintenanceTask::class], version = 1, exportSchema = false)
abstract class VehicleDB: RoomDatabase(){

    abstract fun vehicleDao(): IVehicleDao

    companion object {
        @Volatile
        private var INSTANCE: VehicleDB? = null
        fun getInstance(context: Context): VehicleDB {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        VehicleDB::class.java,
                        "vehicle_maintenance_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}