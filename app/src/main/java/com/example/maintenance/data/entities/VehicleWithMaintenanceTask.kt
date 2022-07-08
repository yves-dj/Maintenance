package com.example.maintenance.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class VehicleWithMaintenanceTask(
    @Embedded
    val vehicle: Vehicle,
    @Relation(
        parentColumn = "vehicleId",
        entityColumn = "taskId"
    )
    val maintenanceTasks: List<MaintenanceTask>
)
