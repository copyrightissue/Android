package com.example.chitter


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chitter.data.BirdsData
import com.example.chitter.model.Bird

class BirdViewModel : ViewModel() {
    private val _currentBird = MutableLiveData<Bird>()
    val currentBird: LiveData<Bird>
        get() = _currentBird

    private val _birds = MutableLiveData(BirdsData.getBirdsData())
    val birds: LiveData<ArrayList<Bird>>
        get() = _birds

    fun toggleBirdSeen(birdId: Int) {
        _birds.value = _birds.value?.map { bird ->
            if (bird.id == birdId) bird.copy(seen = !bird.seen) else bird
        } as ArrayList<Bird>
    }

    fun calculateScore(): Int {
        return _birds.value?.sumOf { bird ->
            if (bird.seen) bird.points else 0
        } ?: 0
    }
}