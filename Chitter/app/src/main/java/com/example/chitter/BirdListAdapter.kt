package com.example.chitter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chitter.databinding.ListViewItemBinding
import com.example.chitter.network.Bird

class BirdListAdapter(private val clickListener: BirdListener) :
    ListAdapter<Bird, BirdListAdapter.BirdViewHolder>(DiffCallback) {

    class BirdViewHolder(private var binding: ListViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: BirdListener, bird: Bird) {
            binding.bird = bird // Make sure your ListViewItemBinding has a 'bird' variable
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Bird>() {
        override fun areItemsTheSame(oldItem: Bird, newItem: Bird): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Bird, newItem: Bird): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BirdViewHolder(ListViewItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        val bird = getItem(position)
        holder.bind(clickListener, bird)
    }
}

class BirdListener(val clickListener: (bird: Bird) -> Unit) {
    fun onClick(bird: Bird) = clickListener(bird)
}