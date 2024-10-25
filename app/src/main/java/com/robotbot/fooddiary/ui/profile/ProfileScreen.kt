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
import com.robotbot.fooddiary.data.models.Activity
import com.robotbot.fooddiary.data.models.Gender
import com.robotbot.fooddiary.data.models.User
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme
import com.robotbot.fooddiary.ui.viewmodel.UserViewModel
import com.robotbot.fooddiary.ui.viewmodel.UserViewModelFactory

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
    val mockUser = User(
        name = "Ilya Kazakov",
        height = 177,
        weight = 80,
        gender = Gender.Male,
        age = 30,
        activity = Activity.Moderate
    )
    val factory = UserViewModelFactory(mockUser)
    val viewModel: UserViewModel = viewModel(factory = factory)

    FoodDiaryTheme {
        ProfileScreen(userViewModel = viewModel)
    }
}