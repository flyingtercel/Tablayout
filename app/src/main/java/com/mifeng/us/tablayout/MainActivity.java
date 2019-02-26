package com.mifeng.us.tablayout;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mifeng.us.tablayout.adapter.MPageAdapter;
import com.mifeng.us.tablayout.views.HbElasticView;
import com.mifeng.us.tablayout.views.MyIndicator;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    MyIndicator myIndicator;
    ScrollView srolview;
    HbElasticView mHbElasticView;
    private ViewPager mViewPager;
    private int[]mIds = {R.mipmap.index_icon_service,R.mipmap.index_icon_store,R.mipmap.login_icon_logo,R.mipmap.my_icon_task,R.mipmap.order_icon_add};
    private ArrayList<View>mIcon = new ArrayList<>();
    ArrayList<String>mTitles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initIcon();
        initView();

    }

    private void initIcon() {

        for(int i=0;i<mIds.length;i++){
            ImageView mImageView = (ImageView) LayoutInflater.from(this).inflate(R.layout.layout, null);
            mImageView.setImageResource(mIds[i]);
            mIcon.add(mImageView);
        }
        mTitles.add("aaa1");
        mTitles.add("vvv2");
        mTitles.add("ccc3");
        mTitles.add("ddd4");
        mTitles.add("ssss5");


    }

    private void initView() {
        mHbElasticView = findViewById(R.id.hb);
        myIndicator =  findViewById(R.id.my);

        View btn_add = findViewById(R.id.btn_add);
        View btn_speed = findViewById(R.id.btn_speed);
        View btn_jinzhi = findViewById(R.id.btn_jinzhi);
        View btn_length = findViewById(R.id.btn_length);
        View btn_color = findViewById(R.id.btn_color);
        mViewPager = findViewById(R.id.mViewPager);

        MPageAdapter mPageAdapter = new MPageAdapter(mTitles,mIcon);
        mViewPager.setAdapter(mPageAdapter);
        myIndicator.setHeadTitles(mTitles);


        btn_add.setOnClickListener(new OnClick());
        btn_speed.setOnClickListener(new OnClick());
        btn_jinzhi.setOnClickListener(new OnClick());
        btn_length.setOnClickListener(new OnClick());
        btn_color.setOnClickListener(new OnClick());

        setOnIndicatorListener();
    }

    private void setOnIndicatorListener() {
        myIndicator.setIndiacatorListener(new MyIndicator.OnIndiacatorClickListener() {
            @Override
            public void onClick(int position, View view) {
                Log.i("tag","==========="+position+"  view"+((TextView)view).getText());
                mViewPager.setCurrentItem(position);
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                myIndicator.setChanger(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_add:
                    myIndicator.add("tab5", 10);
                    myIndicator.setChanger(4);
                    Toast.makeText(MainActivity.this, "添加tab5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_speed:
                    myIndicator.setAnimationTime(100);
                    Toast.makeText(MainActivity.this, "修改移动速度改为100", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_jinzhi:
                    myIndicator.setProhibitPositio(2);
                    Toast.makeText(MainActivity.this, "禁止tab3修改状态", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_length:
                    myIndicator.setFull();
                    Toast.makeText(MainActivity.this, "修改下标线的长度铺满", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_color:
                    myIndicator.resetNomalColor(0xff000000, 0xffffffff, 0xff000000);
                    break;
            }
        }
    }


    private class Service extends IntentService {

        /**
         * Creates an IntentService.  Invoked by your subclass's constructor.
         *
         * @param name Used to name the worker thread, important only for debugging.
         */
        public Service(String name) {
            super(name);
        }

        @Override
        public void onCreate() {
            super.onCreate();
        }

        @Override
        protected void onHandleIntent(@Nullable Intent intent) {

        }
    }

}
