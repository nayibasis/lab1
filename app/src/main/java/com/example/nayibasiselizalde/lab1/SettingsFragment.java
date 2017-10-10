package com.example.nayibasiselizalde.lab1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by nayibasiselizalde on 10/8/17.
 */

public class SettingsFragment extends Fragment{
    private static final String TAG = "SettingsFragment";
    public Spinner notify;
    public Button signOut;
    private LogoutDialog logoutDialogBox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState){
        View view = inflater.inflate(R.layout.settings_layout, container, false);

        notify = view.findViewById(R.id.spinner2);
        signOut = view.findViewById(R.id.signout_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SettingsFragment.super.getContext(), R.array.Alert,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        notify.setAdapter(adapter);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        return view;
    }

    public void showDialog(){
        logoutDialogBox = new LogoutDialog();
        logoutDialogBox.show(getFragmentManager(), "MyFragment");

    }
}
