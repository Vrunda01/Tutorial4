package com.rku.tutorial4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username , password;
    Button btnLogin;

    String correct_username = "admin@gmail.com";
    String correct_password = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.edtUsername);
        password = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnSubmit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate inputs

                String edtUsername = username.getText().toString();
                String edtPassword = password.getText().toString();

                if(!Patterns.EMAIL_ADDRESS.matcher(edtUsername).matches()) {
                    Toast.makeText(MainActivity.this, "Email format is not valid!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(edtUsername) || TextUtils.isEmpty(edtPassword)) {
                    Toast.makeText(MainActivity.this,"Empty Data Provided", Toast.LENGTH_LONG).show();
                }
                else if(edtUsername.equals(correct_username)) {
                    //check password
                    if(edtPassword.equals(correct_password)) {
                        //Toast.makeText(MainActivity.this,"Successfully logged in", Toast.LENGTH_LONG).show();
                        openNewActivity();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();

                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void openNewActivity() {
        Intent intent = new Intent(MainActivity.this, Welcome.class);
        intent.putExtra("userdata",correct_username);
        startActivity(intent);
        finish();
    }

}