package com.example.myspace2.Activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myspace2.Adapter.MyFragmentPagerAdapter;
import com.example.myspace2.R;

public class MainpageActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {
    private RadioGroup btn_group;
    private RadioButton btn_1;
    private RadioButton btn_2;
    private RadioButton btn_3;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        btn_1.setChecked(true);
    }
    private void bindViews() {
        btn_group = (RadioGroup) findViewById(R.id.btn_group);
        btn_1 = (RadioButton) findViewById(R.id.btn_1);
        btn_2 = (RadioButton) findViewById(R.id.btn_2);
        btn_3 = (RadioButton) findViewById(R.id.btn_3);
        btn_group.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.viewpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.btn_1:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.btn_2:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.btn_3:
                vpager.setCurrentItem(PAGE_THREE);
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state?????????????????????0????????????????????????1???????????????2????????????
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    btn_1.setChecked(true);
                    break;
                case PAGE_TWO:
                    btn_2.setChecked(true);
                    break;
                case PAGE_THREE:
                    btn_3.setChecked(true);
                    break;
            }
        }
    }
}
