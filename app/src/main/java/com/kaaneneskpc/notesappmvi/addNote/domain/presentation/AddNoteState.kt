package com.kaaneneskpc.notesappmvi.addNote.domain.presentation

data class AddNoteState(
    val imageUrl: String = "",
    val title: String = "",
    val description: String = "",

    val isImagesDialogShowing: Boolean = false,

    val imageList: List<String> = emptyList(),
    val searchImagesQuery: String = "",
    val isLoadingImages: Boolean = false,
)