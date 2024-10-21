package com.robotbot.fooddiary.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters

import com.robotbot.fooddiary.data.models.User;

@Deprecated("This class is currently unused but might be needed for Room database integration later.")
@Database(entities = [User::class], version = 1)
@TypeConverters(GenderTypeConverter::class, ActivityTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}