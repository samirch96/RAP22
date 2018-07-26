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

public class CardActivity extends CatgCardViewActivity {
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
        tv.setText(""+sharedPreferences1.getInt("points", 0));
        nn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CardActivity.this, Catg1LsActivity.class);
                startActivity(i);
                /*switch (Catg_id)
                {
                    case 1:
                        Intent i1 = new Intent(CardActivity.this, Catg1LsActivity.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(CardActivity.this, Catg2LsActivity.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(CardActivity.this, Catg3LsActivity.class);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(CardActivity.this, Catg4LsActivity.class);
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(CardActivity.this, Catg5LsActivity.class);
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(CardActivity.this, Catg6LsActivity.class);
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(CardActivity.this, Catg7LsActivity.class);
                        startActivity(i7);
                        break;
                    case 8:
                        Intent i8 = new Intent(CardActivity.this, Catg8LsActivity.class);
                        startActivity(i8);
                        break;
                    default:break;
                }*/

            }
        });
        aagd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CardActivity.this, Catg1LsActivity.class);
                startActivity(i);
                /*switch (Catg_id)
                {
                    case 1:
                        Intent i1 = new Intent(CardActivity.this, Catg1LsActivity.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(CardActivity.this, Catg2LsActivity.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(CardActivity.this, Catg3LsActivity.class);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(CardActivity.this, Catg4LsActivity.class);
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(CardActivity.this, Catg5LsActivity.class);
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(CardActivity.this, Catg6LsActivity.class);
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(CardActivity.this, Catg7LsActivity.class);
                        startActivity(i7);
                        break;
                    case 8:
                        Intent i8 = new Intent(CardActivity.this, Catg8LsActivity.class);
                        startActivity(i8);
                        break;
                    default:break;
                }*/

            }
        });


        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CardActivity.this, ShaireScoreActivity.class);
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
