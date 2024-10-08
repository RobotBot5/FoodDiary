package com.robotbot.fooddiary.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileInfoColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProfileInfoRow(
            title = R.string.profile_height,
            value = "177"
        )
        ProfileInfoRow(
            title = R.string.profile_weight,
            value = "90"
        )
        ProfileInfoRow(
            title = R.string.profile_gender,
            value = "Male"
        )
        ProfileInfoRow(
            title = R.string.profile_age,
            value = "18"
        )
        ProfileInfoRowClickable(
            title = R.string.profile_activity,
            value = "Moderate"
        )
        ProfileInfoRowClickable(
            title = R.string.profile_goal,
            value = "Maintain weight"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileInfoColumnPreview() {
    FoodDiaryTheme {
        ProfileInfoColumn()
    }
}