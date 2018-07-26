package com.example.sam.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestSliderActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDot;
    private SlideAdapter slideAdapter;
    private Button mNext;
    private Button mBack;
    private int mCurrentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_slider);

        mSlideViewPager = (ViewPager)findViewById(R.id.v);
        mDotLayout=(LinearLayout)findViewById(R.id.l);

        mNext=(Button)findViewById(R.id.btn_next);
        mBack=(Button)findViewById(R.id.btn_back);

        slideAdapter = new SlideAdapter(this);

        mSlideViewPager.setAdapter(slideAdapter);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentpage+1);
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentpage-1);
            }
        });
    }

    private void addDotsIndicator(int position) {

        mDot=new TextView[8];

        for(int i=0;i<mDot.length;i++){
            mDot[i]=new TextView(this);
            mDot[i].setTextSize(35);
            mDot[i].setTextColor(getResources().getColor(R.color.colorPrimary));
            mDotLayout.addView(mDot[i]);
        }

        if(mDot.length>0){
            mDot[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentpage=position;

            if(position==0){
                mNext.setEnabled(true);
                mBack.setEnabled(false);
                mBack.setVisibility(View.INVISIBLE);

                mNext.setText("Next");
                mBack.setText("");
            }else if (position == mDot.length-1){
                mNext.setEnabled(true);
                mBack.setEnabled(true);
                mBack.setVisibility(View.VISIBLE);

                mNext.setText("Finish");
                mBack.setText("Back");
            }else {
                mNext.setEnabled(true);
                mBack.setEnabled(true);
                mBack.setVisibility(View.VISIBLE);

                mNext.setText("Next");
                mBack.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
