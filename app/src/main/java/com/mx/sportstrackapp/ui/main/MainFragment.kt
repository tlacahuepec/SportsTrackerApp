package com.mx.sportstrackapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mx.sportstrackapp.databinding.MainFragmentBinding
import com.mx.sportstrackapp.ui.main.adapter.TeamResultsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var teamResultsAdapter: TeamResultsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel
        binding.recyclerviewTeams.adapter = teamResultsAdapter
        setupListeners(binding)
        return binding.root
    }

    private fun setupListeners(binding: MainFragmentBinding) {
        binding.button.setOnClickListener {
            mainViewModel.onSearch(binding.textInputEditText.text.toString())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}