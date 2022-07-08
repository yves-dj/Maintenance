package com.example.maintenance.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MaintenanceTask (
    var taskId: Int = 0,
    var description: String = "",
    var maintenanceCategory: String = "",
    var isDone: Boolean = false
): Parcelable {

}
