package com.kaaneneskpc.notesappmvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kaaneneskpc.navigation.Navigation
import com.kaaneneskpc.notesappmvi.noteList.presentation.NoteListScreen
import com.kaaneneskpc.notesappmvi.ui.theme.NotesAppMVITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppMVITheme {
                Navigation()
            }
        }
    }
}