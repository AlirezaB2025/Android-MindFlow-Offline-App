package com.example.mindflow_offline_app.data.model

import androidx.compose.ui.graphics.Color

data class TestResultModel(
    val status: String,
    val color: Color,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val description: String,
    val recommendations: List<String>
)