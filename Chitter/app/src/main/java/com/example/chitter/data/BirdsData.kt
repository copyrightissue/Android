package com.example.chitter.data
import com.example.chitter.R
import com.example.chitter.model.Bird
object BirdsData {

    fun getBirdsData(): ArrayList<Bird> {
        return arrayListOf(
            Bird(
                id = 1,
                name = "Blue Jay",
                description = "Description: Blue Jays are noisy, bold, and aggressive. They are talented mimics, and can copy the calls of many other birds. They often visit feeders, and will eat almost anything, including bread, peanuts, suet, and seeds. They may even eat other birds' eggs and nestlings.",
                imageResourceId = R.drawable.img_bluejay,
                points = 3
            ),
            Bird(
                id = 2,
                name = "Cardinal",
                description = "Description: Cardinal's are a common sight at bird feeders, and they can be found in woodlands, gardens, parks, and shrubby areas throughout the eastern part of the United States. They are also common in backyards, especially in the winter. They are ground feeders, and eat seeds, fruit, and insects.",
                imageResourceId = R.drawable.img_cardinal,
                points = 2
            ),
            Bird(
                id = 3,
                name = "Chickadee",
                description = "Description: Chickadee's are small birds with short, thin bills. They are common in woodlands, parks, and suburban areas. They are often found in flocks, and they eat insects, seeds, and berries. They are frequent visitors to bird feeders, especially in the winter.",
                imageResourceId = R.drawable.img_chickadee,
                points = 1
            ),
            Bird(
                id = 4,
                name = "Crow",
                description = "Description: Crow's are large, black birds with heavy bills and a deep, hoarse voice. They are common in woodlands, fields, and towns. They are omnivores, and will eat almost anything, including insects, seeds, fruit, carrion, and garbage. They are often seen in large flocks, and are very intelligent.",
                imageResourceId = R.drawable.img_crow,
                points = 1
            ),
            Bird(
                id = 5,
                name = "Dove",
                description = "Description: Dove's are plump, small-headed birds with short legs and a short, thin bill. They are common in towns and cities, and are often seen perched on wires or on the ground. They eat seeds and fruit, and are frequent visitors to bird feeders. They are also known as Rock Doves or Rock Pigeons.",
                imageResourceId = R.drawable.img_dove,
                points = 4
            ),
            Bird(
                id = 6,
                name = "Goldfinch",
                description = "Description: Goldfinch's are small, brightly colored finches with conical bills. They are common in fields and weedy areas, and are frequent visitors to bird feeders. They eat seeds almost exclusively, and are especially fond of thistle seeds. They are also known as American Goldfinches.",
                imageResourceId = R.drawable.img_goldfinch,
                points = 5
            ),


        )
    }
}