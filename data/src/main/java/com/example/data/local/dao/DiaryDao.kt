package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.model.Weather
import com.example.data.model.entity.DiaryEntity

@Dao
interface DiaryDao {
    @Query("SELECT * from diary ORDER BY id DESC")
    fun getAll(): List<DiaryEntity>
    @Insert
    fun insert(diary: DiaryEntity)
}