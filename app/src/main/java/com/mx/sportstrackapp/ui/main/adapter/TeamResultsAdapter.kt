package com.mx.sportstrackapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mx.sportstrackapp.databinding.TeamViewItemBinding
import com.mx.sportstrackapp.search.api.data.Team
import javax.inject.Inject

class TeamResultsAdapter @Inject constructor() :
    ListAdapter<Team, TeamResultsAdapter.TeamViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamResultsAdapter.TeamViewHolder {
        return TeamViewHolder(
            TeamViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class TeamViewHolder(private val binding: TeamViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team) {
            binding.apply {
                this.team = team
                executePendingBindings()
            }
        }
    }


    override fun onBindViewHolder(holder: TeamResultsAdapter.TeamViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(team)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Team>() {

        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem === oldItem
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem.id == newItem.id
        }

    }
}
