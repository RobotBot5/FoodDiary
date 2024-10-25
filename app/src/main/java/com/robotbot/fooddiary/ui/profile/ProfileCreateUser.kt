package com.robotbot.fooddiary.ui.profile

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.data.models.Activity
import com.robotbot.fooddiary.data.models.Gender
import com.robotbot.fooddiary.data.models.User
import com.robotbot.fooddiary.ui.theme.FoodDiaryTheme
import com.robotbot.fooddiary.ui.viewmodel.UserViewModel

@Composable
fun ProfileCreateUser(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    val userPrinting by userViewModel.userPrinting.collectAsState()
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .statusBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.PersonPin,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = stringResource(R.string.profile_registration),
                style = MaterialTheme.typography.titleLarge
            )
            TextField(
                value = userPrinting.name,
                onValueChange = { userViewModel.updateName(it) },
                label = { Text(stringResource(R.string.profile_name)) }
            )
            TextField(
                value = if (userPrinting.height == 0) "" else userPrinting.height.toString(),
                onValueChange = { userViewModel.updateHeight(it) },
                label = { Text(stringResource(R.string.profile_height)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = if (userPrinting.weight == 0) "" else userPrinting.weight.toString(),
                onValueChange = { userViewModel.updateWeight(it) },
                label = { Text(stringResource(R.string.profile_weight)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = if (userPrinting.age == 0) "" else userPrinting.age.toString(),
                onValueChange = { userViewModel.updateAge(it) },
                label = { Text(stringResource(R.string.profile_age)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.extraSmall,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .defaultMinSize(minWidth = TextFieldDefaults.MinWidth)
                        .padding(5.dp)
                ) {
                    Text(
                        text = stringResource(R.string.profile_gender)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    RadioButton(
                        selected = userPrinting.gender == Gender.Male,
                        onClick = { userViewModel.updateGender(Gender.Male) }
                    )
                    Text(text = stringResource(Gender.Male.getFormattedLabel()))
                    RadioButton(
                        selected = userPrinting.gender == Gender.Female,
                        onClick = { userViewModel.updateGender(Gender.Female) }
                    )
                    Text(text = stringResource(Gender.Female.getFormattedLabel()))
                }
            }

            Surface(color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.extraSmall,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text =  stringResource(R.string.profile_activity),
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.wrapContentWidth()
                    ) {
                        items(Activity.allActivities) { activity ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = userPrinting.activity == activity,
                                    onClick = { userViewModel.updateActivity(activity) }
                                )
                                Text(text = stringResource(activity.getFormattedLabel()))
                            }
                        }
                    }
                }
            }

            Button(
                onClick = { userViewModel.saveUser() },
                Modifier.width(150.dp)
            ) {
                Text(text = "Save")
            }
        }
    }

}

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun ProfileCreateUserPreviewNight() {
    FoodDiaryTheme {
        ProfileCreateUser(viewModel())
    }
}

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ProfileCreateUserPreviewLight() {
    FoodDiaryTheme {
        ProfileCreateUser(viewModel())
    }
}