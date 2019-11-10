package com.example.student.classcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    ImageView classImage;
    TextView classText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        classImage = findViewById(R.id.image_class);
        classText= findViewById(R.id.class_text);

        getSupportActionBar();

        Intent intent = getIntent();
        String resultClass = intent.getStringExtra(MainActivity.CLASS);
        classText.setText(resultClass);

    }
}
