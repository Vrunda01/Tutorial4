package com.rku.tutorial4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView txtWelcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtWelcomeMessage = findViewById(R.id.txtWelcomeMessage);
        Intent intent = getIntent();
        String data = intent.getStringExtra("userdata");
        txtWelcomeMessage.setText("Welcome " + data);
    }
}