package com.payelpaul.mvmvvm.api

import com.payelpaul.mvmvvm.models.PopularList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonService {

    @GET("person/popular")
    suspend fun getPopularArtiest(@Query("api_key") apiKey:String):Response<PopularList>

}