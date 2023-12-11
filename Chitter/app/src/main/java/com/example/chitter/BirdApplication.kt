package com.example.chitter

import android.app.Application
import com.example.chitter.data.AppDatabase

class BirdApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}