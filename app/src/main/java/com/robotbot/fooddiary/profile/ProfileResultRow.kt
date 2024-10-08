package com.robotbot.fooddiary.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileResultRow(
    title: Int,
    value: String,
    icon: ImageVector,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
        .background(color = Color.Cyan)
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(65.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
//            painter = painterResource(R.drawable.baseline_local_fire_department_20),
            contentDescription = null,
            imageVector = icon,
            modifier = Modifier
                .size(35.dp)
        )
        Column(modifier = Modifier
            .weight(1f)
            .padding(start = 20.dp)
        ) {
            Text(text = stringResource(title))
            Text(value)
        }
        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            Modifier
                .padding(start = 5.dp)
                .size(30.dp)
                .alpha(0.45f))
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileResultRowPreview() {
    FoodDiaryTheme {
        ProfileResultRow(
            R.string.profile_metabolic,
            "1620 kcal",
            Icons.Default.LocalFireDepartment
        )
    }
}