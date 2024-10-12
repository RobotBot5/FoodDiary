package com.robotbot.fooddiary.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(modifier = modifier.verticalScroll(scrollState)) {
        ProfileSection("Profile") {
            ProfileInfoColumn()
        }
        ProfileSection("Results") {
            ProfileResultColumn()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    FoodDiaryTheme {
        ProfileScreen()
    }
}