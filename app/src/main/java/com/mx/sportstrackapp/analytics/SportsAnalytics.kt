package com.mx.sportstrackapp.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

private const val EVENT_SEARCH = "search"

private const val PARAM_TEAM = "team"

fun FirebaseAnalytics.logSearch(teamName: String) {
    logEvent(FirebaseAnalytics.Event.SEARCH, Bundle().apply {
        putString(FirebaseAnalytics.Param.SEARCH_TERM, teamName)
    })
}
