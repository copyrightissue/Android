package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
//import android.widget.Toast
/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice() {
        //create two dice objects with 6 sides and roll them
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
        //find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        //determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 ->  R.drawable.dice_3
            4 ->  R.drawable.dice_4
            5 ->  R.drawable.dice_5
            else ->  R.drawable.dice_6
        }
        val drawableReource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 ->  R.drawable.dice_3
            4 ->  R.drawable.dice_4
            5 ->  R.drawable.dice_5
            else ->  R.drawable.dice_6
        }
        //update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableReource2)
        //update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

//        val resultTextView2: TextView = findViewById(R.id.textView3)
//        resultTextView2.text = diceRoll2.toString()

    }
}
/**
 * Roll the dice and update the screen with the result.
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}