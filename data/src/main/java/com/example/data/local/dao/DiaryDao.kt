package com.example.data.local.dao

import androidx.room.Insert
import com.example.data.model.entity.DiaryEntity

interface DiaryDao {
    @Insert
    fun insert(diary: DiaryEntity)
}