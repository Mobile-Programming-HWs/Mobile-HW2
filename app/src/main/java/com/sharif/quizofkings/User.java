package com.sharif.quizofkings;


import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @NonNull
    private String email;

    @NonNull
    private String password;

    private int numberOfQuestions = 10;
    private String difficulty = "easy";
    private int category = 25;
    private boolean darkMode = false;
    private String name;
    private String phoneNumber;
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(@NonNull String email, @NonNull String password) {
        this.email = email;
        this.password = password;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean getDarkMode() {
        return darkMode;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    @SuppressLint("DefaultLocale")
    public String getAPIQuery() {
        return String.format("https://opentdb.com/api.php?amount=%d&category=%d&difficulty=%s&type=multiple",
                numberOfQuestions, category, difficulty);
    }
}
