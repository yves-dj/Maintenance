package com.example.maintenance.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class VehicleWithMaintenanceTask(
    @Embedded
    val vehicle: Vehicle,
    @Relation(
        parentColumn = "vehicleId",
        entityColumn = "taskOwnerId"
    )
    val maintenanceTasks: List<MaintenanceTask>
)
