package com.payelpaul.mvmvvm.models


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "artist")
data class Artiest(

    @PrimaryKey(autoGenerate = true)
    val artistId:Int,

    val id: Int,
    val name: String,

    val popularity: Double,


    val profile_path: String
)