package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CbseDataRepository
import com.example.data.Chapter
import com.example.data.PastPaper
import com.example.data.Subject
import com.example.data.local.AppDatabase
import com.example.data.local.BookmarkEntity
import com.example.data.local.BookmarkRepository
import com.example.network.GeminiService
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar

class CbseViewModel(application: Application) : AndroidViewModel(application) {
    private val bookmarkRepository: BookmarkRepository

    val bookmarks: StateFlow<List<BookmarkEntity>>

    init {
        val dao = AppDatabase.getDatabase(application).bookmarkDao()
        bookmarkRepository = BookmarkRepository(dao)
        bookmarks = bookmarkRepository.allBookmarks
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    }

    val subjects: List<Subject> = CbseDataRepository.subjects
    val pastPapers: List<PastPaper> = CbseDataRepository.pastPapers
    val studyTips = CbseDataRepository.studyTips

    // Calculate days left for Board Exams (e.g., Feb 15, 2027)
    fun getDaysLeftForExams(): Int {
        val targetCalendar = Calendar.getInstance().apply {
            set(2027, Calendar.FEBRUARY, 15, 9, 0, 0)
        }
        val currentCalendar = Calendar.getInstance()
        val diffMillis = targetCalendar.timeInMillis - currentCalendar.timeInMillis
        val diffDays = (diffMillis / (1000 * 60 * 60 * 24)).toInt()
        return if (diffDays > 0) diffDays else 120
    }

    // AI Doubt Solver State
    private val _aiQuery = kotlinx.coroutines.flow.MutableStateFlow("")
    val aiQuery: StateFlow<String> = _aiQuery

    private val _aiAnswer = kotlinx.coroutines.flow.MutableStateFlow("")
    val aiAnswer: StateFlow<String> = _aiAnswer

    private val _isAiLoading = kotlinx.coroutines.flow.MutableStateFlow(false)
    val isAiLoading: StateFlow<Boolean> = _isAiLoading

    fun updateAiQuery(query: String) {
        _aiQuery.value = query
    }

    fun askAi(question: String) {
        if (question.isBlank()) return
        viewModelScope.launch {
            _isAiLoading.value = true
            _aiAnswer.value = ""
            val answer = GeminiService.askAiDoubt(question)
            _aiAnswer.value = answer
            _isAiLoading.value = false
        }
    }

    // Bookmarking Actions
    fun toggleBookmark(id: String, title: String, subtitle: String, category: String, snippet: String, isCurrentlyBookmarked: Boolean) {
        viewModelScope.launch {
            if (isCurrentlyBookmarked) {
                bookmarkRepository.delete(id)
            } else {
                bookmarkRepository.insert(
                    BookmarkEntity(
                        id = id,
                        title = title,
                        subtitle = subtitle,
                        category = category,
                        contentSnippet = snippet
                    )
                )
            }
        }
    }
}
