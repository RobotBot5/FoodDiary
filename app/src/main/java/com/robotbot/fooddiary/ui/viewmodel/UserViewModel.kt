package com.robotbot.fooddiary.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robotbot.fooddiary.data.models.Activity
import com.robotbot.fooddiary.data.models.Gender
import com.robotbot.fooddiary.data.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _userPrinting = MutableStateFlow<User>(
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

    fun saveUser() {
        _user.value = _userPrinting.value
    }

    internal fun initializeMockUser(mockUser: User) {
        _user.value = mockUser
    }

    fun updateName(newName: String) {
        _userPrinting.value = _userPrinting.value.copy(name = newName)
    }

    fun updateHeight(newHeight: String) {
        _userPrinting.value = _userPrinting.value.copy(height = newHeight.toIntOrNull() ?: 0)
    }
    fun updateWeight(newWeight: String) {
        _userPrinting.value = _userPrinting.value.copy(weight = newWeight.toIntOrNull() ?: 0)
    }
    fun updateGender(newGender: Gender) {
        _userPrinting.value = _userPrinting.value.copy(gender = newGender)
    }
    fun updateAge(newAge: String) {
        _userPrinting.value = _userPrinting.value.copy(age = newAge.toIntOrNull() ?: 0)
    }
    fun updateActivity(newActivity: Activity) {
        _userPrinting.value = _userPrinting.value.copy(activity = newActivity)
    }

}