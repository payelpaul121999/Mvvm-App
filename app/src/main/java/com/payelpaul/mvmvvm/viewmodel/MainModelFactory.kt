package com.payelpaul.mvmvvm.viewmodel

import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.payelpaul.mvmvvm.reposi.PopularRepository

class MainModelFactory(private val popularRepository: PopularRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Mainviewmodel(popularRepository) as T
    }
}