package com.kaaneneskpc.notesappmvi.core.domain.repository

import com.kaaneneskpc.notesappmvi.core.domain.model.NoteItem

interface NoteRepository {
    suspend fun upsertNote(noteItem: NoteItem)
    suspend fun deleteNote(noteItem: NoteItem)
    suspend fun getAllNotes(): List<NoteItem>
}