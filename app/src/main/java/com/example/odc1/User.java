package com.example.odc1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String username;
    public String password;

    // Constructeur avec id, username, et password
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

}

