package com.mx.sportstrackapp.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mx.sportstrackapp.search.api.SportsDbDataSource

class MainViewModel @ViewModelInject constructor(private val remoteDataSource: SportsDbDataSource) :
    ViewModel() {

    val teamName = MutableLiveData<String>()

    init {
        teamName.value = ""
    }
}