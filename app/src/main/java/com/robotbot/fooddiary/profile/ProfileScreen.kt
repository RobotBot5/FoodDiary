package com.robotbot.fooddiary.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
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