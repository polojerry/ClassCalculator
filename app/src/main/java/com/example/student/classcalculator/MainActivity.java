package com.example.student.classcalculator;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputEditText inpuA;
    TextInputEditText inpuB;
    TextInputEditText inpuC;
    TextInputEditText inpuD;
    TextInputEditText inpuE;

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

        inpuA = (TextInputEditText) findViewById(R.id.input_a);
        inpuB = (TextInputEditText) findViewById(R.id.input_b);
        inpuC = (TextInputEditText) findViewById(R.id.input_c);
        inpuD = (TextInputEditText) findViewById(R.id.input_d);
        inpuE = (TextInputEditText) findViewById(R.id.input_e);

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
        }

    }

    private void getData() {
        if (inpuA.length() != 0){
            As = Double.valueOf(inpuA.getText().toString());
        }
        if (inpuB.length() != 0){
            Bs = Double.valueOf(inpuB.getText().toString());
        }
        if (inpuC.length() != 0){
            Cs = Double.valueOf(inpuC.getText().toString());
        }
        if (inpuD.length() != 0){
            Ds = Double.valueOf(inpuD.getText().toString());
        }if (inpuC.length() != 0){
            Es = Double.valueOf(inpuE.getText().toString());
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
