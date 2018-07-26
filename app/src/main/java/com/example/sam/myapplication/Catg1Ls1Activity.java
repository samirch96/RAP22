package com.example.sam.myapplication;


import android.Manifest;
import android.app.Activity;
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

public class Catg1Ls1Activity extends Activity implements RecognitionListener {

    TextView result;

    ViewFlipper viewFlipper;


    public String text;

    static int co=0, sc=0, po=0, lang=0;

    SharedPreferences e,x;

    SharedPreferences.Editor ee,xx;

    Button bfr,ben,bes,bl;

    public static final String ANIMALS="animals";
    public static final String ANIMAL="animal";
    /* Keyword we are looking for to activate menu */


    /* Used to handle permission request */
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    private SpeechRecognizer recognizer,reco1;
    private HashMap<String, Integer> captions;
    private String categories;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // Prepare the data for UI

        setContentView(R.layout.activity_catg1_ls1);

        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);


        bfr=(Button)findViewById(R.id.btn_fr);
        ben=(Button)findViewById(R.id.btn_en);

        bl=(Button)findViewById(R.id.btn_listen);
        bl.setVisibility(View.INVISIBLE);
        result= (TextView)findViewById(R.id.result_text);
        bfr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reco1.startListening(ANIMAL);
                switchSearch(ANIMAL);
                bfr.setVisibility(View.INVISIBLE);
                ben.setVisibility(View.INVISIBLE);
                bl.setVisibility(View.VISIBLE);
                lang=1;
                // bes.setVisibility(View.INVISIBLE);
            }
        });
        ben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recognizer.startListening(ANIMALS);
                switchSearch(ANIMALS);
                bfr.setVisibility(View.INVISIBLE);
                ben.setVisibility(View.INVISIBLE);
                bl.setVisibility(View.VISIBLE);
                //   bes.setVisibility(View.INVISIBLE);
                lang=2;
            }
        });
       /* bes.setOnClickListener(new View.OnClickListener() {
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
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Catg1Ls1Activity.this);
                a_builder.setMessage("Secrifi 20 points ?").setCancelable(false).setPositiveButton("yes" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        int h = x.getInt("pt_a",0);
                        switch (lang){
                            case 1:
                                    Intent i1 = new Intent(Catg1Ls1Activity.this, TTSFRActivity.class);
                                    startActivity(i1);
                                    break;
                            case 2:
                                    Intent i2 = new Intent(Catg1Ls1Activity.this, TTSActivity.class);
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
        WeakReference<Catg1Ls1Activity> activityReference;
        SetupTask(Catg1Ls1Activity activity) {
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
        if(lang==2) {
            switchSearch(ANIMALS);
            String tab[] = {"cat", "dog", "monkey", "wolf", "cow", "bee"};
            text = hypothesis.getHypstr();
            int ps_score = (int) (hypothesis.getBestScore() * -0.005);

            if (hypothesis.getHypstr().equals(tab[co])) {
                if (ps_score < 3) {
                    Toast.makeText(this, "your score is " + ps_score + "/10  try again", Toast.LENGTH_LONG).show();
                } else if (ps_score >= 3 && ps_score < 5) {
                    po = po + 20;
                    sc = sc + 3;
                    viewFlipper.showNext();
                    co++;
                } else if (ps_score >= 5 && ps_score < 7) {
                    po = po + 40;
                    sc = sc + 5;
                    viewFlipper.showNext();
                    co++;
                } else if (ps_score >= 7 && ps_score < 9) {
                    po = po + 60;
                    sc = sc + 7;
                    viewFlipper.showNext();
                    co++;
                } else if (ps_score >= 9) {
                    po = po + 100;
                    sc = sc + 9;
                    viewFlipper.showNext();
                    co++;
                }
                if (co == 6) {
                    finish();
                    Intent i = new Intent(Catg1Ls1Activity.this, CardActivity.class);
                    startActivity(i);
                    Toast.makeText(this, "K.O", Toast.LENGTH_LONG).show();
                    /*e = getSharedPreferences("xx", 0);
                    ee = e.edit();
                    ee.putInt("scoreee", sc);
                    ee.apply();*/
                    x = getSharedPreferences("xx", 0);
                    xx = x.edit();
                    xx.putInt("pt_a", po);
                    xx.apply();
                }
                Toast.makeText(this, "co =" + co + "//sc=" + sc + "//po =" + po, Toast.LENGTH_LONG).show();
            }

        }else
        if(lang==1){
            switchSearch(ANIMAL);
            String tab[] = {"chat", "chien", "singe", "loup", "vache", "abeille"};
            text = hypothesis.getHypstr();
            int ps_score = (int) (hypothesis.getBestScore() * -0.005);

            if (hypothesis.getHypstr().equals(tab[co])) {
                if (ps_score < 3) {
                    Toast.makeText(this, "your score is " + ps_score + "/10  try again", Toast.LENGTH_LONG).show();
                } else if (ps_score >= 3 && ps_score < 5) {
                    po = po + 20;
                    sc = sc + 3;
                    viewFlipper.showNext();
                    co++;
                } else if (ps_score >= 5 && ps_score < 7) {
                    po = po + 40;
                    sc = sc + 5;
                    viewFlipper.showNext();
                    co++;
                } else if (ps_score >= 7 && ps_score < 9) {
                    po = po + 60;
                    sc = sc + 7;
                    viewFlipper.showNext();
                    co++;
                } else if (ps_score >= 9) {
                    po = po + 100;
                    sc = sc + 9;
                    viewFlipper.showNext();
                    co++;
                }
                if (co == 6) {
                    finish();
                    Intent i = new Intent(Catg1Ls1Activity.this, CardActivity.class);
                    startActivity(i);
                    Toast.makeText(this, "K.O", Toast.LENGTH_LONG).show();
                    /*e = getSharedPreferences("dd", 0);
                    ee = e.edit();
                    ee.putInt("scoreee", sc);
                    ee.apply();*/
                    x = getSharedPreferences("xx", 0);
                    xx = x.edit();
                    xx.putInt("pt_a", po);
                    xx.apply();
                }
                Toast.makeText(this, "co =" + co + "//sc=" + sc + "//po =" + po, Toast.LENGTH_LONG).show();
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
        if (lang == 2) {

            recognizer.stop();

            // If we are not spotting, start listening with timeout (10000 ms or 10 seconds).
            if (searchName.equals(ANIMALS))
                recognizer.startListening(searchName);


            else
                recognizer.startListening(searchName, 10000);
        }else
        if(lang== 1){
            reco1.stop();

            if (searchName.equals(ANIMAL))
                reco1.startListening(searchName);
            else
                reco1.startListening(searchName,10000);
        }
    }

    private void setupRecognizer(File assetsDir) throws IOException {
        // The recognizer can be configured to perform multiple searches
        // of different kind and switch between them

        recognizer = SpeechRecognizerSetup.defaultSetup()

                .setAcousticModel(new File(assetsDir, "en-us-ptm"))
                .setDictionary(new File(assetsDir, "cmudict-en-us.dict"))

                //.setAcousticModel(new File(assetsDir,"cmusphinx-fr-ptm-8khz-5.2"))
                //.setDictionary(new File(assetsDir,"fr.dict"))

                //.setRawLogDir(assetsDir) // To disable logging of raw audio comment out this call (takes a lot of space on the device)

                .getRecognizer();
        recognizer.addListener(this);

        File musicgrammer = new File(assetsDir, "animals.gram");
        recognizer.addGrammarSearch(ANIMALS,musicgrammer);

        reco1 = SpeechRecognizerSetup.defaultSetup()

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

        File musicfrgrammer=new File (assetsDir,"animal.gram");
        reco1.addGrammarSearch(ANIMAL,musicfrgrammer);







    }

    @Override
    public void onError(Exception error) {

    }

    @Override
    public void onTimeout() {

    }

}
