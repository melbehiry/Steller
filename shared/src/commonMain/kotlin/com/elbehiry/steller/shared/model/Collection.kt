package com.elbehiry.steller.shared.model
import kotlinx.serialization.Serializable

@Serializable
data class Collection(
    val id: Int,
    val title: String,
    val description: String?,
    val published_at: String?,
    val updated_at: String?,
    val curated: Boolean?,
    val featured: Boolean?,
    val total_photos: Int,
    val private: Boolean?,
    val share_key: String?,
    val tags: List<Tag>?,
    val cover_photo: Photo?,
    val preview_photos: List<Photo>?,
    val user: User?,
    val links: ColeectionLinks?
)

@Serializable
data class ColeectionLinks(
    val self: String,
    val html: String,
    val photos: String
)
