package com.example.nayibasiselizalde.lab1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by nayibasiselizalde on 10/4/17.
 */

public class SignUp extends Activity {
    final int request_image_capture = 1;
    // variable to check if password has been confirmed
    public static int check = 0;
    Bitmap bitmap;
    public static String shared_pref = "my_sharedpref";
    private PasswordDialog confirmationDialogBox;
    public static Editable pass;
    public static Button save;
    private ImageView imagebutton;
    public Button confirm;
    public Button back;
    public Button clear;
    public EditText handle;
    public EditText name;
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        // initiate previously declared variables
        save = findViewById(R.id.save_button);
        confirm = findViewById(R.id.confirm_button);
        back = findViewById(R.id.backButton);
        clear = findViewById(R.id.clear);
        handle = findViewById(R.id.editText);
        name = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        imagebutton = findViewById(R.id.image_button);
        // show image if there is a bitmap
        if(bitmap != null)imagebutton.setImageBitmap(bitmap);


        // When user clicks "Clear" button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // empties the fields and resets image
                handle.setText("");
                name.setText("");
                password.setText("");
                imagebutton.setImageBitmap(null);
                // resets clear/back button
                clear.setVisibility(View.INVISIBLE);
                back.setVisibility(View.VISIBLE);

            }
        });

        // Go to sign in if they already have an account
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });

        // When user wants to take a picture
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start a new intent
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takePictureIntent, request_image_capture);
                }
            }


        });

        // Saves the information locally
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // makes sure all the fields are filled before saving
                if(handle.getText().length() > 0 && name.getText().length() > 0
                        && password.getText().length() > 0){
                    onSaveClickedSP(view);
                    Toast.makeText(SignUp.this, "Saved Successfully :)", Toast.LENGTH_LONG).show();
                }
                // if a field is empty show a message warning the user
                else {
                    Toast.makeText(SignUp.this, "Fill out all fields!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Next three methods all check if the user edits the text, and if so reset the clear and back buttons.
        handle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                clear.setVisibility(View.VISIBLE);
                back.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                clear.setVisibility(View.VISIBLE);
                back.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                clear.setVisibility(View.VISIBLE);
                back.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // if the information is saved locally, display it.
        //if(! shared_pref.isEmpty()) onLoadClickedSP();

        // hide password
        password.setTransformationMethod(new PasswordTransformationMethod());

        // If the user finishes typing the password, the confirmation window pops up.
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && check == 0){
                    Log.d("PASS", "lost focus");
                    pass = password.getText();
                    showDialog(v);
                }
                else{Log.d("PASS", "got focus");}
            }
        });
    }



    // Saved the users information by getting the text from each field.
    public void onSaveClickedSP(View view){
        SharedPreferences sp = getSharedPreferences(shared_pref, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", handle.getText().toString());
        editor.putString("name", name.getText().toString());
        editor.putString("password", password.getText().toString());
    }

    // Load the information previously saved.
    public void onLoadClickedSP(){
        SharedPreferences sp = getSharedPreferences(shared_pref, 0);
        handle.setText(sp.getString("username", ""));
        name.setText(sp.getString("name", ""));
        password.setText(sp.getString("password", ""));
    }

    // Creates a new Dialog box and displays it.
    public void showDialog(View view){
        confirmationDialogBox = new PasswordDialog();
        confirmationDialogBox.show(getFragmentManager(), "MyFragment");

    }

    // Next three methods allow the user to save the picture and keep it while it rotates.
    // Taken from one of the class examples.
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelable("IMG", bitmap);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        bitmap = savedInstanceState.getParcelable("IMG");
        imagebutton.setImageBitmap(bitmap);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == request_image_capture && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bitmap = (Bitmap) extras.get("data");
            imagebutton.setImageBitmap(bitmap);
        }
    }

}
