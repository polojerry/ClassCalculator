package com.example.student.classcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText inputA;
    TextInputEditText inputB;
    TextInputEditText inputC;
    TextInputEditText inputD;
    TextInputEditText inputE;

    Button calculate;

    double As = 0;
    double Bs = 0;
    double Cs = 0;
    double Ds = 0;
    double Es = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputA = (TextInputEditText) findViewById(R.id.input_a);
        inputB = (TextInputEditText) findViewById(R.id.input_b);
        inputC = (TextInputEditText) findViewById(R.id.input_c);
        inputD = (TextInputEditText) findViewById(R.id.input_d);
        inputE = (TextInputEditText) findViewById(R.id.input_e);

        calculate = (Button) findViewById(R.id.calculate_button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                calculateClass();
            }
        });
    }

    private void calculateClass() {

        Double average = ((calculateBestCase() + calculateAverageCase() +calculateWorstCase()) / 3);

        if (average >= 70){

            Intent openResultActivity= new Intent(MainActivity.this,ResultActivity.class);
            openResultActivity.putExtra("class","FIRST CLASS HONOUR");
            openResultActivity.putExtra("image",R.drawable.first_class);
            startActivity(openResultActivity);

        }else if (average >=60){
            Intent openResultActivity= new Intent(MainActivity.this,ResultActivity.class);
            openResultActivity.putExtra("class","SECOND CLASS UPPER");
            openResultActivity.putExtra("image",R.drawable.second_class);
            startActivity(openResultActivity);

        }else if(average >=50){
            Intent openResultActivity= new Intent(MainActivity.this,ResultActivity.class);
            openResultActivity.putExtra("class","SECOND CLASS LOWER");
            openResultActivity.putExtra("image",R.drawable.second_class);
            startActivity(openResultActivity);

        }else if (average >= 40){
            Intent openResultActivity= new Intent(MainActivity.this,ResultActivity.class);
            openResultActivity.putExtra("class","PASS");
            openResultActivity.putExtra("image",R.drawable.second_class);
            startActivity(openResultActivity);

        }else {
            Toast.makeText(getApplicationContext(), "FAIL",Toast.LENGTH_LONG).show();

            Intent openResultActivity= new Intent(MainActivity.this,ResultActivity.class);
            openResultActivity.putExtra("class","FAIL");
            openResultActivity.putExtra("image",R.drawable.second_class);
            startActivity(openResultActivity);
        }

    }

    private void getData() {

        if (inputA.length() != 0){
            As = Double.valueOf(inputA.getText().toString());
        }else{
            inputA.setText(String.valueOf(0));
            As = (double) 0;
        }
        if (inputB.length() != 0){
            Bs = Double.valueOf(inputB.getText().toString());
        }else{
            Bs = (double) 0;
        }
        if (inputC.length() != 0){
            Cs = Double.valueOf(inputC.getText().toString());
        }else{
            Cs = (double) 0;
        }
        if (inputD.length() != 0){
            Ds = Double.valueOf(inputD.getText().toString());
        }else{
            Ds = (double) 0;
        }if (inputC.length() != 0){
            Es = Double.valueOf(inputE.getText().toString());
        }else{
            Es = (double) 0;
        }

    }

    private double calculateBestCase() {
        double A = As *79;
        double B = Bs *69;
        double C = Cs *59;
        double D = Ds *49;
        double E = Es *39;

        Double total = A+ B+ C+ D+ E;
        Double units = As + Bs +Cs +Ds +Es;

        Double average = total/units;

        return average;
    }

    private double calculateAverageCase() {
        double A = As *75;
        double B = Bs *65;
        double C = Cs *55;
        double D = Ds *45;
        double E = Es *20;

        Double total = A+ B+ C+ D+ E;
        Double units = As + Bs +Cs +Ds +Es;

        Double average = total/units;

        return average;
    }

    private double calculateWorstCase() {
        double A = As *70;
        double B = Bs *60;
        double C = Cs *50;
        double D = Ds *40;
        double E = Es *0;

        Double total = A+ B+ C+ D+ E;
        Double units = As + Bs +Cs +Ds +Es;

        Double average = total/units;

        return average;
    }

}
