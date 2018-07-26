package com.example.sam.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CatgCardViewActivity extends AppCompatActivity {

    CardView catg1,catg2,catg3,catg4,catg5,catg6,catg7,catg8,catg_random;
    static int Catg_id;
    Button btn_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catg_card_view);

        catg1 = (CardView)findViewById(R.id.bankcardId1);
        catg2 = (CardView)findViewById(R.id.bankcardId2);
        catg3 = (CardView)findViewById(R.id.bankcardId3);
        catg4 = (CardView)findViewById(R.id.bankcardId4);
        catg5 = (CardView)findViewById(R.id.bankcardId5);
        catg6 = (CardView)findViewById(R.id.bankcardId6);
        catg7 = (CardView)findViewById(R.id.bankcardId7);
        catg8 = (CardView)findViewById(R.id.bankcardId8);
        catg_random = (CardView)findViewById(R.id.bankcardId9);

        btn_help = (Button)findViewById(R.id.btn_help);

        catg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catg_id=1;
                Intent i = new Intent(CatgCardViewActivity.this,Catg1LsActivity.class);
                startActivity(i);
            }
        });

        catg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catg_id=2;
                Intent i = new Intent(CatgCardViewActivity.this,Catg2LsActivity.class);
                startActivity(i);
            }
        });

        catg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catg_id=3;
                Intent i = new Intent(CatgCardViewActivity.this,Catg3LsActivity.class);
                startActivity(i);
            }
        });

        catg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catg_id=4;
                Intent i = new Intent(CatgCardViewActivity.this,Catg4LsActivity.class);
                startActivity(i);
            }
        });

        catg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catg_id=5;
                Intent i = new Intent(CatgCardViewActivity.this,Catg5LsActivity.class);
                startActivity(i);
            }
        });

        catg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catg_id=6;
                Intent i = new Intent(CatgCardViewActivity.this,Catg6LsActivity.class);
                startActivity(i);
            }
        });

        catg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catg_id=7;
                Intent i = new Intent(CatgCardViewActivity.this,Catg7LsActivity.class);
                startActivity(i);
            }
        });

        catg8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catg_id=8;
                Intent i = new Intent(CatgCardViewActivity.this,Catg8LsActivity.class);
                startActivity(i);
            }
        });

        catg_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CatgCardViewActivity.this,RandomActivity.class);
                startActivity(i);
            }
        });

        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast_help = new Toast(getApplicationContext());
                toast_help.setGravity(Gravity.CENTER, 0, 0);
                toast_help.setDuration(Toast.LENGTH_LONG);
                LayoutInflater inflater = getLayoutInflater();
                View appear = inflater.inflate(R.layout.toast_help, (ViewGroup) findViewById(R.id.linear));
                toast_help.setView(appear);
                toast_help.show();
            }
        });
    }


}
