package com.robotbot.fooddiary.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R

@Composable
fun ListMeal(modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = null
                )
                Text(
                    "Add food"
                )
            }
            Spacer(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .height(5.dp)
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                InfoColumn(
                    title = R.string.list_carbohydrate,
                    color = Color.Red
                )
                InfoColumn(
                    title = R.string.list_protein,
                    color = Color.Blue
                )
                InfoColumn(
                    title = R.string.list_fat,
                    color = Color.Yellow
                )
                InfoColumn(
                    title = R.string.list_calories,
                    color = Color.Blue
                )
            }
        }
    }
}

@Composable
fun InfoColumn(
    title: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "0",
            color = color
        )
        Text(
            text = stringResource(title),
            color = color
        )
    }
}

@Preview
@Composable
private fun ListMealPreview() {
    ListMeal()
}