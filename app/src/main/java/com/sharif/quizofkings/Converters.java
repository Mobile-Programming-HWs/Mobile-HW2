package com.sharif.quizofkings;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {

    static Gson gson = new Gson();

    @TypeConverter
    public static ArrayList<Question> questionsFromJson(String data) {
        Type type = new TypeToken<ArrayList<Question>>(){}.getType();
        return gson.fromJson(data, type);
    }

    @TypeConverter
    public static String questionsToJson(ArrayList<Question> questions) {
        return gson.toJson(questions);
    }
}
