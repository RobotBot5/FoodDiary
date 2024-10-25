package com.robotbot.fooddiary.ui.viewmodel

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.robotbot.fooddiary.data.models.User

class UserViewModelFactory(private val mockUser: User? = null) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel().apply {
            if (mockUser != null) {
                initializeMockUser(mockUser)
            }
        } as T
    }
}