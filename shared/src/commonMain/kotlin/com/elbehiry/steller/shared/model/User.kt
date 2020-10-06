package com.elbehiry.steller.shared.model

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val id: String = "",
    val updated_at: String? = "",
    val username: String? = "",
    val name: String? = "",
    val first_name: String? = "",
    val last_name: String? = "",
    val instagram_username: String? = "",
    val twitter_username: String? = "",
    val portfolio_url: String? = "",
    val bio: String? = "",
    val location: String? = "",
    val total_likes: Int? = 0,
    val total_photos: Int? = 0,
    val total_collections: Int? = 0,
    val followed_by_user: Boolean? = false,
    val followers_count: Int? = 0,
    val following_count: Int? = 0,
    val downloads: Int? = 0,
    val profile_image: ProfileImage? = null,
    val badge: Badge? = null,
    val links: UserLinks? = null,
    val photos: List<Photo>? = emptyList()
)

@Serializable
data class ProfileImage(
    val small: String,
    val medium: String,
    val large: String
)

@Serializable
data class Badge(
    val title: String?,
    val primary: Boolean?,
    val slug: String?,
    val link: String?
)

@Serializable
data class UserLinks(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String,
    val following: String,
    val followers: String
)
