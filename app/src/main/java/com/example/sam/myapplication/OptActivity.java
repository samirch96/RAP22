package com.example.sam.myapplication;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.RecognitionListener;
import edu.cmu.pocketsphinx.SpeechRecognizer;
import edu.cmu.pocketsphinx.SpeechRecognizerSetup;

public class OptActivity extends OptLsActivity implements RecognitionListener {

    TextView result;

    ViewFlipper viewFlipper;


    public String text;


    static int co=0, sc=0, po=0, lang=0;

    SharedPreferences e,x;

    SharedPreferences.Editor ee,xx;

    Button bfr,ben,bes,bl;

    public static final String ANIMALS="animals";
    public static final String MUSIC="music";
    public static final String CUISIN="cuisin";
    public static final String ELECTRO="electro";
    public static final String BUILDING="building";
    public static final String INFO="info";
    public static final String FLAGS="flags";
    public static final String SCHOOL="school";
   // public static final String ANIMAL="animal";
    /* Keyword we are looking for to activate menu */


    /* Used to handle permission request */
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    private SpeechRecognizer recognizer,reco1;
    private HashMap<String, Integer> captions;
    private String categories;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        switch(Ls_id){
            case 0  : setContentView(R.layout.activity_catg1_ls1); break;
            case 1  : setContentView(R.layout.activity_catg1_ls2); break;
            case 2  : setContentView(R.layout.activity_catg1_ls3); break;
            case 3  : setContentView(R.layout.activity_catg1_ls4); break;
            case 4  : setContentView(R.layout.activity_catg2_ls1); break;
            case 5  : setContentView(R.layout.activity_catg2_ls2); break;
            case 6  : setContentView(R.layout.activity_catg2_ls3); break;
            case 7  : setContentView(R.layout.activity_catg3_ls1); break;
            case 8  : setContentView(R.layout.activity_catg3_ls2); break;
            case 9  : setContentView(R.layout.activity_catg3_ls3); break;
            case 10 : setContentView(R.layout.activity_catg4_ls1); break;
            case 11 : setContentView(R.layout.activity_catg4_ls2); break;
            case 12 : setContentView(R.layout.activity_catg4_ls3); break;
            case 13 : setContentView(R.layout.activity_catg5_ls1); break;
            case 14 : setContentView(R.layout.activity_catg5_ls2); break;
            case 15 : setContentView(R.layout.activity_catg5_ls3); break;
            case 16 : setContentView(R.layout.activity_catg6_ls1); break;
            case 17 : setContentView(R.layout.activity_catg7_ls1); break;
            case 18 : setContentView(R.layout.activity_catg7_ls2); break;
            case 19 : setContentView(R.layout.activity_catg8_ls1); break;
            case 20 : setContentView(R.layout.activity_catg8_ls2); break;
            case 21 : setContentView(R.layout.activity_catg8_ls3); break;
            case 22 : setContentView(R.layout.activity_catg8_ls4); break;
            default:break;
        }
        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        bfr=(Button)findViewById(R.id.btn_fr);
        ben=(Button)findViewById(R.id.btn_en);

