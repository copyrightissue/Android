package com.example.chitter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chitter.databinding.ItemBirdBinding
import com.example.chitter.model.Bird

class BirdAdapter(
    private var birds: List<Bird>,
    private val onBirdSeenChanged: (Int, Boolean) -> Unit
) : RecyclerView.Adapter<BirdAdapter.BirdViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val binding = ItemBirdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BirdViewHolder(binding, onBirdSeenChanged)
    }

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        holder.bind(birds[position])
    }

    override fun getItemCount(): Int = birds.size

    class BirdViewHolder(
        private val binding: ItemBirdBinding,
        private val onBirdSeenChanged: (Int, Boolean) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bird: Bird) {
            binding.birdName.text = bird.name
            binding.birdImage.setImageResource(bird.imageResourceId)
            binding.birdSeen.isChecked = bird.seen
            binding.birdSeen.setOnCheckedChangeListener { _, isChecked ->
                if (bird.seen != isChecked) {
                    onBirdSeenChanged(bird.id, isChecked)
                }
            }
        }
    }

    fun updateBirds(newBirds: List<Bird>) {
        birds = newBirds
        notifyDataSetChanged()
    }
}
