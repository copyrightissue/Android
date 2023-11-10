package com.example.chitter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chitter.data.BirdsData
import com.example.chitter.model.Bird

class BirdViewModel : ViewModel() {
    private val _birds = MutableLiveData<List<Bird>>(BirdsData.getBirdsData())
    val birds: LiveData<List<Bird>> = _birds

    fun toggleBirdSeen(birdId: Int, seen: Boolean) {
        _birds.value = _birds.value?.map { bird ->
            if (bird.id == birdId) bird.copy(seen = seen) else bird
        }
    }

    fun calculateScore(): Int {
        return _birds.value?.sumOf { bird ->
            if (bird.seen) bird.points else 0
        } ?: 0
    }
    fun getBirdById(birdId: Int): Bird? {
        return birds.value?.find { it.id == birdId }
    }
}
