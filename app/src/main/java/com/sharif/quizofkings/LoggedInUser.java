package com.sharif.quizofkings;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "logged_in_user")
public class LoggedInUser {

    @PrimaryKey
    @NonNull
    private String email;

    public LoggedInUser(@NonNull String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
