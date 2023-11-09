package com.example.chitter.data
import com.example.chitter.R
import com.example.chitter.model.Bird
object BirdsData {

    fun getBirdsData(): ArrayList<Bird> {
        return arrayListOf(
            Bird(
                id = 1,
                name = "Blue Jay",
                description = "Description...",
                imageResourceId = R.drawable.img_bluejay,
                points = 3
            ),
            Bird(
                id = 2,
                name = "Cardinal",
                description = "Description...",
                imageResourceId = R.drawable.img_cardinal,
                points = 2
            ),
            Bird(
                id = 3,
                name = "Chickadee",
                description = "Description...",
                imageResourceId = R.drawable.img_chickadee,
                points = 1
            ),
            Bird(
                id = 4,
                name = "Crow",
                description = "Description...",
                imageResourceId = R.drawable.img_crow,
                points = 1
            ),
            Bird(
                id = 5,
                name = "Dove",
                description = "Description...",
                imageResourceId = R.drawable.img_dove,
                points = 4
            ),
            Bird(
                id = 6,
                name = "Goldfinch",
                description = "Description...",
                imageResourceId = R.drawable.img_goldfinch,
                points = 5
            ),


        )
    }
}