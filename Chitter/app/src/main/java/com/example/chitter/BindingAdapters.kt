package com.example.chitter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chitter.network.Bird

/**
 * Updates the data shown in the [RecyclerView] for birds.
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Bird>?) {
    val adapter = recyclerView.adapter as BirdListAdapter
    adapter.submitList(data)
}

/**
 * This binding adapter displays the [BirdApiStatus] of the network request in an image view.
 * When the request is loading, it displays a loading animation. If the request has an error,
 * it displays a broken image to reflect the connection error. When the request is finished, it
 * hides the image view.
 */
@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: BirdApiStatus) {
    when(status) {
        BirdApiStatus.LOADING -> {
            statusImageView.visibility = View.GONE
//            statusImageView.setImageResource(R.drawable.loading_animation) // Replace with your actual loading animation drawable
        }
        BirdApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        BirdApiStatus.ERROR -> {
            statusImageView.visibility = View.GONE
            statusImageView.setImageResource(R.drawable.ic_connection_error) // Replace with your actual error image drawable
        }
    }
}