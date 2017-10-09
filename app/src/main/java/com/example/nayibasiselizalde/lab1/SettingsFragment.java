package com.example.nayibasiselizalde.lab1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nayibasiselizalde on 10/8/17.
 */

public class SettingsFragment extends Fragment{
    private static final String TAG = "SettingsFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState){
        View view = inflater.inflate(R.layout.settings_layout, container, false);

        return view;
    }
}
