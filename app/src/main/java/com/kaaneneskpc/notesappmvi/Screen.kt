package com.kaaneneskpc.notesappmvi

import  kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object NoteList : Screen

    @Serializable
    data object AddNote : Screen
}