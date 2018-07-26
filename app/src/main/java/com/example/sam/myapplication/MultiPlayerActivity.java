package com.example.sam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MultiPlayerActivity extends AppCompatActivity {
   Button a;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
        tv = (TextView)findViewById(R.id.txt_name);
        a= (Button)findViewById(R.id.button3) ;
        Intent intent = getIntent();
        tv.setText(intent.getStringExtra("name"));


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i = getPackageManager().getLaunchIntentForPackage("com.faresimtiez.deeplife.real_time_chat");
                startActivity(i);
            }
        });
    }
}
