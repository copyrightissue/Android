package com.example.chitter

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

        birdAdapter = BirdAdapter(
            viewModel.birds.value ?: emptyList(),
            onBirdSeenChanged = { birdId, seen ->
                viewModel.toggleBirdSeen(birdId, seen)
            },
            onItemClicked = { bird ->
                val action = BirdListFragmentDirections.actionBirdListFragmentToBirdDetailsFragment(bird.id)
                findNavController().navigate(action)
            }
        )

        // Set up RecyclerView
        binding.birdListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = birdAdapter
        }

        // Observe the birds LiveData from the ViewModel
        viewModel.birds.observe(viewLifecycleOwner) { birds ->
            birdAdapter.updateBirds(birds ?: emptyList())
        }

        binding.submitButton.setOnClickListener {
            val score = viewModel.calculateScore()
            showScorePopup(score)
            // Show the score to the user, e.g., via a Toast or a dialog
        }
    }
    private fun showScorePopup(score: Int) {
        AlertDialog.Builder(requireContext())
            .setTitle("Total Score")
            .setMessage("Your total score is: $score")
            .setPositiveButton("OK", null)
            .setOnDismissListener {
                // Post the adapter update to the main thread's message queue
                Handler(Looper.getMainLooper()).post {
                    viewModel.resetBirdsSeenStatus()
                    birdAdapter.notifyDataSetChanged() // Notify the adapter to refresh the list
                }
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
