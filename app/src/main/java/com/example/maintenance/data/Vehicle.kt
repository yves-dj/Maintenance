package com.example.maintenance.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Vehicle(
    var vehicleId: Int = 0,
    var vehicleName: String = "",
    var maintenanceTaskList: MutableList<MaintenanceTask> = mutableListOf(),
    var kms: Long = 0
): Parcelable {

}
