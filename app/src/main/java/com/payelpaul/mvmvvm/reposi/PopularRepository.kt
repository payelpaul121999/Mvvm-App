package com.payelpaul.mvmvvm.reposi

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.payelpaul.mvmvvm.api.PersonService
import com.payelpaul.mvmvvm.db.ArtistDao
import com.payelpaul.mvmvvm.db.ArtistDataBase
import com.payelpaul.mvmvvm.models.Artiest
import com.payelpaul.mvmvvm.models.PopularList
import com.payelpaul.mvmvvm.utils.NetworkCheck

class PopularRepository(private val personService: PersonService,
                        private val artistDataBase: ArtistDataBase,
                        private val context: Context
) {

    private val popularLiveData = MutableLiveData<PopularList>()
    val liveData :LiveData<PopularList> get() = popularLiveData

    val interNetOrDataBase = MutableLiveData<String>()

    suspend fun getPopularDetails(apiKey:String){


        if (NetworkCheck.isInternetAvailable(context)){
            val result = personService.getPopularArtiest(apiKey)
            if (result.body() !=null){

                artistDataBase.artistDao().addArtistS(result.body()!!.results)
                popularLiveData.postValue(result.body())

            }
        }else{
            val quotes = artistDataBase.artistDao().getArtist()
            if (quotes.isNotEmpty()){
                val quoteList = PopularList(quotes)
                popularLiveData.postValue(quoteList)
            }else{
                interNetOrDataBase.postValue("Database is empty and check internet connection")
            }

        }


    }
}