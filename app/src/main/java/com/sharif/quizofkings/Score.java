package com.sharif.quizofkings;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scores")
public class Score {
    public void setId(int id) {
        this.id = id;
    }

    public void setUserEmail(@NonNull String userEmail) {
        this.userEmail = userEmail;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String userEmail;

    @NonNull
    private long score = -30;

    public Score(@NonNull String userEmail, long score) {
        this.userEmail = userEmail;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getUserEmail() {
        return userEmail;
    }

    @NonNull
    public long getScore() {
        return score;
    }
}
