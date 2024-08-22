package com.kaaneneskpc.notesappmvi.noteList.domain.usecase

import com.kaaneneskpc.notesappmvi.core.domain.model.NoteItem
import com.kaaneneskpc.notesappmvi.core.domain.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: NoteItem) {
        noteRepository.deleteNote(note)
    }

}