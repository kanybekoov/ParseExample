package com.example.parseexample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        TextView titleInfo = findViewById(R.id.title_infoView);
        TextView descriptionInfo = findViewById(R.id.description_infoView);

        String titleInformation = "Title not set";
        String descriptionInformation = "Description not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            titleInformation = extras.getString("title");
            descriptionInformation = extras.getString("body");
        }
        titleInfo.setText(titleInformation);
        descriptionInfo.setText(descriptionInformation);
    }
}
