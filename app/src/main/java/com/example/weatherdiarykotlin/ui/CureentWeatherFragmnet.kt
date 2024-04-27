package com.example.weatherdiarykotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherdiarykotlin.databinding.FragmentWeatherCurrentBinding

class CureentWeatherFragmnet : Fragment() {
    private lateinit var binding:FragmentWeatherCurrentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherCurrentBinding.inflate(inflater)
        return binding.root
    }
}