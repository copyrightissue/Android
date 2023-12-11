package com.example.simplenote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.simplenote.database.NoteDatabase
import com.example.simplenote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpViewModel()
    }

    private fun setUpViewModel(){
        val noteRepository=NoteRepository(NoteDatabase(this))

        val viewModelProvider=NoteViewModelProvider(application, noteRepository)

        //owner and factory as a param
        noteViewModel= ViewModelProvider(this, viewModelProvider).get(NoteViewModel::class.java)
    }
}