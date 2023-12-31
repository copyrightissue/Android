package com.example.diceroller

import org.junit.Test

import org.junit.Assert.*
import org.junit.Assert.assertTrue

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generates_number() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        assertTrue("Dice roll is not between 1 and 6", diceRoll in 1..6)

    }
}