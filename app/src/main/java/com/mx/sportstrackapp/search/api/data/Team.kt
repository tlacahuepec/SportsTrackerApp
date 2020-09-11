package com.mx.sportstrackapp.search.api.data

import com.google.gson.annotations.SerializedName

data class Team(
    @field:SerializedName("idTeam")
    val id: String,

    @field:SerializedName("strTeam")
    val teamName: String,

    @field:SerializedName("strTeamShort")
    val teamNameShort: String,

    @field:SerializedName("strAlternate")
    val teamNameAlternate: String,

    @field:SerializedName("intFormedYear")
    val formedYear: String,

    @field:SerializedName("strSport")
    val sport: String
)
