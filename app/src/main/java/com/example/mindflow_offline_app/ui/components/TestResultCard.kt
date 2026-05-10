package com.example.mindflow_offline_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SentimentDissatisfied
import androidx.compose.material.icons.filled.SentimentNeutral
import androidx.compose.material.icons.filled.SentimentSatisfied
import androidx.compose.material.icons.filled.SentimentVeryDissatisfied
import androidx.compose.material.icons.filled.SentimentVerySatisfied
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mindflow_offline_app.ui.theme.MoodBad
import com.example.mindflow_offline_app.ui.theme.MoodExcellent
import com.example.mindflow_offline_app.ui.theme.MoodGood
import com.example.mindflow_offline_app.ui.theme.MoodNormal
import com.example.mindflow_offline_app.ui.theme.MoodVeryBad

@Composable
fun TestResultCard(testResultsSize:Int,score: Int, date: String) {
    val questionCount = testResultsSize
    val maxOptionScore = 3
    val maxScore = questionCount * maxOptionScore
    val scorePercent = if (maxScore > 0) score.toFloat() / maxScore else 0f
    val (statusText, statusColor, statusIcon) = when {
        scorePercent >= 0.80f -> Triple("عالی", MoodExcellent, Icons.Default.SentimentVerySatisfied)
        scorePercent >= 0.60f -> Triple("خوب", MoodGood, Icons.Default.SentimentSatisfied)
        scorePercent >= 0.40f -> Triple("متوسط", MoodNormal, Icons.Default.SentimentNeutral)
        scorePercent >= 0.20f -> Triple("نیاز به توجه", MoodBad, Icons.Default.SentimentDissatisfied)
        else -> Triple("نیاز به مشاوره", MoodVeryBad, Icons.Default.SentimentVeryDissatisfied)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(statusColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = statusIcon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = statusText,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "امتیاز: $score",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = statusColor.copy(alpha = 0.2f)
            ) {
                Text(
                    text = "$score",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = statusColor
                )
            }
        }
    }
}