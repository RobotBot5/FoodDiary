package com.robotbot.fooddiary.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.robotbot.fooddiary.R
import com.robotbot.fooddiary.data.models.Activity
import com.robotbot.fooddiary.data.models.Gender
import com.robotbot.fooddiary.data.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserViewModel : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _userPrinting = MutableStateFlow(
        User(
            name = "",
            height = 0,
            weight = 0,
            gender = Gender.Male,
            age = 0,
            activity = Activity.Moderate
        )
    )
    val userPrinting = _userPrinting.asStateFlow()

    var errorMessage by mutableIntStateOf(0)
        private set

    fun saveUser() {
        if (_userPrinting.value.name == "") {
            errorMessage = R.string.error_create_user_name
            return
        }
        if (_userPrinting.value.height < 50) {
            errorMessage = R.string.error_create_user_height
            return
        }
        if (_userPrinting.value.weight < 20) {
            errorMessage = R.string.error_create_user_weight
            return
        }
        if (_userPrinting.value.age < 1) {
            errorMessage = R.string.error_create_user_age
            return
        }
        _user.value = _userPrinting.value
    }

    internal fun initializeMockUser(mockUser: User) {
        _user.value = mockUser
    }

    fun updateName(newName: String) {
        if (newName.all { it.isLetter() } && newName.isNotBlank()) {
            _userPrinting.value = _userPrinting.value.copy(name = newName)
        }
    }

    fun updateHeight(newHeight: String) {
        val height = newHeight.toIntOrNull() ?: 0
        if (height in 0..250) {
            _userPrinting.value = _userPrinting.value.copy(height = height)
        }
    }
    fun updateWeight(newWeight: String) {
        val weight = newWeight.toIntOrNull() ?: 0
        if (weight in 0..300) {
            _userPrinting.value = _userPrinting.value.copy(weight = weight)
        }
    }
    fun updateAge(newAge: String) {
        val age = newAge.toIntOrNull() ?: 0
        if (age in 0..120) {
            _userPrinting.value = _userPrinting.value.copy(age = age)
        }
    }
    fun updateGender(newGender: Gender) {
        _userPrinting.value = _userPrinting.value.copy(gender = newGender)
    }
    fun updateActivity(newActivity: Activity) {
        _userPrinting.value = _userPrinting.value.copy(activity = newActivity)
    }

}