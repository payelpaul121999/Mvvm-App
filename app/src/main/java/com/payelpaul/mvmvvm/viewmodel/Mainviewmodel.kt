package com.payelpaul.mvmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.payelpaul.mvmvvm.models.PopularList
import com.payelpaul.mvmvvm.reposi.PopularRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Mainviewmodel(private val popularRepository: PopularRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
         popularRepository.getPopularDetails("df57ebe7d0723991d4ab8564e57256dc")
        }
    }

    val liveDataPopular : LiveData<PopularList> = popularRepository.liveData

    val checkInternet: MutableLiveData<String> = popularRepository.interNetOrDataBase
}