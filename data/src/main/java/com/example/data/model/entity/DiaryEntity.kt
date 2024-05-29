package com.example.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary")
data class DiaryEntity(
    val title: String,
    val contents: String,
    val icon: String,
    val date: Long,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    )
