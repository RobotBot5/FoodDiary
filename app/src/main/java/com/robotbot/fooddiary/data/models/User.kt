package com.robotbot.fooddiary.data.models


data class User(
    val id: Int = 1,
    val name: String,
    val height: Int,
    val weight: Int,
    val gender: Gender,
    val age: Int,
    val activity: Activity,

)