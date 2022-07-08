package com.example.maintenance.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "vehicles")
@Parcelize
data class Vehicle(
    @PrimaryKey(autoGenerate = true)
    var vehicleId: Long = 0,
    @ColumnInfo(name = "vehicleName")
    var vehicleName: String = "",
    @ColumnInfo(name = "kms")
    var kms: Long = 0
): Parcelable {

}
