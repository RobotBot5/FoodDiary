package com.robotbot.fooddiary.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TabletMac
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileNavigation(
    modifier: Modifier = Modifier,
    onNavigateToProfile: () -> Unit,
    onNavigateToAnalytics: () -> Unit,
    onNavigateToList: () -> Unit,
    selectedIndex: Int
) {
    Surface(color = MaterialTheme.colorScheme.primaryContainer) {
        Column(modifier = modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
            ) {
                Text(
                    text = stringResource(R.string.app_title),
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.titleLarge
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        Modifier.size(35.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                NavigationItem(
                    icon = Icons.Default.Person,
                    isSelected = selectedIndex == 0,
                    onClick = onNavigateToProfile,
                    modifier = Modifier.weight(1f)
                )
                NavigationItem(
                    icon = Icons.Default.Analytics,
                    isSelected = selectedIndex == 1,
                    onClick = onNavigateToAnalytics,
                    modifier = Modifier.weight(1f)
                )
                NavigationItem(
                    icon = Icons.Default.TabletMac,
                    isSelected = selectedIndex == 2,
                    onClick = onNavigateToList,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun NavigationItem(
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            Modifier
                .padding(bottom = 3.dp)
                .size(35.dp)
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                    .height(2.dp)
                    .fillMaxWidth()
            )
        }
        else {
            Spacer(
                modifier = Modifier.height(2.dp)
            )
        }
    }
}

@Preview
@Composable
fun ProfileNavigationPreview(modifier: Modifier = Modifier) {
    FoodDiaryTheme {
        ProfileNavigation(
            onNavigateToProfile = {},
            onNavigateToAnalytics = {},
            onNavigateToList = {},
            selectedIndex = 0
        )
    }
}