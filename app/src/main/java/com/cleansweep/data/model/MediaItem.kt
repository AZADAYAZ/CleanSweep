/*
 * CleanSweep
 * Copyright (c) 2025 LoopOtto
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.cleansweep.data.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class MediaItem(
    val id: String,
    val uri: Uri,
    val displayName: String,
    val mimeType: String,
    val dateAdded: Long,
    val dateModified: Long,
    val size: Long,
    val bucketId: String,
    val bucketName: String,
    val isVideo: Boolean,
    val isAudio: Boolean = false,
    val width: Int = 0,
    val height: Int = 0,
    val duration: Long = 0,
    val artist: String? = null,
    val album: String? = null,
    val title: String? = null
) : Parcelable {
    val isImage: Boolean
        get() = !isVideo && !isAudio

    val filePath: String
        get() = when (uri.scheme) {
            "file" -> uri.path ?: ""
            else -> ""
        }

    val file: File
        get() = if (filePath.isNotEmpty()) File(filePath) else File("")
}
