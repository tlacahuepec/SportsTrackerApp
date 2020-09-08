package com.mx.sportstrackapp.search.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SportsDbDataSource @Inject constructor(
    private val service: SportsDbService
) :
    BaseDataSource() {

    suspend fun searchTeamName(teamName: String) = getResult {
        service.searchTeams(teamName)
    }

}
