package com.kaaneneskpc.notesappmvi.core.data.mapper

import com.kaaneneskpc.notesappmvi.core.data.remote.dto.ImageListDto
import com.kaaneneskpc.notesappmvi.core.domain.model.Images

fun ImageListDto.toImages(): Images {
    return Images(
        images = hits?.map { imageDto ->
            imageDto.previewURL.orEmpty()
        } ?: emptyList()
    )
}