package com.mx.sportstrackapp.search.api

import com.mx.sportstrackapp.search.api.data.SearchTeamsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsDbService {
    @GET("searchteams.php")
    suspend fun searchTeams(@Query("t") teamName: String):
            Response<SearchTeamsResponse>

    companion object {
        const val HOST = "www.thesportsdb.com"
        const val BASE_URL = "https://$HOST/api/v1/json/1/"
    }

}
