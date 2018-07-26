package com.example.sam.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreCard extends AppCompatActivity {
    TextView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences sharedPreferences = getSharedPreferences("xx", Context.MODE_PRIVATE);
        a1 = (TextView) findViewById(R.id.computer);
        a2 = (TextView) findViewById(R.id.sports);
        a3 = (TextView) findViewById(R.id.inventions);
        a4 = (TextView) findViewById(R.id.general);
        a5 = (TextView) findViewById(R.id.science);
        a6 = (TextView) findViewById(R.id.english);
        a7 = (TextView) findViewById(R.id.books);
        a8 = (TextView) findViewById(R.id.maths);

        a10 =(TextView) findViewById(R.id.currency);
        try {
            a1.setText("" + sharedPreferences.getInt("pt_a", 0));
            a2.setText("" + sharedPreferences.getInt("pt_m", 0));
            a3.setText("" + sharedPreferences.getInt("pt_i", 0));
            a4.setText("" + sharedPreferences.getInt("pt_c", 0));
            a5.setText("" + sharedPreferences.getInt("pt_e", 0));
            a6.setText("" + sharedPreferences.getInt("pt_s", 0));
            a7.setText("" + sharedPreferences.getInt("pt_b", 0));
            a8.setText("" + sharedPreferences.getInt("pt_f", 0));

            a10.setText("" + sharedPreferences.getInt("Currency", 0));
        } catch (Exception e) {
            Toast.makeText(ScoreCard.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

}
