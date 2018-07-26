package com.example.sam.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by DELL on 31/03/2018.
 */

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context=context;
    }

    public int[] slide_images={
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,

    };

    public String[] slide_heading={
            "ONE",
            "TWO",
            "THREE",
            "FOUR",
            "FIVE",
    };

    public String[] slide_descs={
            "1 kbxcjhv<hxcgv<qscvg<vscgv<h",
            "2 kbxcjhv<hxcgv<qscvg<vscgv<h",
            "3 kbxcjhv<hxcgv<qscvg<vscgv<h",
            "4 kbxcjhv<hxcgv<qscvg<vscgv<h",
            "5 kbxcjhv<hxcgv<qscvg<vscgv<h",

    };
    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(RelativeLayout) object;
    }

    @SuppressLint("ServiceCast")
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageView =(ImageView)view.findViewById(R.id.imageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.textView);
        TextView slideDescription = (TextView) view.findViewById(R.id.textView);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
