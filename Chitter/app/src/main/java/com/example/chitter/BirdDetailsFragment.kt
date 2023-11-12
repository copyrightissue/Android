package com.example.chitter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chitter.databinding.FragmentBirdDetailsBinding


class BirdDetailsFragment : Fragment() {

    private var _binding: FragmentBirdDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BirdViewModel by lazy {
        // Assuming you're using a ViewModelProvider to create your ViewModel
        // ViewModelProvider(this).get(BirdViewModel::class.java)
        // For simplicity in this example, we're directly instantiating it
        BirdViewModel()
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

        // Retrieve and display the bird details
        // Assuming you're passing the bird ID as a fragment argument
        arguments?.let {
            val safeArgs = BirdDetailsFragmentArgs.fromBundle(it)
            val bird = viewModel.getBirdById(safeArgs.birdId)
            bird?.let { birdData ->
                binding.imageBird.setImageResource(birdData.imageResourceId)
                binding.textBirdName.text = birdData.name
                binding.textBirdDescription.text = birdData.description
                binding.textBirdPoints.text = "Points: ${birdData.points}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
