package com.example.weatherdiarykotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherdiarykotlin.databinding.FragmentListDiaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryListFragment : Fragment() {
    private lateinit var binding : FragmentListDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListDiaryBinding.inflate(inflater)
        return binding.root
    }
}