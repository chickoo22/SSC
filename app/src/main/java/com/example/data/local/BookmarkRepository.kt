package com.example.data.local

import kotlinx.coroutines.flow.Flow

class BookmarkRepository(private val bookmarkDao: BookmarkDao) {
    val allBookmarks: Flow<List<BookmarkEntity>> = bookmarkDao.getAllBookmarks()

    fun isBookmarked(id: String): Flow<Boolean> = bookmarkDao.isBookmarked(id)

    suspend fun insert(bookmark: BookmarkEntity) = bookmarkDao.insertBookmark(bookmark)

    suspend fun delete(id: String) = bookmarkDao.deleteBookmarkById(id)
}
