package com.ashmit.finalto_do

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    @ColumnInfo(name = "Name")
    val name: String,
    @ColumnInfo(name = "Priority")
    val priority: String
)