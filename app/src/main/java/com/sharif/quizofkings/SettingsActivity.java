package com.sharif.quizofkings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingsActivity extends AppCompatActivity {

    private SwitchMaterial switchMaterial;
    private Spinner category;
    private Spinner difficulty;
    private Spinner num;
    private Button apply;
    private final String[] categories = {"Art", "Animals", "Vehicles", "Celebrities", "Sports"};
    private final String[] difficulties = {"Easy", "Medium", "Hard"};
    private final String[] numQuestions = {"10", "7", "5"};
    private int selectedCat = 25;
    private String selectedDif = "easy";
    private int selectedNum = 10;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        db = Database.getInstance(this);
        findViews();
        switchMaterial.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
        configureCategory();
        configureDifficulty();
        configureNum();
        configureApply();
    }

    private void configureApply() {
        apply.setOnClickListener(view -> {
            LoggedInUser logged = db.LoggedInUserDao().user();
            User user = db.UserDao().getUser(logged.getEmail());
            user.setCategory(selectedCat);
            user.setDifficulty(selectedDif);
            user.setNumberOfQuestions(selectedNum);
            db.UserDao().update(user);
            Toast.makeText(this, "Settings Applied!", Toast.LENGTH_LONG).show();
        });
    }

    private void configureNum() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, numQuestions);
        num.setAdapter(adapter);
        num.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    selectedNum = 10;
                } else if (i == 1) {
                    selectedNum = 7;
                } else if (i == 2) {
                    selectedNum = 5;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void configureDifficulty() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, difficulties);
        difficulty.setAdapter(adapter);
        difficulty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    selectedDif = "easy";
                } else if (i == 1) {
                    selectedDif = "medium";
                } else if (i == 2) {
                    selectedDif = "hard";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void configureCategory() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        category.setAdapter(adapter);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    selectedCat = 25;
                } else if (i == 1) {
                    selectedCat = 27;
                } else if (i == 2) {
                    selectedCat = 28;
                } else if (i == 3) {
                    selectedCat = 26;
                } else if (i == 4) {
                    selectedCat = 21;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void findViews() {
        switchMaterial = findViewById(R.id.dark_mode);
        category = findViewById(R.id.category);
        difficulty = findViewById(R.id.difficulty);
        num = findViewById(R.id.number_of_questions);
        apply = findViewById(R.id.apply_settings);
    }
}