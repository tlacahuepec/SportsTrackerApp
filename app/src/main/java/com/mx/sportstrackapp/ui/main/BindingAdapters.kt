package com.mx.sportstrackapp.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mx.sportstrackapp.search.api.data.Team
import com.mx.sportstrackapp.ui.main.adapter.TeamResultsAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, teamList: List<Team>?) {
    val adapter = recyclerView.adapter as TeamResultsAdapter
    adapter.submitList(teamList)
}