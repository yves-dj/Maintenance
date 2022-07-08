package com.example.maintenance.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.maintenance.data.dao.IVehicleDao
import com.example.maintenance.data.entities.MaintenanceTask
import com.example.maintenance.data.entities.Vehicle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Vehicle::class, MaintenanceTask::class], version = 1, exportSchema = false)
abstract class VehicleDB: RoomDatabase(){

    abstract fun vehicleDao(): IVehicleDao

    companion object {
        @Volatile
        private var INSTANCE: VehicleDB? = null
        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): VehicleDB {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        VehicleDB::class.java,
                        "vehicle_maintenance_database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .addCallback(VehicleDbCallBack(scope))
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    private class VehicleDbCallBack(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDb(database.vehicleDao())
                }
            }
        }

        suspend fun populateDb(vehicleDao: IVehicleDao) {
            if (vehicleDao.getAllVehicles().value?.isNotEmpty() == true) {
                var taskForFirstVeh = MaintenanceTask(description = "This needs to be done")
                var firstVeh = Vehicle(0, "HONDA")
                var secondVeh = Vehicle(0, "YAMAHA")
                var thirdVeh = Vehicle(0, "SUZUKI")

                with(vehicleDao) {
                    insertVehicle(firstVeh)
                    insertVehicle(secondVeh)
                    insertVehicle(thirdVeh)
                }
            }
        }
    }
}