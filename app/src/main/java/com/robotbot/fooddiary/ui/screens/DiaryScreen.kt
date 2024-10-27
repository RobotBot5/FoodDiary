package com.robotbot.fooddiary.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.list.ListDayRow
import com.robotbot.fooddiary.ui.list.ListMeal
import com.robotbot.fooddiary.ui.profile.SectionProfile
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun DiaryScreen(modifier: Modifier = Modifier) {
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
            Text(
                text = stringResource(R.string.list_today),
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null
            )
        }
        ListDayRow()
        SectionProfile(
            title = R.string.list_breakfast
        ) {
            ListMeal()
        }
        SectionProfile(
            title = R.string.list_lunch
        ) {
            ListMeal()
        }
        SectionProfile(
            title = R.string.list_dinner
        ) {
            ListMeal()
        }

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ListScreenPreviewLight() {
    FoodDiaryTheme {
        Surface {
            DiaryScreen()
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ListScreenPreviewDark() {
    FoodDiaryTheme {
        Surface {
            DiaryScreen()
        }
    }
}