package com.example.simplenote

import com.example.simplenote.database.Note
import com.example.simplenote.database.NoteDatabase

class NoteRepository(private val db: NoteDatabase) {

    suspend fun addNote(note: Note) =db.getNoteDao().insertNote(note)
    suspend fun updateNote(note:Note)= db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note)=db.getNoteDao().deleteNote(note)
    fun getAllNotes() =db.getNoteDao().getAllNotes()
    fun searchNotes(query:String?) = db.getNoteDao().searchNote(query)
}