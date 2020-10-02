package com.elbehiry.steller.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class PhotoStatistics(
    val id: String,
    val downloads: Downloads,
    val views: Views,
    val likes: Likes
)

data class UserStatistics(
    val username: String,
    val downloads: Downloads,
    val views: Views,
    val likes: Likes
)

@Serializable
data class Downloads(
    val total: Int,
    val historical: Historical
)

@Serializable
data class Views(
    val total: Int,
    val historical: Historical
)

@Serializable
data class Likes(
    val total: Int,
    val historical: Historical
)

@Serializable
data class Historical(
    val change: Int,
    val resolution: String,
    val quality: String,
    val values: List<Value>
)

@Serializable
data class Value(
    val date: String,
    val value: Int
)
