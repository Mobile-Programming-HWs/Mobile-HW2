package com.sharif.quizofkings;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(User user);

    @Update
    int update(User user);

    @Query("SELECT * FROM users")
    LiveData<List<User>> getUsers();

    @Query("SELECT * FROM users WHERE email = :email")
    User getUser(String email);
}
