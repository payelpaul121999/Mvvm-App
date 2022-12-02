package com.payelpaul.mvmvvm

import android.app.Application
import com.payelpaul.mvmvvm.api.PersonService
import com.payelpaul.mvmvvm.api.RetrofitHelper
import com.payelpaul.mvmvvm.db.ArtistDataBase
import com.payelpaul.mvmvvm.reposi.PopularRepository

class ApplicationMovie():Application() {
    lateinit var repository: PopularRepository
      override fun onCreate() {
        super.onCreate()
        initialize()
    }


    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(PersonService::class.java)
        val database = ArtistDataBase.getDatabase(applicationContext)
        repository = PopularRepository(quoteService, database, applicationContext)
    }
}