package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnote.data.NotesDataSource
import com.example.jetnote.model.Note
import com.example.jetnote.screen.NoteScreen
import com.example.jetnote.screen.NoteViewModel
import com.example.jetnote.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel = noteViewModel)

                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {
    val notesList = noteViewModel.getAllNotes()
    NoteScreen(notes = notesList,
        onAddNote = {
            noteViewModel.addNote(it)
        }, onRemoveNote = {
            noteViewModel.removeNote(it)
        })
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNoteTheme {

    }
}