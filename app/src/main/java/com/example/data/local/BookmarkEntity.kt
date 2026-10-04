package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey val id: String,
    val title: String,
    val subtitle: String,
    val category: String, // CHAPTER, PAPER, TIP
    val contentSnippet: String,
    val timestamp: Long = System.currentTimeMillis()
)
