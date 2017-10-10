package com.example.nayibasiselizalde.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.app.Dialog;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by nayibasiselizalde on 10/9/17.
 */

public class LogoutDialog extends DialogFragment {

    public Button confirm;
    public Button cancel;

    public interface FragmentDialogListener{
        public void onChoose();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.logout_confirmation, null);
        builder.setView(dialogView);

        confirm = dialogView.findViewById(R.id.confirm_logout);
        cancel = dialogView.findViewById(R.id.cancel_logout);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                Intent intent = new Intent(getContext(), SignIn.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return builder.create();
    }
}
