package com.mx.sportstrackapp.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mx.sportstrackapp.search.api.SportsDbDataSource

class MainViewModel @ViewModelInject constructor(private val remoteDataSource: SportsDbDataSource) :
    ViewModel() {
    fun onSearch(text: String) = {}


    val teamName = MutableLiveData<String>()

    init {
        teamName.value = ""
    }

//    fun <T, A> resultLiveData(
//        networkCall: suspend () -> Result<A>
//    ): LiveData<Result<T>> =
//        liveData(Dispatchers.IO) {
//            emit(Result.loading<T>())
//            val response = networkCall.invoke()
//            if(response.status == Result.Status.SUCCESS)
//                emitSource(Result.success<T>(response.data))
//            }
//        }

}