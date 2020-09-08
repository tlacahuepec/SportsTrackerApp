package com.mx.sportstrackapp.search.api.data

import com.google.gson.annotations.SerializedName

data class SearchTeamsResponse(
    @field:SerializedName("teams")
    private val teams: List<Team>
)
