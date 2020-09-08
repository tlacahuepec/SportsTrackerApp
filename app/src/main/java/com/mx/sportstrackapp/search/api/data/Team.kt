package com.mx.sportstrackapp.search.api.data

import com.google.gson.annotations.SerializedName

data class Team(
    @field:SerializedName("idTeam")
    private val id: String,

    @field:SerializedName("strTeam")
    private val teamName: String,

    @field:SerializedName("strTeamShort")
    private val teamNameShort: String,

    @field:SerializedName("strAlternate")
    private val teamNameAlternate: String,

    @field:SerializedName("intFormedYear")
    private val formedYear: String,

    @field:SerializedName("strSport")
    private val sport: String
)
