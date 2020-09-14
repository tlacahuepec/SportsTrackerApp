package com.mx.sportstrackapp.ui.main

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mx.sportstrackapp.search.api.SportsServiceStatus
import com.mx.sportstrackapp.search.api.data.Team
import com.mx.sportstrackapp.ui.main.adapter.TeamResultsAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, teamList: List<Team>?) {
    val adapter = recyclerView.adapter as TeamResultsAdapter
    adapter.submitList(teamList)
}

@BindingAdapter("sportsServiceStatus")
fun bindSportsServiceStatus(progressBar: ProgressBar, status: SportsServiceStatus?) {
    when (status) {
        SportsServiceStatus.LOADING -> progressBar.visibility = View.VISIBLE
        SportsServiceStatus.ERROR -> progressBar.visibility = View.GONE
        SportsServiceStatus.DONE -> progressBar.visibility = View.GONE
        null -> progressBar.visibility = View.GONE
    }
}