package com.example.customcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var inputValue: EditText
    private lateinit var buttonToInches: Button
    private lateinit var buttonToCm: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        inputValue = findViewById(R.id.inputValue)
        buttonToInches = findViewById(R.id.buttonToInches)
        buttonToCm = findViewById(R.id.buttonToCm)
        resultTextView = findViewById(R.id.resultTextView)

        // Set up button click listeners
        buttonToInches.setOnClickListener {
            convertToInches()
        }

        buttonToCm.setOnClickListener {
            convertToCm()
        }
    }

    private fun convertToInches() {
        val value = inputValue.text.toString().toDoubleOrNull()
        if (value != null) {
            val result = value * 0.393701 // 1 cm is approximately 0.393701 inches
            resultTextView.text = "$value cm is ${String.format("%.2f", result)} inches"
        } else {
            resultTextView.text = "Invalid input"
        }
    }

    private fun convertToCm() {
        val value = inputValue.text.toString().toDoubleOrNull()
        if (value != null) {
            val result = value * 2.54 // 1 inch is 2.54 cm
            resultTextView.text = "$value inches is ${String.format("%.2f", result)} cm"
        } else {
            resultTextView.text = "Invalid input"
        }
    }
}