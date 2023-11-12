package com.example.chitter.model


data class Bird(
    val id: Int,
    val name: String,
    val description: String,
    val imageResourceId: Int,
    var seen: Boolean = false,
    val points: Int
    )
