package com.kaaneneskpc.notesappmvi.core.presentation

import  kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object NoteList : Screen

    @Serializable
    data object AddNote : Screen
}