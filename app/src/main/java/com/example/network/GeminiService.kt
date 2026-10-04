package com.example.network

import com.example.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object GeminiService {
    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    suspend fun askAiDoubt(prompt: String): String = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isEmpty() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext "Error: Gemini API Key is missing. Please configure your API key in the AI Studio Secrets panel."
        }

        val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=$apiKey"

        val systemInstruction = JSONObject().apply {
            put("parts", JSONArray().put(JSONObject().put("text", "You are an expert CBSE Class 10 Board Exam tutor and mentor. Give clear, accurate, step-by-step explanations, important exam tips, and NCERT-aligned solutions.")))
        }

        val contentsArray = JSONArray().apply {
            put(JSONObject().put("parts", JSONArray().put(JSONObject().put("text", prompt))))
        }

        val requestBodyJson = JSONObject().apply {
            put("systemInstruction", systemInstruction)
            put("contents", contentsArray)
        }

        val body = requestBodyJson.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    return@withContext "Error: ${response.code} - ${response.message}"
                }
                val responseString = response.body?.string() ?: return@withContext "No response from AI"
                val jsonResponse = JSONObject(responseString)
                val candidates = jsonResponse.getJSONArray("candidates")
                if (candidates.length() > 0) {
                    val candidate = candidates.getJSONObject(0)
                    val content = candidate.getJSONObject("content")
                    val parts = content.getJSONArray("parts")
                    if (parts.length() > 0) {
                        return@withContext parts.getJSONObject(0).getString("text")
                    }
                }
                return@withContext "No answer generated."
            }
        } catch (e: Exception) {
            return@withContext "Exception: ${e.localizedMessage ?: e.toString()}"
        }
    }
}
