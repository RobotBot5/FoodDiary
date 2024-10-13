package com.robotbot.fooddiary.list

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.profile.ProfileSection
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(modifier = modifier
        .verticalScroll(scrollState)
        .padding(bottom = 15.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = null
            )
            Text(stringResource(R.string.list_today))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null
            )
        }
        ListDayRow()
        ProfileSection(
            title = R.string.list_breakfast
        ) {
            ListMeal()
        }
        ProfileSection(
            title = R.string.list_lunch
        ) {
            ListMeal()
        }
        ProfileSection(
            title = R.string.list_dinner
        ) {
            ListMeal()
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ListScreenPreview() {
    FoodDiaryTheme {
        ListScreen()
    }
}