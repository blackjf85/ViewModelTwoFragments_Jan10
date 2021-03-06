package com.example.viewmodeltwofragments_jan10.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeltwofragments_jan10.databinding.FragmentCountBinding
import com.example.viewmodeltwofragments_jan10.ui.viewmodel.CounterViewModel

class CountFragment : Fragment() {

    private var _binding: FragmentCountBinding? = null
    private val binding: FragmentCountBinding get() = _binding!!

    // lateinit because value will be assigned later
    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Initialize ViewModel in onViewCreated()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Creating ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(CounterViewModel::class.java)

        with(binding) {
            viewModel.count.observe(viewLifecycleOwner) { count ->
                countTv.text = count.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}