package com.robotbot.fooddiary.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme
import com.robotbot.fooddiary.ui.theme.LocalExtendedColors

@Composable
fun ListDayRow(modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.surfaceVariant) {
        Column(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ProgressColumn(
                    title = R.string.list_carbohydrate,
                    color = LocalExtendedColors.current.carbohydrateColor,
                    trackColor = LocalExtendedColors.current.carbohydrateBackgroundColor,
                    modifier = Modifier.weight(1f)
                )
                ProgressColumn(
                    title = R.string.list_protein,
                    color = LocalExtendedColors.current.proteinColor,
                    trackColor = LocalExtendedColors.current.proteinBackgroundColor,
                    modifier = Modifier.weight(1f)
                )
                ProgressColumn(
                    title = R.string.list_fat,
                    color = LocalExtendedColors.current.fatColor,
                    trackColor = LocalExtendedColors.current.fatBackgroundColor,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(Modifier.height(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LinearProgressIndicator(
                    progress = {
                        0.2f
                    },
                    color = LocalExtendedColors.current.proteinColor,
                    trackColor = LocalExtendedColors.current.proteinBackgroundColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(CircleShape)
                )
                Text(
                    text =  "0 / 2228 kcal",
                    color = LocalExtendedColors.current.proteinColor
                )
            }
        }
    }
}

@Composable
fun ProgressColumn(
    title: Int,
    color: Color,
    trackColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(title),
            color = trackColor
        )
        LinearProgressIndicator(
            progress = {
                0.2f
            },
            color = color,
            trackColor = trackColor,
            modifier = Modifier.clip(CircleShape)

        )
        Text(
            text = "0 / 279 g",
            color = trackColor
        )
    }
}

@Preview
@Composable
private fun ListDayRowPreview() {
    FoodDiaryTheme {
        ListDayRow()
    }
}