package com.mx.sportstrackapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.ads.AdRequest
import com.google.firebase.analytics.FirebaseAnalytics
import com.mx.sportstrackapp.analytics.logSearch
import com.mx.sportstrackapp.databinding.MainFragmentBinding
import com.mx.sportstrackapp.ui.main.adapter.TeamResultsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var teamResultsAdapter: TeamResultsAdapter

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel
        binding.recyclerviewTeams.adapter = teamResultsAdapter
        setupListeners(binding)
        setupAds(binding)
        return binding.root
    }

    private fun setupAds(binding: MainFragmentBinding) {
        binding.adView.loadAd(AdRequest.Builder().build())
    }

    private fun setupListeners(binding: MainFragmentBinding) {
        binding.button.setOnClickListener {
            val teamName = binding.textInputEditText.text.toString()
            firebaseAnalytics.logSearch(teamName)
            mainViewModel.onSearch(teamName)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}