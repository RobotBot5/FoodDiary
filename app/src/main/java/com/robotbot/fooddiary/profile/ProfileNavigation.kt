package com.robotbot.fooddiary.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.TabletMac
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Analytics,
                    contentDescription = null
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.TabletMac,
                    contentDescription = null
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ProfileNavigationPreview(modifier: Modifier = Modifier) {
    FoodDiaryTheme {
        ProfileNavigation()
    }
}