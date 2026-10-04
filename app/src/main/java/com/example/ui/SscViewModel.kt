package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.SscDataRepository
import com.example.data.local.AppDatabase
import com.example.data.local.BookmarkEntity
import com.example.data.local.BookmarkRepository
import com.example.data.local.ChapterProgressEntity
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar

class SscViewModel(application: Application) : AndroidViewModel(application) {
    private val bookmarkRepository: BookmarkRepository
    private val chapterProgressDao = AppDatabase.getDatabase(application).chapterProgressDao()

    val bookmarks: StateFlow<List<BookmarkEntity>>
    val chapterProgress: StateFlow<List<ChapterProgressEntity>>

    // Theme Mode State
    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode

    fun toggleDarkMode() {
        _isDarkMode.value = !_isDarkMode.value
    }

    // Pomodoro Timer State
    private val WORK_TIME_SECONDS = 25 * 60
    private val BREAK_TIME_SECONDS = 5 * 60

    private val _timerSecondsLeft = MutableStateFlow(WORK_TIME_SECONDS)
    val timerSecondsLeft: StateFlow<Int> = _timerSecondsLeft

    private val _isTimerRunning = MutableStateFlow(false)
    val isTimerRunning: StateFlow<Boolean> = _isTimerRunning

    private val _isWorkSession = MutableStateFlow(true)
    val isWorkSession: StateFlow<Boolean> = _isWorkSession

    private val _completedSessionsCount = MutableStateFlow(0)
    val completedSessionsCount: StateFlow<Int> = _completedSessionsCount

    private var timerJob: Job? = null

    init {
        val dao = AppDatabase.getDatabase(application).bookmarkDao()
        bookmarkRepository = BookmarkRepository(dao)
        bookmarks = bookmarkRepository.allBookmarks
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

        chapterProgress = chapterProgressDao.getAllProgress()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    }

    val subjects = SscDataRepository.subjects
    val pastPapers = SscDataRepository.pastPapers
    val studyTips = SscDataRepository.studyTips

    fun getDaysLeftForExams(): Int {
        val targetCalendar = Calendar.getInstance().apply {
            set(2027, Calendar.MARCH, 1, 10, 0, 0)
        }
        val currentCalendar = Calendar.getInstance()
        val diffMillis = targetCalendar.timeInMillis - currentCalendar.timeInMillis
        val diffDays = (diffMillis / (1000 * 60 * 60 * 24)).toInt()
        return if (diffDays > 0) diffDays else 150
    }

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

    fun updateChapterStatus(chapterId: String, subjectId: String, chapterTitle: String, status: String) {
        viewModelScope.launch {
            chapterProgressDao.updateProgress(
                ChapterProgressEntity(
                    chapterId = chapterId,
                    subjectId = subjectId,
                    chapterTitle = chapterTitle,
                    status = status
                )
            )
        }
    }

    // Pomodoro Controls
    fun startTimer() {
        if (_isTimerRunning.value) return
        _isTimerRunning.value = true
        timerJob = viewModelScope.launch {
            while (_isTimerRunning.value && _timerSecondsLeft.value > 0) {
                delay(1000L)
                _timerSecondsLeft.value -= 1
            }
            if (_timerSecondsLeft.value == 0) {
                _isTimerRunning.value = false
                if (_isWorkSession.value) {
                    _completedSessionsCount.value += 1
                    // Switch to Break
                    _isWorkSession.value = false
                    _timerSecondsLeft.value = BREAK_TIME_SECONDS
                } else {
                    // Switch to Work
                    _isWorkSession.value = true
                    _timerSecondsLeft.value = WORK_TIME_SECONDS
                }
            }
        }
    }

    fun pauseTimer() {
        _isTimerRunning.value = false
        timerJob?.cancel()
    }

    fun resetTimer() {
        _isTimerRunning.value = false
        timerJob?.cancel()
        _timerSecondsLeft.value = if (_isWorkSession.value) WORK_TIME_SECONDS else BREAK_TIME_SECONDS
    }

    fun switchSessionMode(isWork: Boolean) {
        _isTimerRunning.value = false
        timerJob?.cancel()
        _isWorkSession.value = isWork
        _timerSecondsLeft.value = if (isWork) WORK_TIME_SECONDS else BREAK_TIME_SECONDS
    }
}
