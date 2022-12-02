package com.payelpaul.mvmvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.payelpaul.mvmvvm.models.Artiest


@Dao
interface ArtistDao {

    @Insert
    fun addArtistS(artists:List<Artiest>)


    @Query("SELECT * FROM artist")
    fun getArtist() : List<Artiest>
}