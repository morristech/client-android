package com.guru.cocktails.domain.model

import java.time.LocalDateTime

data class Comment(
    val id: Long,
    val objectForeignKey: Long,
    val objectName: String,
    val content: String,
    var numLikes: Int,
    var numDislikes: Int,
    var isVisible: Boolean,
    var updateTime: LocalDateTime,
    var createdTime: LocalDateTime
)