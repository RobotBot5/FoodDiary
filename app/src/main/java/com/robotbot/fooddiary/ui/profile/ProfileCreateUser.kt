package com.robotbot.fooddiary.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.data.models.Activity
import com.robotbot.fooddiary.data.models.Gender
import com.robotbot.fooddiary.data.models.User
import com.robotbot.fooddiary.ui.viewmodel.UserViewModel

@Composable
fun ProfileCreateUser(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf(Gender.Male) }
    var activity by remember { mutableStateOf(Activity.Moderate) }

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TextField(
            value = stringResource(R.string.profile_name),
            onValueChange = { name = it },
            label = { Text(stringResource(R.string.profile_name)) }
        )
        TextField(
            value = stringResource(R.string.profile_height),
            onValueChange = { height = it },
            label = { Text(stringResource(R.string.profile_height)) }
        )
        TextField(
            value = stringResource(R.string.profile_weight),
            onValueChange = { weight = it },
            label = { Text(stringResource(R.string.profile_weight)) }
        )
        TextField(
            value = stringResource(R.string.profile_age),
            onValueChange = { age = it },
            label = { Text(stringResource(R.string.profile_age)) }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = stringResource(R.string.profile_gender))
            RadioButton(
                selected = true,
                onClick = { gender = Gender.Male }
            )
            Text(text = Gender.Male.name)
            RadioButton(
                selected = false,
                onClick = { gender = Gender.Female }
            )
            Text(text = Gender.Female.name)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = stringResource(R.string.profile_activity))
            RadioButton(
                selected = true,
                onClick = { activity = Activity.Sedentary }
            )
            Text(text = Activity.Sedentary.name)
            RadioButton(
                selected = false,
                onClick = { activity = Activity.Light }
            )
            Text(text = Activity.Light.name)
            RadioButton(
                selected = false,
                onClick = { activity = Activity.Moderate }
            )
            Text(text = Activity.Moderate.name)
            RadioButton(
                selected = false,
                onClick = { activity = Activity.Active }
            )
            Text(text = Activity.Active.name)
            RadioButton(
                selected = false,
                onClick = { activity = Activity.VeryActive }
            )
            Text(text = Activity.VeryActive.name)
            RadioButton(
                selected = false,
                onClick = { activity = Activity.ExtraActive }
            )
            Text(text = Activity.ExtraActive.name)
        }

        Button(onClick = {
            val userHeight = height.toIntOrNull() ?: 0
            val userWeight = weight.toIntOrNull() ?: 0
            val userAge = age.toIntOrNull() ?: 0

            userViewModel.saveUser(
                User(
                    name = name,
                    height = userHeight,
                    weight = userWeight,
                    age = userAge,
                    gender = gender,
                    activity = activity
                )
            )
        }) {
            Text(text = "Save")
        }
    }
}