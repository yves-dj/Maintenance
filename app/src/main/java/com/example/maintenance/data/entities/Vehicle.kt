package com.example.maintenance.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "vehicles")
@Parcelize
data class Vehicle(
    @PrimaryKey(autoGenerate = true)
    var vehicleId: Int = 0,
    @ColumnInfo(name = "vehicleName")
    var vehicleName: String = "",
    @ColumnInfo(name = "maintenanceTasks")
    var maintenanceTaskList: MutableList<MaintenanceTask> = mutableListOf(),
    @ColumnInfo(name = "kms")
    var kms: Long = 0
): Parcelable {

}
