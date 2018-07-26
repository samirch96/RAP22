package com.example.sam.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TTSActivity extends CatgCardViewActivity  implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private Button btn,bb;
    private EditText txt;

    SharedPreferences x;
    SharedPreferences.Editor xx;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        tts=new TextToSpeech(this,this);
        btn=(Button)findViewById(R.id.button);
        bb=(Button)findViewById(R.id.button1);
        txt=(EditText)findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (Catg_id){
                    case 1 :
                        x = getSharedPreferences("xx", 0);
                        int a1 = x.getInt("pt_a",0);
                        xx = x.edit();
                        xx.putInt("pt_a", a1-20);
                        xx.apply();
                        break;

                    case 2:

                        int a2 = x.getInt("pt_m",0);
                        x = getSharedPreferences("xx", 0);
                        xx = x.edit();
                        xx.putInt("pt_m", a2-20);
                        xx.apply();
                        break;

                    case 3:
                        int a3 = x.getInt("pt_i",0);
                        x = getSharedPreferences("xx", 0);
                        xx = x.edit();
                        xx.putInt("pt_i", a3-20);
                        xx.apply();
                        break;

                    case 4:

                        x = getSharedPreferences("xx", 0);
                        int a4 = x.getInt("pt_c",0);
                        xx = x.edit();
                        xx.putInt("pt_c", a4-20);
                        xx.apply();
                        break;

                    case 5:
                        int a5 = x.getInt("pt_e",0);
                        x = getSharedPreferences("xx", 0);
                        xx = x.edit();
                        xx.putInt("pt_e", a5-20);
                        xx.apply();
                        break;

                    case 6:

                        x = getSharedPreferences("xx", 0);
                        int a6 = x.getInt("pt_s",0);
                        xx = x.edit();
                        xx.putInt("pt_s", a6-20);
                        xx.apply();
                        break;

                    case 7:
                        int a7 = x.getInt("pt_b",0);
                        x = getSharedPreferences("xx", 0);
                        xx = x.edit();
                        xx.putInt("pt_b", a7-20);
                        xx.apply();
                        break;

                    case 8:

                        x = getSharedPreferences("xx", 0);
                        int a8 = x.getInt("pt_f",0);
                        xx = x.edit();
                        xx.putInt("pt_f", a8-20);
                        xx.apply();
                        break;
                }

                speak();
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @Override
    public void onInit(int i) {
        if (i==TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.ENGLISH);
            if (result==TextToSpeech.LANG_NOT_SUPPORTED || result== TextToSpeech.LANG_MISSING_DATA){
                Log.e("TTS","anglais svp");
            }else{
                btn.setEnabled(true);
                speak();
            }
        }else{
            Log.e("TTS", "initialization faild");
        }
    }
    private  void speak(){
        String t = txt.getText().toString();
        tts.speak(t,TextToSpeech.QUEUE_FLUSH, null);
    }
}
