package com.example.nayibasiselizalde.lab1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Nayib and Lindsey on 9/28/17.
 */

public class PasswordDialog extends DialogFragment {

    // declare variables.
    public Button confirm;
    private EditText retype;

    // create interface
    public interface FragmentDialogListener{
        public void onChoose();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // creates new dialog and displays the corresponding layout.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.password_confirmation, null);
        builder.setView(dialogView);

        // initiate the previously declared variables
        confirm = dialogView.findViewById(R.id.confirm_button);
        retype = dialogView.findViewById(R.id.editText4);

        // when confirm is clicked, if the passwords match, dismiss the dialog, enable the save button
        // and update the check variable.
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(retype.getText().toString().equals(MainActivity.pass.toString())) {
                    dismiss();
                    MainActivity.save.setEnabled(true);
                    MainActivity.check = 1;
                }
            }
        });

        return builder.create();
    }
}