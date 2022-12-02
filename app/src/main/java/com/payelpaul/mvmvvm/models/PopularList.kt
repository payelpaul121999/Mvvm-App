package com.payelpaul.mvmvvm.models


import com.google.gson.annotations.SerializedName

data class PopularList(


    @SerializedName("results")
    val results: List<Artiest>,

    )