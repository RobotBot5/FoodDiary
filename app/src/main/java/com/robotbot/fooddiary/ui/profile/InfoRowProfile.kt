package com.robotbot.fooddiary.ui.profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun InfoRowProfile(
    title: Int,
    value: String,
    modifier: Modifier = Modifier
) {
    Surface(color = MaterialTheme.colorScheme.surfaceVariant) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .height(50.dp)
        ) {
            Text(text = stringResource(title),
                modifier = Modifier.weight(1f))
            Text(value)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileInfoRowPreview() {
    FoodDiaryTheme {
        InfoRowProfile(R.string.profile_height, "177")
    }
}