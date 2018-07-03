package com.example.anhptt.firststepmvvm.data.source.local.dao

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "DATA_SAMPLE")
data class DataSample(
        @ColumnInfo(name = "firstname")
        var first_name: String? = null,
        @ColumnInfo(name = "lastname")
        var last_name: String? = null,
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int? = null
)