package com.robotbot.fooddiary.data.database

import androidx.room.TypeConverter
import com.robotbot.fooddiary.data.models.Gender

@Deprecated("This class is currently unused but might be needed for Room database integration later.")
class GenderTypeConverter {

    @TypeConverter
    fun fromGender(gender: Gender): String {
        return gender.name
    }

    @TypeConverter
    fun toGender(genderString: String): Gender {
        return Gender.valueOf(genderString)
    }
}