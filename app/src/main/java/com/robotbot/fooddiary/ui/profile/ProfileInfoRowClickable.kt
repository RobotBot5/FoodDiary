package com.robotbot.fooddiary.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileInfoRowClickable(
    title: Int,
    value: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Surface(color = MaterialTheme.colorScheme.surfaceVariant) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .height(50.dp)
                .clickable(onClick = onClick)
        ) {
            Text(text = stringResource(title),
                modifier = Modifier.weight(1f))
            Text(value)
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                Modifier
                    .padding(start = 5.dp)
                    .size(30.dp)
                    .alpha(0.45f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileInfoRowClickablePreview() {
    FoodDiaryTheme {
        ProfileInfoRowClickable(R.string.profile_activity, "Moderate")
    }
}