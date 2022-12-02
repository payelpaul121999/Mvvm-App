package com.payelpaul.mvmvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.payelpaul.mvmvvm.models.Artiest

@Database(entities = [Artiest::class], version = 1)
abstract class ArtistDataBase : RoomDatabase() {
    abstract fun artistDao(): ArtistDao

    companion object{

        @Volatile
        private var INSTANCE :ArtistDataBase?=null
        fun getDatabase(context: Context):ArtistDataBase{

            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,ArtistDataBase::class.java,"artistDB").build()
                }
            }

            return INSTANCE!!
        }
    }
}