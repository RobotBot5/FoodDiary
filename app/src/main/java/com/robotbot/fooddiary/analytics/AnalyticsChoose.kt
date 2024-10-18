package com.robotbot.fooddiary.analytics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun AnalyticChoose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        AnalyticsOneChoose(
            text = R.string.analytics_weight,
            isSelected = true,
            onClick = {}
        )
        AnalyticsOneChoose(
            text = R.string.analytics_calorie,
            isSelected = false,
            onClick = {}
        )
    }
}

@Composable
private fun AnalyticsOneChoose(
    text: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(90.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(text))
        if (isSelected) {
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .background(color = Color.Red)
                    .fillMaxWidth()
            )
        }
        else {
            Spacer(Modifier.height(2.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnalyticsChoosePreview() {
    FoodDiaryTheme {
        AnalyticChoose()
    }
}