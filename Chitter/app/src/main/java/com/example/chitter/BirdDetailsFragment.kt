package com.example.chitter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.chitter.data.AppDatabase
import com.example.chitter.data.BirdSighting
import com.example.chitter.databinding.FragmentBirdDetailsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date


class BirdDetailsFragment : Fragment() {

    private lateinit var database: AppDatabase

    private var _binding: FragmentBirdDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BirdViewModel by activityViewModels {
        val app = requireActivity().application as BirdApplication
        BirdViewModelFactory(app.database.birdSightingDao())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBirdDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = AppDatabase.getDatabase(requireContext())




            // Retrieve and display the bird details

        arguments?.let {
            val safeArgs = BirdDetailsFragmentArgs.fromBundle(it)
            val bird = viewModel.getBirdById(safeArgs.birdId)
            bird?.let { birdData ->
                binding.imageBird.setImageResource(birdData.imageResourceId)
                binding.textBirdName.text = birdData.name
                binding.textBirdDescription.text = birdData.description
                binding.textBirdPoints.text = "Chirps: ${birdData.points}"
            }
            view.findViewById<Button>(R.id.saveSightingButton).setOnClickListener {
                val newSighting = BirdSighting(
                    birdId = safeArgs.birdId,
                    timestamp = Date() // Current time and date
                )
                saveSighting(newSighting)
            }
        }
    }
    private fun saveSighting(sighting: BirdSighting) {
        CoroutineScope(Dispatchers.IO).launch {
            database.birdSightingDao().insert(sighting)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
