package com.robotbot.fooddiary.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.robotbot.fooddiary.data.models.User

@Deprecated("This class is currently unused but might be needed for Room database integration later.")
@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserProfile(id: Int = 1): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProfile(userProfile: User)

}