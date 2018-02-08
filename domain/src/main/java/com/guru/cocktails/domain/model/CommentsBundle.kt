package com.guru.cocktails.domain.model


data class CommentsBundle<T>(
    val data: T,
    val comments: List<Comment>
)