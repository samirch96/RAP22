package com.example.sam.myapplication;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.DecelerateInterpolator;
        import android.view.animation.RotateAnimation;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.Random;

public class RandomActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    ImageView img;
    int degree=0, degree_old=0;
    Random r;
    String text;
    private static final float FACTOR = 4.86f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        btn=(Button)findViewById(R.id.btn);
        txt=(TextView)findViewById(R.id.txt);
        img=(ImageView)findViewById(R.id.ic_wheel);

        r= new Random();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                degree_old = degree % 360;
                degree= r.nextInt(3600)+720;
                RotateAnimation rotate = new RotateAnimation(degree_old,degree,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        txt.setText("");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        txt.setText(currentNumber(360-(degree%360)));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                img.startAnimation(rotate);

                if (String.valueOf(text).equals("a")){
                    Intent i = new Intent(getApplication(), Catg1LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("b")){
                    Intent i = new Intent(getApplication(), Catg2LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("c")){
                    Intent i = new Intent(getApplication(), Catg3LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("d")){
                    Intent i = new Intent(getApplication(), Catg4LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("e")){
                    Intent i = new Intent(getApplication(), Catg5LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("f")){
                    Intent i = new Intent(getApplication(), Catg6LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("g")){
                    Intent i = new Intent(getApplication(), Catg7LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("h")){
                    Intent i = new Intent(getApplication(), Catg8LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("i")){
                    Intent i = new Intent(getApplication(), Catg8LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("g")){
                    Intent i = new Intent(getApplication(), Catg1LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("k")){
                    Intent i = new Intent(getApplication(), Catg2LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("l")){
                    Intent i = new Intent(getApplication(), Catg3LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("m")){
                    Intent i = new Intent(getApplication(), Catg4LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("n")){
                    Intent i = new Intent(getApplication(), Catg5LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("o")){
                    Intent i = new Intent(getApplication(), Catg6LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("p")){
                    Intent i = new Intent(getApplication(), Catg7LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("r")){
                    Intent i = new Intent(getApplication(), Catg8LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("s")){
                    Intent i = new Intent(getApplication(), Catg8LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("t")){
                    Intent i = new Intent(getApplication(), Catg1LsActivity.class);
                    startActivity(i);
                }


                if (String.valueOf(text).equals("u")){
                    Intent i = new Intent(getApplication(), Catg2LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("v")){
                    Intent i = new Intent(getApplication(), Catg3LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("w")){
                    Intent i = new Intent(getApplication(), Catg4LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("x")){
                    Intent i = new Intent(getApplication(), Catg5LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("y")){
                    Intent i = new Intent(getApplication(), Catg6LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("z")){
                    Intent i = new Intent(getApplication(), Catg7LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("aa")){
                    Intent i = new Intent(getApplication(), Catg8LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("bb")){
                    Intent i = new Intent(getApplication(), Catg1LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("cc")){
                    Intent i = new Intent(getApplication(), Catg2LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("dd")){
                    Intent i = new Intent(getApplication(), Catg3LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("ee")){
                    Intent i = new Intent(getApplication(), Catg4LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("ff")){
                    Intent i = new Intent(getApplication(), Catg5LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("gg")){
                    Intent i = new Intent(getApplication(), Catg6LsActivity.class);
                    startActivity(i);
                }

                if (String.valueOf(text).equals("hh")){
                    Intent i = new Intent(getApplication(), Catg7LsActivity.class);
                    startActivity(i);
                }
                if (String.valueOf(text).equals("ii")){
                    Intent i = new Intent(getApplication(), Catg8LsActivity.class);
                    startActivity(i);
                }
                if (String.valueOf(text).equals("jj")){
                    Intent i = new Intent(getApplication(), Catg8LsActivity.class);
                    startActivity(i);
                }




            }
        });


    }


    private String currentNumber(int degrees){
        text ="";

        if (degrees>=(FACTOR*1)&&degrees<(FACTOR*3)){
            text = "a";
        }
        if (degrees>=(FACTOR*3)&&degrees<(FACTOR*5)){
            text = "b";
        }
        if (degrees>=(FACTOR*5)&&degrees<(FACTOR*7)){
            text = "c";
        }
        if (degrees>=(FACTOR*7)&&degrees<(FACTOR*9)){
            text = "d";
        }
        if (degrees>=(FACTOR*9)&&degrees<(FACTOR*11)){
            text = "e";
        }
        if (degrees>=(FACTOR*11)&&degrees<(FACTOR*13)){
            text = "f";
        }
        if (degrees>=(FACTOR*13)&&degrees<(FACTOR*15)){
            text = "g";
        }
        if (degrees>=(FACTOR*15)&&degrees<(FACTOR*17)){
            text = "h";
        }
        if (degrees>=(FACTOR*17)&&degrees<(FACTOR*19)){
            text = "i";
        }
        if (degrees>=(FACTOR*19)&&degrees<(FACTOR*21)){
            text = "j";
        }
        if (degrees>=(FACTOR*21)&&degrees<(FACTOR*23)){
            text = "k";
        }
        if (degrees>=(FACTOR*23)&&degrees<(FACTOR*25)){
            text = "l";
        }
        if (degrees>=(FACTOR*25)&&degrees<(FACTOR*27)){
            text = "m";
        }
        if (degrees>=(FACTOR*27)&&degrees<(FACTOR*29)){
            text = "n";
        }
        if (degrees>=(FACTOR*29)&&degrees<(FACTOR*31)){
            text = "o";
        }
        if (degrees>=(FACTOR*31)&&degrees<(FACTOR*33)){
            text = "p";
        }
        if (degrees>=(FACTOR*33)&&degrees<(FACTOR*35)){
            text = "q";
        }
        if (degrees>=(FACTOR*35)&&degrees<(FACTOR*37)){
            text = "r";
        }
        if (degrees>=(FACTOR*37)&&degrees<(FACTOR*39)){
            text = "s";
        }
        if (degrees>=(FACTOR*39)&&degrees<(FACTOR*41)){
            text = "t";
        }
        if (degrees>=(FACTOR*41)&&degrees<(FACTOR*43)){
            text = "u";
        }
        if (degrees>=(FACTOR*43)&&degrees<(FACTOR*45)){
            text = "v";
        }
        if (degrees>=(FACTOR*45)&&degrees<(FACTOR*47)){
            text = "w";
        }
        if (degrees>=(FACTOR*47)&&degrees<(FACTOR*49)){
            text = "x";
        }
        if (degrees>=(FACTOR*49)&&degrees<(FACTOR*51)){
            text = "y";
        }
        if (degrees>=(FACTOR*51)&&degrees<(FACTOR*53)){
            text = "z";
        }
        if (degrees>=(FACTOR*53)&&degrees<(FACTOR*55)){
            text = "aa";
        }
        if (degrees>=(FACTOR*55)&&degrees<(FACTOR*57)){
            text = "bb";
        }
        if (degrees>=(FACTOR*57)&&degrees<(FACTOR*59)){
            text = "cc";
        }
        if (degrees>=(FACTOR*59)&&degrees<(FACTOR*61)){
            text = "dd";
        }
        if (degrees>=(FACTOR*61)&&degrees<(FACTOR*63)){
            text = "ee";
        }
        if (degrees>=(FACTOR*63)&&degrees<(FACTOR*65)){
            text = "ff";
        }
        if (degrees>=(FACTOR*65)&&degrees<(FACTOR*67)){
            text = "jj";
        }
        if (degrees>=(FACTOR*67)&&degrees<(FACTOR*69)){
            text = "hh";
        }
        if (degrees>=(FACTOR*69)&&degrees<(FACTOR*71)){
            text = "ii";
        }
        if (degrees>=(FACTOR*71)&&degrees<(FACTOR*73)){
            text = "gg";
        }

        if ((degrees>= (FACTOR*73)&& degrees<360)|| (degrees >=0 && degrees< (FACTOR*1))){
            text="0";
        }

        return  text;
    }
}
