package com.kaaneneskpc.notesappmvi.noteList.domain.usecase

import com.kaaneneskpc.notesappmvi.core.domain.model.NoteItem
import com.kaaneneskpc.notesappmvi.core.domain.repository.NoteRepository

class GetAllNotes(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(
        isOrderByTitle: Boolean
    ): List<NoteItem> {
        return if (isOrderByTitle) {
            noteRepository.getAllNotes().sortedBy { it.title.lowercase() }
        } else {
            noteRepository.getAllNotes().sortedBy { it.dateAdded }
        }
    }

}