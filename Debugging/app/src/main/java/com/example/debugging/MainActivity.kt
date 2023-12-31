package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logging()
        division()
    }
    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(5) {
            //val result = numerator / demoninator
            Log.v(TAG, "${numerator / denominator}}")
            denominator--
        }
    }
    fun logging(){
        Log.v(TAG, "hello world")

    }
}