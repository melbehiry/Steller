package com.elbehiry.steller.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val id: String = "",
    val created_at: String? = "",
    val updated_at: String? = "",
    val width: Int? = 0,
    val height: Int? = 0,
    val color: String? = "#E0E0E0",
    val views: Int? = 0,
    val downloads: Int? = 0,
    val likes: Int? = 0,
    var liked_by_user: Boolean?,
    val description: String? = "",
    val alt_description: String? = "",
    val exif: Exif? = null,
    val location: Location? = null,
    val tags: List<Tag>? = emptyList(),
    val current_user_collections: List<Collection>? = emptyList(),
    val sponsorship: Sponsorship? = null,
    val urls: Urls? = null,
    val links: Links? = null,
    val user: User? = null,
    val statistics: PhotoStatistics? = null
)

@Serializable
data class Exif(
    val make: String?,
    val model: String?,
    val exposure_time: String?,
    val aperture: String?,
    val focal_length: String?,
    val iso: Int?
)

@Serializable
data class Location(
    val city: String?,
    val country: String?,
    val position: Position?
)

@Serializable
data class Position(
    val latitude: Double?,
    val longitude: Double?
)

@Serializable
data class Tag(
    val type: String?,
    val title: String?
)

@Serializable
data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)

@Serializable
data class Links(
    val self: String,
    val html: String,
    val download: String,
    val download_location: String
)

@Serializable
data class Sponsorship(
    val sponsor: User?
)