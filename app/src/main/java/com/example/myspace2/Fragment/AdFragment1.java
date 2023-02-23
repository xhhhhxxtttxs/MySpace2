package com.example.myspace2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myspace2.R;



public class AdFragment1 extends Fragment {
    View view;
    boolean isVisible =true;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.banner_1, container, false);
        return view;
    }

    //    @Override
//    public void onResume() {
//        super.onResume();
//        mHandler.sendEmptyMessageDelayed(1,3000);
//    }
//    @SuppressLint("HandlerLeak")
//    private Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
//                    int count = 3;
//                    int currentItem=advpager.getCurrentItem();
//                    int now=(currentItem+1)%count;
//                    advpager.setCurrentItem(now,true);
//                    this.sendEmptyMessageDelayed(1,3000);
//            }
//        }
//    };

}


