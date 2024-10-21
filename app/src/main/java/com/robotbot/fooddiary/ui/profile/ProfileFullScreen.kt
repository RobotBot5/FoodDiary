package com.robotbot.fooddiary.ui.profile

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.robotbot.fooddiary.ui.list.ListScreen
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme
import com.robotbot.fooddiary.ui.viewmodel.UserViewModel

@Composable
fun ProfileFullScreen(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel = viewModel()
) {

    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val user by userViewModel.user.collectAsState()

    if (user == null) {
        ProfileCreateUser(userViewModel)
    }
    else {
        Scaffold(modifier = modifier,
            topBar = { ProfileNavigation(
                modifier = Modifier.statusBarsPadding(),
                onNavigateToProfile = { selectedIndex = 0 },
                onNavigateToAnalytics = { selectedIndex = 1 },
                onNavigateToList = { selectedIndex = 2 },
                selectedIndex = selectedIndex
            ) },
            content = { padding ->
                when (selectedIndex) {
                    0 -> ProfileScreen(
                        userViewModel = userViewModel,
                        modifier = Modifier.padding(padding)
                    )
                    2 -> ListScreen(modifier = Modifier.padding(padding))
                }
            },
            bottomBar = {
                ProfileBottomBar(modifier = Modifier.navigationBarsPadding())
            }
        )
    }
}

@Preview
@Composable
fun ProfileFullScreenPreview(modifier: Modifier = Modifier) {
    FoodDiaryTheme {
        ProfileFullScreen()
    }
}
