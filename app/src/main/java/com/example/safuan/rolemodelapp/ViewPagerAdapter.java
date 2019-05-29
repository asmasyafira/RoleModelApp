package com.example.safuan.rolemodelapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class ViewPagerAdapter  extends PagerAdapter {

    Context context;
    int[] isi;

    public ViewPagerAdapter(Context context, int[] isi){
        this.context = context;
        this.isi = isi;
    }




    @Override
    public int getCount() {
        return isi.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((ScrollView)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TextView isii;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = layoutInflater.inflate(R.layout.activity_viewitem,container,false);
        isii = v.findViewById(R.id.isiitem);

        isii.setText(isi[position]);
        ((ViewPager)container).addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((ScrollView)object);
    }
}
