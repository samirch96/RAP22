package com.example.sam.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class TestCatgShowActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_catg_show);

        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        b=(Button)findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });

    }


    public void catg1(View v){Toast.makeText(this, "you selected catg 1",Toast.LENGTH_LONG).show();}
    public void catg2(View v){Toast.makeText(this, "you selected catg 2",Toast.LENGTH_LONG).show();}
    public void catg3(View v){Toast.makeText(this, "you selected catg 3",Toast.LENGTH_LONG).show();}
    public void catg4(View v){Toast.makeText(this, "you selected catg 4",Toast.LENGTH_LONG).show();}
    public void catg5(View v){Toast.makeText(this, "you selected catg 5",Toast.LENGTH_LONG).show();}
    public void catg6(View v){Toast.makeText(this, "you selected catg 6é",Toast.LENGTH_LONG).show();}
}
