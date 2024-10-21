package com.robotbot.fooddiary.ui.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme
import com.robotbot.fooddiary.ui.viewmodel.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileInfoColumn(
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

        ProfileInfoRow(
            title = R.string.profile_height,
            value = user?.height.toString()
        )
        ProfileInfoRow(
            title = R.string.profile_weight,
            value = user?.weight.toString()
        )
        ProfileInfoRow(
            title = R.string.profile_gender,
            value = user?.gender?.name ?: "Unknown"
        )
        ProfileInfoRow(
            title = R.string.profile_age,
            value = user?.age.toString()
        )
        ProfileInfoRowClickable(
            title = R.string.profile_activity,
            value = user?.activity?.name ?: "Unknown"
        )
        ProfileInfoRowClickable(
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
    FoodDiaryTheme {
        ProfileInfoColumn(viewModel())
    }
}