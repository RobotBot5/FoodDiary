package com.robotbot.fooddiary.list

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

@Composable
fun ListDayRow(modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
        Column(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ProgressColumn(
                    title = R.string.list_carbohydrate,
                    color = Color.Black,
                    trackColor = Color.Red,
                    modifier = Modifier.weight(1f)
                )
                ProgressColumn(
                    title = R.string.list_protein,
                    color = Color.Black,
                    trackColor = Color.Blue,
                    modifier = Modifier.weight(1f)
                )
                ProgressColumn(
                    title = R.string.list_fat,
                    color = Color.Black,
                    trackColor = Color.Yellow,
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
                    color = Color.Black,
                    trackColor = Color.Blue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(CircleShape)
                )
                Text("0 / 2228 kcal")
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