package com.mx.sportstrackapp.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mx.sportstrackapp.search.api.Result
import com.mx.sportstrackapp.search.api.SportsDbDataSource
import com.mx.sportstrackapp.search.api.SportsServiceStatus
import com.mx.sportstrackapp.search.api.data.Team
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val remoteDataSource: SportsDbDataSource) :
    ViewModel() {

    private val _status = MutableLiveData<SportsServiceStatus>()

    val status: LiveData<SportsServiceStatus>
        get() = _status

    private val _teamList = MutableLiveData<List<Team>>()

    val teamList: LiveData<List<Team>>
        get() = _teamList

    internal fun onSearch(teamName: String) {
        viewModelScope.launch {
            _status.value = SportsServiceStatus.LOADING
            try {
                remoteDataSource.searchTeamName(teamName).let {
                    when (it.status) {
                        Result.Status.SUCCESS -> _teamList.value = it.data?.teams
                        Result.Status.ERROR -> _teamList.value = ArrayList()
                    }
                }
                _status.value = SportsServiceStatus.DONE
            } catch (e: Exception) {
                _teamList.value = ArrayList()
                _status.value = SportsServiceStatus.ERROR
            }
        }
    }

}