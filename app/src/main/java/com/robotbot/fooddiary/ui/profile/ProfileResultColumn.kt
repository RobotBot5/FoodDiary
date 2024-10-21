package com.robotbot.fooddiary.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileResultColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProfileResultRow(
            title = R.string.profile_metabolic,
            value = "1620 kcal",
            icon = Icons.Filled.LocalFireDepartment
        )
        ProfileResultRow(
            title = R.string.profile_mass_index,
            value = "19.86",
            icon = Icons.Filled.Egg
        )
        ProfileResultRow(
            title = R.string.profile_water,
            value = "2250",
            icon = Icons.Filled.WaterDrop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileResultColumnPreview() {
    FoodDiaryTheme {
        ProfileResultColumn()
    }
}