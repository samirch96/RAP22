package com.example.sam.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OptLsActivity extends CatgCardViewActivity {
    Button l1,l2,l3,l4;
    TextView a1;
    static int  a,Ls_id=0,Ls_co=0,Catg_to_opt=0;
    static boolean check=true;
    static String pt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        l1=(Button)findViewById(R.id.lv1);
        l2=(Button)findViewById(R.id.lv2);
        l3=(Button)findViewById(R.id.lv3);
        l4=(Button)findViewById(R.id.lv4);

        switch (Catg_id){//selon id enter au cour de la selection de la categorie
            case 1 :
                pt="pt_a";//le nom du la cle au fichier SherdedPreferences
                SharedPreferences sharedPreferences1 = getSharedPreferences("pt_a", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences1.getInt("pt_a", 0));//affiche ne nbr du jeton
                a = sharedPreferences1.getInt("pt_a",0);
                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ls_id=0;//id du level
                        Ls_co=6;//nbr du photo
                        check=true;//partie ouvert on non
                        intent();//faire une appelle vers l'activite du PocketSphinx
                    }
                });
                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>120){//il faut que nbr du jeton = 120 pour que level 2 soit ouvert
                            Ls_id=1;
                            Ls_co=5;
                            check=true;
                        }else {
                            check=false;
                        }
                        intent();
                    }
                });
                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>280){
                            Ls_id=2;
                            Ls_co=5;
                            check=true;
                        }else {
                            check=false;
                        }
                        intent();
                    }
                });
                l4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>480){
                            Ls_id=3;
                            Ls_co=5;
                            check=true;
                        }else {
                            check=false;
                        }
                        intent();
                    }
                });
                break;

            case 2:
                pt="pt_m";
                SharedPreferences sharedPreferences2 = getSharedPreferences("pt_m", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences2.getInt("pt_m", 0));
                a = sharedPreferences2.getInt("pt_m",0);
                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ls_id=4;
                        Ls_co=5;
                    }
                });
                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>120){
                            Ls_id=5;
                            Ls_co=5;
                        }else {
                            check=false;
                        }
                    }
                });
                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>280){
                            Ls_id=6;
                            Ls_co=5;
                        }else {
                            check=false;
                        }
                    }
                });

                l4.setVisibility(View.INVISIBLE);
                break;


            case 3:
                pt="pt_i";
                SharedPreferences sharedPreferences3 = getSharedPreferences("pt_i", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences3.getInt("pt_i", 0));
                a = sharedPreferences3.getInt("pt_i",0);
                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ls_id=7;
                        Ls_co=4;
                    }
                });

                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>120){
                            Ls_id=8;
                            Ls_co=4;
                        }else {
                            check=false;
                        }
                    }
                });

                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>280){
                            Ls_id=9;
                            Ls_co=4;
                        }else {
                            check=false;
                        }
                    }
                });

                l4.setVisibility(View.INVISIBLE);
                break;

            case 4:
                pt="pt_c";
                SharedPreferences sharedPreferences4 = getSharedPreferences("pt_c", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences4.getInt("pt_c", 0));
                a = sharedPreferences4.getInt("pt_c",0);
                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ls_id=10;
                        Ls_co=4;
                    }
                });

                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>120){
                            Ls_id=11;
                            Ls_co=4;
                        }else {
                            check=false;
                        }
                    }
                });

                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>280){
                            Ls_id=12;
                            Ls_co=4;
                        }else {
                            check=false;
                        }
                    }
                });

                l4.setVisibility(View.INVISIBLE);
                break;


            case 5:
                pt="pt_e";
                SharedPreferences sharedPreferences5 = getSharedPreferences("pt_e", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences5.getInt("pt_e", 0));
                a = sharedPreferences5.getInt("pt_e",0);
                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ls_id=13;
                        Ls_co=4;
                    }
                });

                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>120){
                            Ls_id=14;
                            Ls_co=4;
                        }else {
                            check=false;
                        }
                    }
                });

                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>280){
                            Ls_id=15;
                            Ls_co=4;
                        }else {
                            check=false;
                        }
                    }
                });

                l4.setVisibility(View.INVISIBLE);
                break;


            case 6:
                pt="pt_s";
                SharedPreferences sharedPreferences6 = getSharedPreferences("pt_s", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences6.getInt("pt_s", 0));
                a = sharedPreferences6.getInt("pt_s",0);
                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ls_id=16;
                        Ls_co=8;
                    }
                });

                l2.setVisibility(View.INVISIBLE);

                l3.setVisibility(View.INVISIBLE);

                l4.setVisibility(View.INVISIBLE);
                break;

            case 7:
                pt="pt_b";
                SharedPreferences sharedPreferences7 = getSharedPreferences("pt_b", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences7.getInt("pt_b", 0));
                a = sharedPreferences7.getInt("pt_b",0);
                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ls_id=17;
                        Ls_co=4;
                    }
                });

                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>120){
                            Ls_id=18;
                            Ls_co=2;
                        }else {
                            check=false;
                        }
                    }
                });

                l3.setVisibility(View.INVISIBLE);

                l4.setVisibility(View.INVISIBLE);
                break;


            case 8:
                pt="pt_f";
                SharedPreferences sharedPreferences8 = getSharedPreferences("pt_f", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences8.getInt("pt_f", 0));
                a = sharedPreferences8.getInt("pt_f",0);
                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ls_id=19;
                        Ls_co=5;
                    }
                });

                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>120){
                            Ls_id=20;
                            Ls_co=5;
                        }else {
                            check=false;
                        }
                    }
                });

                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>280){
                            Ls_id=21;
                            Ls_co=4;
                        }else {
                            check=false;
                        }
                    }
                });

                l4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>480){
                            Ls_id=22;
                            Ls_co=6;
                        }else {
                            check=false;
                        }
                    }
                });
                break;


            case 9:
                pt="pt_v";
                SharedPreferences sharedPreferences9 = getSharedPreferences("pt_v", Context.MODE_PRIVATE);
                a1.setText("" + sharedPreferences9.getInt("pt_v", 0));
                a = sharedPreferences9.getInt("pt_v",0);
                l1.setVisibility(View.INVISIBLE);

                l2.setVisibility(View.INVISIBLE);

                l3.setVisibility(View.INVISIBLE);

                l4.setVisibility(View.INVISIBLE);

                break;


            default:break;
        }




    }

    public void intent(){
        if (check){
            Intent i1 = new Intent( OptLsActivity.this, OptActivity.class);
            startActivity(i1);
        }else{
            Toast.makeText(getApplicationContext(),"you don't have enough points", Toast.LENGTH_LONG).show();
        }
    }
}
