package com.kaaneneskpc.notesappmvi.core.domain.repository

import com.kaaneneskpc.notesappmvi.core.domain.model.Images

interface ImagesRepository {
    suspend fun searchImages(query: String): Images?
}