package com.example.myspace2.Adapter;



import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myspace2.Activity.MainpageActivity;
import com.example.myspace2.Fragment.AdFragment1;
import com.example.myspace2.Fragment.AdFragment2;
import com.example.myspace2.Fragment.AdFragment3;



public class AdAdapter extends FragmentPagerAdapter {
    private AdFragment1 adfragment1;
    private AdFragment2 adfragment2;
    private AdFragment3 adfragment3;
    public AdAdapter(FragmentManager fm) {
        super(fm);
        adfragment1=new AdFragment1();
        adfragment2=new AdFragment2();
        adfragment3=new AdFragment3();
    }



    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainpageActivity.PAGE_ONE:
                fragment = adfragment1;
                break;
            case MainpageActivity.PAGE_TWO:
                fragment = adfragment2;
                break;
            case MainpageActivity.PAGE_THREE:
                fragment = adfragment3;
                break;
        }
        return fragment;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
    @Override
    public int getCount() {
        return 3;
    }

}
//public class AdAdapter extends PagerAdapter {
//    private ArrayList<View> viewLists;
//
//    public AdAdapter() {
//    }
//
//    public AdAdapter(ArrayList<View> viewLists) {
//        super();
//        this.viewLists = viewLists;
//    }
//
//    @Override
//    public int getCount() {
//        return viewLists.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        container.addView(viewLists.get(position));
//        return viewLists.get(position);
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(viewLists.get(position));
//    }
//}

