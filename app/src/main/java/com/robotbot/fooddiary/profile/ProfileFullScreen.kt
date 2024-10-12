package com.robotbot.fooddiary.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme

@Composable
fun ProfileFullScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier,
        topBar = { ProfileNavigation(
            modifier = Modifier.statusBarsPadding()
        ) },
        content = { padding ->
            ProfileScreen(modifier = Modifier.padding(padding))
        },
        bottomBar = {
            ProfileBottomBar(modifier = Modifier.navigationBarsPadding())
        }
    )
}

@Preview
@Composable
fun ProfileFullScreenPreview(modifier: Modifier = Modifier) {
    FoodDiaryTheme {
        ProfileFullScreen()
    }
}
