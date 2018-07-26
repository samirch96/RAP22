package com.example.sam.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Catg4LsActivity extends ScoreCard {
    Button l1,l2,l3,l4;
    TextView a1;
    static int  a,Ls_id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);


        l1=(Button)findViewById(R.id.lv1);
        l2=(Button)findViewById(R.id.lv2);
        l3=(Button)findViewById(R.id.lv3);
        l4=(Button)findViewById(R.id.lv4);

        a1=(TextView)findViewById(R.id.txt_points);
        SharedPreferences sharedPreferences1 = getSharedPreferences("xx", Context.MODE_PRIVATE);
        a1.setText("" + sharedPreferences1.getInt("pt_c", 0));
        a = sharedPreferences1.getInt("pt_c",0);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ls_id=11;
                Intent i1 = new Intent(Catg4LsActivity.this, Catg4Ls1Activity.class);
                startActivity(i1);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a>120){
                    Ls_id=12;
                    Intent i2 = new Intent(Catg4LsActivity.this, Catg4Ls2Activity.class);
                    startActivity(i2);
                }else {
                    Toast.makeText(getApplicationContext(),"you don't have enough points", Toast.LENGTH_LONG).show();
                }
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a>280){
                    Ls_id=13;
                    Intent i3 = new Intent(Catg4LsActivity.this, Catg4Ls3Activity.class);
                    startActivity(i3);
                }else {
                    Toast.makeText(getApplicationContext(),"you don't have enough points", Toast.LENGTH_LONG).show();
                }
            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a>480){
                    //Intent i4 = new Intent(Catg4LsActivity.this, Catg1Ls4Activity.class);
                    //startActivity(i4);
                }else {
                    Toast.makeText(getApplicationContext(),"you don't have enough points", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
