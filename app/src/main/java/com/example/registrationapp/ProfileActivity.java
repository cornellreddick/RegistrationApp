package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView profileName, profileEmail, profileId, profileDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        profileName = findViewById(R.id.profileTextViewName);
        profileEmail = findViewById(R.id.profileTextViewEmail);
        profileId = findViewById(R.id.profileTextViewId);
        profileDept = findViewById(R.id.profileTextViewDept);

        if (getIntent() !=null && getIntent().getExtras() !=null && getIntent().hasExtra(RegistrationActivity.PROFILE)){
            Profile profile = (Profile) getIntent().getSerializableExtra(RegistrationActivity.PROFILE);
            profileName.setText(profile.name);
            profileEmail.setText(profile.email);
            profileId.setText(profile.id);
            profileDept.setText(profile.dept);
        }

    }
}