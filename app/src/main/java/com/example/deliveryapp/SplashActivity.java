package com.example.deliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}



        setContentView(R.layout.activity_splash);

    }

    public void iniciar(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }

}