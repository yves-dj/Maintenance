package com.example.maintenance.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "maintenanceTask")
@Parcelize
data class MaintenanceTask (
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0,
    var taskOwnerId: Long = 0,
    @ColumnInfo(name = "description")
    var description: String = "",
    @ColumnInfo(name = "maintenanceCategory")
    var maintenanceCategory: String = "",
    @ColumnInfo(name = "isDone")
    var isDone: Boolean = false
): Parcelable {

}
