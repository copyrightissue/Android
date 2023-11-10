package com.example.chitter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chitter.databinding.FragmentBirdListBinding

class BirdListFragment : Fragment() {

    private val viewModel: BirdViewModel by viewModels()
    private var _binding: FragmentBirdListBinding? = null
    private val binding get() = _binding!!
    private lateinit var birdAdapter: BirdAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBirdListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        birdAdapter = BirdAdapter(emptyList()) { birdId, seen ->
            viewModel.toggleBirdSeen(birdId, seen)
        }

        binding.birdListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = birdAdapter
        }

        viewModel.birds.observe(viewLifecycleOwner) { birds ->
            birdAdapter.updateBirds(birds)
        }

        binding.submitButton.setOnClickListener {
            val score = viewModel.calculateScore()
            // Show the score to the user, e.g., via a Toast or a dialog
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
