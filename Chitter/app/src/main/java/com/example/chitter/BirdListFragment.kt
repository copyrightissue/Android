package com.example.chitter

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
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
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)

                val searchItem = menu.findItem(R.id.action_search)
                val searchView = searchItem.actionView as? SearchView
                searchView?.queryHint = getString(R.string.search)

                searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        birdAdapter.filter.filter(newText)
                        return true
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle menu item selection if needed
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }



    private fun showScorePopup(score: Int) {
        AlertDialog.Builder(requireContext())
            .setTitle("Total Chirps")
            .setMessage("You've earned: $score Chirps!")
            .setPositiveButton("Cool", null)
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
