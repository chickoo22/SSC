package com.example.data

data class Subject(
    val id: String,
    val name: String,
    val code: String,
    val iconName: String,
    val totalChapters: Int,
    val description: String,
    val chapters: List<Chapter>
)

data class Chapter(
    val id: String,
    val chapterNumber: Int,
    val title: String,
    val weightage: String,
    val summary: String,
    val importantFormulas: List<String> = emptyList(),
    val keyQuestions: List<String> = emptyList()
)

data class PastPaper(
    val id: String,
    val year: String,
    val subject: String,
    val title: String,
    val type: PaperType, // SOLVED_BOARD_PAPER, SAMPLE_PAPER
    val totalMarks: Int,
    val durationHours: String,
    val sections: List<PaperSection>
)

enum class PaperType {
    SOLVED_BOARD_PAPER, SAMPLE_PAPER, PRACTICE_PAPER
}

data class PaperSection(
    val sectionName: String,
    val marksPerQuestion: Int,
    val numberOfQuestions: Int,
    val sampleQuestions: List<String>
)

data class StudyTip(
    val title: String,
    val tip: String,
    val category: String
)
