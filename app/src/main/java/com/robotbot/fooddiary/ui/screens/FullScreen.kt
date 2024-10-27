package com.robotbot.fooddiary.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TabletMac
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.data.models.Activity
import com.robotbot.fooddiary.data.models.Gender
import com.robotbot.fooddiary.data.models.User
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme
import com.robotbot.fooddiary.ui.viewmodel.UserViewModel
import com.robotbot.fooddiary.ui.viewmodel.UserViewModelFactory

@Composable
fun FullScreen(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel = viewModel()
) {

    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val user by userViewModel.user.collectAsState()

    if (user == null) {
        CreateUserScreen(userViewModel)
    }
    else {
        Scaffold(modifier = modifier,
            topBar = { TopAppBar(
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
                    2 -> DiaryScreen(modifier = Modifier.padding(padding))
                }
            },
            bottomBar = {
                BottomBar(modifier = Modifier.navigationBarsPadding())
            }
        )
    }
}

@Composable
private fun TopAppBar(
    modifier: Modifier = Modifier,
    onNavigateToProfile: () -> Unit,
    onNavigateToAnalytics: () -> Unit,
    onNavigateToList: () -> Unit,
    selectedIndex: Int
) {
    Surface(color = MaterialTheme.colorScheme.surfaceContainer) {
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
                    .background(color = MaterialTheme.colorScheme.onSurface)
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

@Composable
private fun BottomBar(modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.surfaceContainer) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Icon(
                    painter = painterResource(R.drawable.github_mark),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text("RobotBot5")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text("robotbotyourube@gmail.com")
            }
        }
    }
}

@Preview
@Composable
private fun ProfileBottomBarPreview() {
    FoodDiaryTheme {
        BottomBar()
    }
}

@Preview(showBackground = true,)
@Composable
fun ProfileNavigationPreview(modifier: Modifier = Modifier) {
    FoodDiaryTheme {
        TopAppBar(
            onNavigateToProfile = {},
            onNavigateToAnalytics = {},
            onNavigateToList = {},
            selectedIndex = 0
        )
    }
}

@Preview
@Composable
fun ProfileFullScreenPreviewRegistration() {
    FoodDiaryTheme {
        FullScreen()
    }
}

@Preview
@Composable
fun ProfileFullScreenPreviewWithUser() {
    val mockUser = User(
        name = "Ilya",
        height = 177,
        weight = 80,
        gender = Gender.Male,
        age = 30,
        activity = Activity.Moderate
    )
    val factory = UserViewModelFactory(mockUser)
    val viewModel: UserViewModel = viewModel(factory = factory)

    FoodDiaryTheme {
        FullScreen(userViewModel = viewModel)
    }
}
