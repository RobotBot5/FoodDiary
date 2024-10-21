package com.robotbot.fooddiary.data.database;

import androidx.room.TypeConverter
import com.robotbot.fooddiary.data.models.Activity

@Deprecated("This class is currently unused but might be needed for Room database integration later.")
class ActivityTypeConverter {

    @TypeConverter
    fun fromActivity(activity: Activity): String {
        return activity.name
    }

    @TypeConverter
    fun toActivity(activityString: String): Activity {
        return Activity.valueOf(activityString)
    }

}
