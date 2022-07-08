package com.example.maintenance

import android.app.Application
import com.example.maintenance.data.db.VehicleDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class VehicleApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val db by lazy { VehicleDB.getInstance(this, applicationScope) }
    val dbDao by lazy { db.vehicleDao() }
}