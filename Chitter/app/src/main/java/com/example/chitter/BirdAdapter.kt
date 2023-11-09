package com.example.chitter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chitter.databinding.ItemBirdBinding
import com.example.chitter.model.Bird

class BirdAdapter(
    private val birds: List<Bird>,
    private val onBirdSeenChanged: (Bird) -> Unit
) : RecyclerView.Adapter<BirdAdapter.BirdViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val binding = ItemBirdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BirdViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        val bird = birds[position]
        holder.bind(bird, onBirdSeenChanged)
    }

    override fun getItemCount(): Int = birds.size

    class BirdViewHolder(
        private val binding: ItemBirdBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bird: Bird, onBirdSeenChanged: (Bird) -> Unit) {
            binding.birdName.text = bird.name
            binding.birdImage.setImageResource(bird.imageResourceId)
            binding.birdSeen.isChecked = bird.seen
            binding.birdSeen.setOnCheckedChangeListener { _, isChecked ->
                if (bird.seen != isChecked) {
                    onBirdSeenChanged(bird)
                }
            }
        }
    }
}