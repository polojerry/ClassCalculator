package com.example.student.classcalculator;

import android.content.Intent;
import androidx.core.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    ImageView classImage;
    TextView classText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        classImage = (ImageView) findViewById(R.id.image_class);
        classText= (TextView) findViewById(R.id.class_text);

        getSupportActionBar();

        Intent intent = getIntent();
        String resultClass = intent.getStringExtra("class");
        classText.setText(resultClass);

    }
}
