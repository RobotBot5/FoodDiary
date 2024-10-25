package com.robotbot.fooddiary.data.models

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.robotbot.fooddiary.R

enum class Gender(@StringRes val labelResId: Int) {
    Male(R.string.gender_male),
    Female(R.string.gender_female);

    fun getFormattedLabel(): Int {
        return labelResId
    }
}