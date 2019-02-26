package com.mifeng.us.tablayout.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by night_slight on 2019/2/25.
 */

public class MPageAdapter extends PagerAdapter{

    private ArrayList<String>mTitles;
    private ArrayList<View>mIcon;

    public MPageAdapter(ArrayList<String> mTitles, ArrayList<View> mIcon) {
        this.mTitles = mTitles;
        this.mIcon = mIcon;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mIcon.get(position);
        if (view !=null && view.getParent() !=null){
            container.removeView(view);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }
}
