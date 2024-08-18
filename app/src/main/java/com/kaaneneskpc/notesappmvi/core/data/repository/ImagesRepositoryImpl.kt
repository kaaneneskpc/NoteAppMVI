package com.kaaneneskpc.notesappmvi.core.data.repository

import com.kaaneneskpc.notesappmvi.core.data.mapper.toImages
import com.kaaneneskpc.notesappmvi.core.data.remote.ImagesApi
import com.kaaneneskpc.notesappmvi.core.domain.model.Images
import com.kaaneneskpc.notesappmvi.core.domain.repository.ImagesRepository
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val imagesApi: ImagesApi
) : ImagesRepository {

    override suspend fun searchImages(
        query: String
    ): Images? {
        return imagesApi.searchImages(query)?.toImages()
    }

}