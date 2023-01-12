package com.sharif.quizofkings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private EditText name;
    private EditText phoneNumber;
    private EditText username;
    private Button apply;
    private Database db;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        db = Database.getInstance(this);
        LoggedInUser logged = db.LoggedInUserDao().user();
        user = db.UserDao().getUser(logged.getEmail());
        findViews();
        setInitialValues();
        configureApply();
    }

    private void configureApply() {
        apply.setOnClickListener(view -> {
            user.setName(name.getText().toString());
            user.setPhoneNumber(phoneNumber.getText().toString());
            user.setUsername(username.getText().toString());
            db.UserDao().update(user);
            Toast.makeText(this, "Profile Updated!", Toast.LENGTH_LONG).show();
        });
    }

    private void setInitialValues() {
        name.setText(user.getName());
        phoneNumber.setText(user.getPhoneNumber());
        username.setText(user.getUsername());
    }

    private void findViews() {
        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phone_number);
        username = findViewById(R.id.username);
        apply = findViewById(R.id.apply_profile);
    }
}