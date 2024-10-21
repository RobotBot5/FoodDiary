package com.robotbot.fooddiary.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme
import com.robotbot.fooddiary.ui.viewmodel.UserViewModel

@Composable
fun ProfileScreen(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(modifier = modifier
        .verticalScroll(scrollState)
        .padding(bottom = 15.dp)
    ) {
        ProfileSection(R.string.profile_profile) {
            ProfileInfoColumn(userViewModel)
        }
        ProfileSection(R.string.profile_results) {
            ProfileResultColumn()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    FoodDiaryTheme {
        ProfileScreen(userViewModel = viewModel())
    }
}