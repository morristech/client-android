package com.guru.cocktails.domain.model

import java.sql.Timestamp

data class Comment(
    val id: Long,
    val objectTypeID: Int,
    val objectID: Long,
    val objectName: String,
    val objectImageFileName: String,
    val userID: String,
    val content: String,
    val numLikes: Int,
    val numLikesDis: Int,
    val createdAt: Timestamp,
    val userImage: String,
    val userName: String
)