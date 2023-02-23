package com.example.myspace2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myspace2.R;

public class AdFragment2 extends Fragment {
    View view;
    boolean isVisible =true;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.banner_2, container, false);
        return view;
    }
}
