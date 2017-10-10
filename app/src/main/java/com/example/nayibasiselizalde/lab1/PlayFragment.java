package com.example.nayibasiselizalde.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by nayibasiselizalde on 10/8/17.
 */

public class PlayFragment extends Fragment{
    private static final String TAG = "PlayFragment";
    public Button test;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
                         savedInstanceState){
        View view = inflater.inflate(R.layout.play_layout, container, false);

        return view;
    }

}
