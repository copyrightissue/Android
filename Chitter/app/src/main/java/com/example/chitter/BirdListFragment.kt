package com.example.chitter
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.chitter.BirdAdapter
import com.example.chitter.BirdViewModel



class BirdListFragment : Fragment() {

    private val viewModel: BirdViewModel by viewModels()
    private var _binding: FragmentBirdListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: BirdAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBirdListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BirdListAdapter(viewModel.birds.value ?: arrayListOf()) { bird ->
            viewModel.toggleBirdSeen(bird.id)
        }

        binding.birdListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.birdListRecyclerView.adapter = adapter

        viewModel.birds.observe(viewLifecycleOwner) { birds ->
            adapter = BirdAdapter(birds, viewModel::toggleBirdSeen)
            binding.birdListRecyclerView.adapter = adapter
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