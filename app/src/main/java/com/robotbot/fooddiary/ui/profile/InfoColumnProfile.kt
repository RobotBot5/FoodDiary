package com.robotbot.fooddiary.ui.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme
import com.robotbot.fooddiary.ui.viewmodel.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.robotbot.fooddiary.data.models.Activity
import com.robotbot.fooddiary.data.models.Gender
import com.robotbot.fooddiary.data.models.User
import com.robotbot.fooddiary.ui.viewmodel.UserViewModelFactory

@Composable
fun InfoColumnProfile(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        val user by userViewModel.user.collectAsState()

        if (user == null) {
            Text("Error (user doesn't exist)")
            return
        }

        InfoRowProfile(
            title = R.string.profile_height,
            value = user?.height.toString()
        )
        InfoRowProfile(
            title = R.string.profile_weight,
            value = user?.weight.toString()
        )
        InfoRowProfile(
            title = R.string.profile_gender,
            value = stringResource(user?.gender?.getFormattedLabel() ?: R.string.gender_error)
        )
        InfoRowProfile(
            title = R.string.profile_age,
            value = user?.age.toString()
        )
        InfoRowClickableProfile(
            title = R.string.profile_activity,
            value = stringResource(user?.activity?.getFormattedLabel() ?: R.string.activity_error)
        )
        InfoRowClickableProfile(
            title = R.string.profile_goal,
            value = "Maintain weight"
        )
    }
}

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun ProfileInfoColumnPreview() {
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
        InfoColumnProfile(viewModel)
    }
}