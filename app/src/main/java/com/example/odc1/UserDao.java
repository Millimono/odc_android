package com.example.odc1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("SELECT EXISTS(SELECT * FROM user_table WHERE username = :username AND password = :password)")
    boolean checkUser(String username, String password);
}

