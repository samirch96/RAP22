package com.example.sam.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PSSActivity extends AppCompatActivity {
    Button btn_play,btn_settings,btn_score,btn_share,btn_about,btn_feedback,btn_exit,btn_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pss);

        btn_play     = (Button)findViewById(R.id.btn_play);
        btn_settings = (Button)findViewById(R.id.btn_settings);
        btn_score    = (Button)findViewById(R.id.btn_score);
        btn_share    = (Button)findViewById(R.id.btn_share);

        btn_exit     = (Button)findViewById(R.id.btn_exit);


        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PSSActivity.this,CatgCardViewActivity.class);
                startActivity(i);
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PSSActivity.this,Setting_activity.class);
                startActivity(i);
            }
        });

        btn_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PSSActivity.this,ScoreCard.class);
                startActivity(i);
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setData(Uri.parse("Voicy:"));
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Voicy");
                System.out.println(""+R.string.email_content);
                intent.putExtra(Intent.EXTRA_TEXT, ""+getText(R.string.email_content)+getText(R.string.link)+getText(R.string.last_content));
                Intent chooser = Intent.createChooser(intent, "Share using");
                startActivity(chooser);
            }
        });


       /* btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("Voicy:"));
                String[] recipents = {"fares.imtiez@gmail.com"};
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, recipents);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Voicy");
                Intent chooser = Intent.createChooser(intent, "Send Feedback Via");
                startActivity(chooser);
            }
        });*/

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
