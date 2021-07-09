package com.mkemp.artbooktesting.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mkemp.artbooktesting.R
import com.mkemp.artbooktesting.adapter.ArtRecyclerAdapter
import com.mkemp.artbooktesting.databinding.FragmentArtsBinding
import javax.inject.Inject

class ArtFragment @Inject constructor(
        val artRecyclerAdapter: ArtRecyclerAdapter
): Fragment(R.layout.fragment_arts)
{
    private var fragmentBinding: FragmentArtsBinding? = null
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        
        val binding = FragmentArtsBinding.bind(view)
        fragmentBinding = binding
        
        binding.fab.setOnClickListener {
            findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
        }
    }
    
    override fun onDestroyView()
    {
        fragmentBinding = null
        super.onDestroyView()
    }
}