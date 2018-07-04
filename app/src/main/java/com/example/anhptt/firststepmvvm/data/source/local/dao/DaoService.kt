package com.example.anhptt.firststepmvvm.data.source.local.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable


@Dao
interface DaoService {

    @Query("SELECT * FROM DATA_SAMPLE")
    fun loadDataAll(): Flowable<List<DataSample>>

    @Update
    fun update(dataSample: DataSample)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(dataSample: DataSample)

    @Delete
    fun deleteData(dataSample: DataSample)
}