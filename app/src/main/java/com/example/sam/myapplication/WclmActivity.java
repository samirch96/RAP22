package com.example.sam.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class WclmActivity extends AppCompatActivity {

    LinearLayout l1,l2;
    Button btn1,btn2;
    Animation uptodown,d;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wclm);

       /* mediaPlayer = MediaPlayer.create(this, R.raw.abc);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);*/

        l2=(LinearLayout)findViewById(R.id.l2);
        btn1=(Button)findViewById(R.id.stt);
        btn2=(Button)findViewById(R.id.tts);



        l2.setAnimation(d);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(WclmActivity.this, MainActivity.class);
                startActivity(a);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i = getPackageManager().getLaunchIntentForPackage("com.faresimtiez.deeplife.real_time_chat");
                startActivity(i);
            }
        });
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }*/
}
