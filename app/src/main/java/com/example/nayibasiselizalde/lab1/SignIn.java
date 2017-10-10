package com.example.nayibasiselizalde.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by nayibasiselizalde on 10/8/17.
 */

public class SignIn extends Activity {

    public TextView clear;
    public TextView create;
    public Button signInButton;
    public EditText name;
    public EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

        clear = findViewById(R.id.textView5);
        create = findViewById(R.id.textView4);
        signInButton = findViewById(R.id.signin_button);
        name = findViewById(R.id.name_signin);
        // click listener if text == @string/name, clear
        // end activity when sign in
        pass = findViewById(R.id.pass_signin);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                pass.setText("");
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("from","login");
                startActivity(intent);
                finish();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });

        pass.setTransformationMethod(new PasswordTransformationMethod());

    }
}