        bl=(Button)findViewById(R.id.btn_listen);
        result= (TextView)findViewById(R.id.result_text);
        /*bfr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reco1.startListening(ANIMAL);
                switchSearch(ANIMAL);
                bfr.setVisibility(View.INVISIBLE);
                ben.setVisibility(View.INVISIBLE);
                lang=222;
                bes.setVisibility(View.INVISIBLE);
            }
        });*/
        ben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (Catg_id){
                    case 1:
                        recognizer.startListening(ANIMALS);
                        switchSearch(ANIMALS);break;
                    case 2:
                        recognizer.startListening(MUSIC);
                        switchSearch(MUSIC);break;
                    case 3:
                        recognizer.startListening(INFO);
                        switchSearch(INFO);break;
                    case 4:
                        recognizer.startListening(CUISIN);
                        switchSearch(CUISIN);break;
                    case 5:
                        recognizer.startListening(ELECTRO);
                        switchSearch(ELECTRO);break;
                    case 6:
                        recognizer.startListening(SCHOOL);
                        switchSearch(SCHOOL);break;
                    case 7:
                        recognizer.startListening(BUILDING);
                        switchSearch(BUILDING);break;
                    case 8:
                        recognizer.startListening(FLAGS);
                        switchSearch(FLAGS);break;
                    default:break;
                }
                bfr.setVisibility(View.INVISIBLE);ben.setVisibility(View.INVISIBLE);bes.setVisibility(View.INVISIBLE);
                lang=111;

/*                switchSearch(ANIMALS);
               */
            }
        });
        /*bes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recognizer.startListening(ANIMALS);
                switchSearch(ANIMALS);
                bfr.setVisibility(View.INVISIBLE);
                ben.setVisibility(View.INVISIBLE);
                bes.setVisibility(View.INVISIBLE);
            }
        });*/
        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(OptActivity.this);
                a_builder.setMessage("Secrifi 20 points ?").setCancelable(false).setPositiveButton("yes" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        int h = x.getInt("pt_a",0);
                        switch (lang){
                            case 1:
                                Intent i1 = new Intent(OptActivity.this, TTSFRActivity.class);
                                startActivity(i1);
                                break;
                            case 2:
                                Intent i2 = new Intent(OptActivity.this, TTSActivity.class);
                                startActivity(i2);
                                break;
                            default:break;
                        }
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Alert");
                alert.show();
            }
        });

        // Check if user has given permission to record audio
        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
            return;
        }
        // Recognizer initialization is a time-consuming and it involves IO,
        // so we execute it in async task
        new SetupTask(this).execute();
    }



    private static class SetupTask extends AsyncTask<Void, Void, Exception> {
        WeakReference<OptActivity> activityReference;
        SetupTask(OptActivity activity) {
            this.activityReference = new WeakReference<>(activity);
        }
        @Override
        protected Exception doInBackground(Void... params) {
            try {
                Assets assets = new Assets(activityReference.get());
                File assetDir = assets.syncAssets();
                activityReference.get().setupRecognizer(assetDir);
            } catch (IOException e) {
                return e;
            }
            return null;
        }
        @Override
        protected void onPostExecute(Exception result) {

            //  if (result != null) {
            //    ((TextView) activityReference.get().findViewById(R.id.caption_text))
            //          .setText("Failed to init recognizer " + result);

            //}
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSIONS_REQUEST_RECORD_AUDIO) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Recognizer initialization is a time-consuming and it involves IO,
                // so we execute it in async task
                new SetupTask(this).execute();
            } else {
                finish();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (recognizer != null) {
            recognizer.cancel();
            recognizer.shutdown();
        }

        if (reco1 != null) {
            reco1.cancel();
            reco1.shutdown();
        }
    }

    /**
     * In partial result we get quick updates about current hypothesis. In
     * keyword spotting mode we can react here, in other modes we need to wait
     * for final result in onResult.
     */

    @Override
    public void onPartialResult(Hypothesis hypothesis) {
        if (hypothesis == null)
            return;
        text = hypothesis.getHypstr();
        int ps_score = (int) (hypothesis.getBestScore()*-0.005);
        String mat_en[][]={{"cat", "dog","monkey","wolf","cow","bee"},
                           {"bird", "lion","tiger","shark","snake"},
                           {"donkey", "goat","mosquito","lizard","panda"},
                           {"cockroach", "hyena","crocodile","dinosaur","rhinoceros","hippopotamus","silkworm"},
                           {"drum", "flute","gong","guitar","harp"},
                           {"tuba", "violin","harp","saxophone","speaker"},
                           {"oboe", "synthesizer","tambourine","trombone","zither"},
                           {"cd", "monitor","printer","speaker"},
                           {"card", "jack","port","processor"},
                           {"satellite", "keyboard","modem","usb"},
                           {"blender", "cooker","filter","fridge"},
                           {"gloves", "grater","knife","microwaves"},
                           {"mixer", "peeler","skews","strainer"},
                           {"blender", "cleaner" , "dishwasher" , "fridge"},
                           {"microphone","microwaves","mixer","modem"},
                           {"speaker", "tv" , "ventilator" , "washer"},
                           {"bag", "book ","calculator","pen","rule","ruler","scissors","tape"},
                           {"saw", "hoe","boot","trowel"},
                           {"ladder", "hammer"},
                           {"algeria", "america","china","france","mali"},
                           {"iraq", "brazil","italy","libya","sudan"},
                           {"turkey", "mauritania","malaysia","canada"},
                           {"america", "brazil","dubai","france","italy","australia"}};

       if(lang==111){
            switch (Catg_id){
                case 1: switchSearch(ANIMALS);break;
                case 2: switchSearch(MUSIC);break;
                case 3: switchSearch(INFO);break;
                case 4: switchSearch(CUISIN);break;
                case 5: switchSearch(ELECTRO);break;
                case 6: switchSearch(SCHOOL);break;
                case 7: switchSearch(BUILDING);break;
                case 8: switchSearch(FLAGS);break;
                default:break;
            }
            if( hypothesis.getHypstr().equals(mat_en[Ls_id][co])){
                if (ps_score < 4){
                    Toast.makeText(this, "your score is " + ps_score + "/10  try again", Toast.LENGTH_LONG).show();
                }else if (ps_score >= 4 &&ps_score < 6){
                    po = po + 30;
                    sc = sc + 3;
                    viewFlipper.showNext();
                    co++;
                }else if (ps_score >= 6 &&ps_score < 8){
                    po = po + 70;
                    sc = sc + 5;
                    viewFlipper.showNext();
                    co++;
                }else if (ps_score >= 7 &&ps_score < 9){
                    po = po + 120;
                    sc = sc + 9;
                    viewFlipper.showNext();
                    co++;
                }
                if (co == Ls_co){
                    recognizer.stop();
                    recognizer.shutdown();
                    onDestroy();
                    Intent i = new Intent(OptActivity.this, OptLsActivity.class);
                    startActivity(i);
                    Toast.makeText(this, "K.O" , Toast.LENGTH_LONG).show();
                    x = getSharedPreferences(pt,0);
                    xx = x.edit();
                    xx.putInt(pt , po + a);
                    xx.apply();
                }
                Toast.makeText(this, "co =" + co + "//sc="+ sc + "//po =" + po, Toast.LENGTH_LONG).show();
            }
        }



    }
    /**
     * This callback is called when we stop the recognizer.
     */
    @Override
    public void onResult(Hypothesis hypothesis) {

    }

    @Override
    public void onBeginningOfSpeech() {
    }

    /**
     * We stop recognizer here to get a final result
     */
    @Override
    public void onEndOfSpeech() {
        onDestroy();

    }

    private void switchSearch(String searchName) {
        if (lang == 111) {

            recognizer.stop();

            // If we are not spotting, start listening with timeout (10000 ms or 10 seconds).

            if (searchName.equals(ANIMALS))
                recognizer.startListening(searchName);else
            if (searchName.equals(MUSIC))
                recognizer.startListening(searchName);else
            if (searchName.equals(INFO))
                recognizer.startListening(searchName);else
            if (searchName.equals(CUISIN))
                recognizer.startListening(searchName);else
            if (searchName.equals(ELECTRO))
                recognizer.startListening(searchName);
            else
            if (searchName.equals(SCHOOL))
                recognizer.startListening(searchName);else
            if (searchName.equals(BUILDING))
                recognizer.startListening(searchName);else
            if (searchName.equals(FLAGS))
                recognizer.startListening(searchName);else

                recognizer.startListening(searchName, 10000);
        }
        /*if(lang== 1){
            reco1.stop();

            if (searchName.equals(ANIMAL))
                reco1.startListening(searchName);
            else
                reco1.startListening(searchName,10000);
        }*/
    }

    private void setupRecognizer(File assetsDir) throws IOException {

        recognizer = SpeechRecognizerSetup.defaultSetup()

                .setAcousticModel(new File(assetsDir, "en-us-ptm"))
                .setDictionary(new File(assetsDir, "cmudict-en-us.dict"))
                .getRecognizer();
        recognizer.addListener(this);

        File animalgrammer = new File(assetsDir, "animals.gram");
        recognizer.addGrammarSearch(ANIMALS,animalgrammer);
        File musicgrammer = new File(assetsDir, "music.gram");
        recognizer.addGrammarSearch(MUSIC,musicgrammer);
        File cuisingrammer = new File(assetsDir, "cuisine.gram");
        recognizer.addGrammarSearch(CUISIN,cuisingrammer);
        File elctrogrammer = new File(assetsDir, "electro.gram");
        recognizer.addGrammarSearch(ELECTRO,elctrogrammer);
        File infogrammer = new File(assetsDir, "info.gram");
        recognizer.addGrammarSearch(INFO,infogrammer);
        File flagsgrammer = new File(assetsDir, "flag.gram");
        recognizer.addGrammarSearch(FLAGS,flagsgrammer);
        File buildinggrammer = new File(assetsDir, "building.gram");
        recognizer.addGrammarSearch(BUILDING,buildinggrammer);
        File schoolgrammer = new File(assetsDir, "school.gram");
        recognizer.addGrammarSearch(SCHOOL,schoolgrammer);



     /*   reco1 = SpeechRecognizerSetup.defaultSetup()

                //.setAcousticModel(new File(assetsDir, "en-us-ptm"))
                //.setDictionary(new File(assetsDir, "cmudict-en-us.dict"))

                .setAcousticModel(new File(assetsDir,"cmusphinx-fr-ptm-8khz-5.2"))
                .setDictionary(new File(assetsDir,"fr.dict"))

                //.setRawLogDir(assetsDir) // To disable logging of raw audio comment out this call (takes a lot of space on the device)

                .getRecognizer();
        reco1.addListener(this);

        /* In your application you might not need to add all those searches.
          They are added here for demonstration. You can leave just one.
         */

        // Create keyword-activation search.

        //File musicfrgrammer=new File (assetsDir,"animal.gram");
        //reco1.addGrammarSearch(ANIMAL,musicfrgrammer);








    }

    @Override
    public void onError(Exception error) {

    }

    @Override
    public void onTimeout() {

    }

}



