package com.example.jetnote.data

import com.example.jetnote.model.Note

class NotesDataSource{
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good night", description = "We went on a vacation an sogya")
        )
    }
}