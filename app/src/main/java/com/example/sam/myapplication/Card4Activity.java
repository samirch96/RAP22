package com.example.sam.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Card4Activity extends AppCompatActivity {
    Dialog myDialog;
    Button nn,aagd,ff;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        myDialog=new Dialog(this);
        nn=(Button)findViewById(R.id.nn);
        aagd=(Button)findViewById(R.id.aagd);
        tv = (TextView)findViewById(R.id.sc);
        ff=(Button)findViewById(R.id.ff);
        SharedPreferences sharedPreferences1 = getSharedPreferences("xx", Context.MODE_PRIVATE);
        tv.setText(""+sharedPreferences1.getInt("pt_c", 0));
        nn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Card4Activity.this, Catg4LsActivity.class);
                startActivity(i);
            }
        });
        aagd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Card4Activity.this, Catg4LsActivity.class);
                startActivity(i);
            }
        });


        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Card4Activity.this, ShaireScoreActivity.class);
                startActivity(i);
            }
        });
    }

    public void ShowPopup(View v){
        TextView teclose;
        Button score;

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
