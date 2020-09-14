package com.mx.sportstrackapp.search.api.data

import com.google.gson.annotations.SerializedName

data class SearchTeamsResponse(
    @field:SerializedName("teams")
    val teams: List<Team>
)
