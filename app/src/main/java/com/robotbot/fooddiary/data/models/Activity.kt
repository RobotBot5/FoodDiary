package com.robotbot.fooddiary.data.models

import androidx.annotation.StringRes
import com.robotbot.fooddiary.R

enum class Activity(@StringRes val labelResId: Int) {
    Sedentary(R.string.activity_sedentary),
    Light(R.string.activity_light),
    Moderate(R.string.activity_moderate),
    Active(R.string.activity_active),
    VeryActive(R.string.activity_very_active),
    ExtraActive(R.string.activity_extra_active);

    companion object {
        val allActivities: List<Activity> = entries
    }

    fun getFormattedLabel(): Int {
        return labelResId
    }
}