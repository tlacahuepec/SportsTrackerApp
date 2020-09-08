package com.mx.sportstrackapp.ui.main

import androidx.lifecycle.ViewModel
import com.mx.sportstrackapp.search.api.SportsDbDataSource
import javax.inject.Inject

class MainViewModel @Inject constructor(private val remoteDataSource: SportsDbDataSource) : ViewModel() {

}