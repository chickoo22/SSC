package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapter_progress")
data class ChapterProgressEntity(
    @PrimaryKey val chapterId: String,
    val subjectId: String,
    val chapterTitle: String,
    val status: String // "NOT_STARTED", "IN_PROGRESS", "COMPLETED"
)
