package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.deliveryapp.ui.slideshow.UserCreditAct;

public class contactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    public void regresarprofile(View view) {
        Intent intent = new Intent(contactoActivity.this, MainActivity2.class);
        startActivity(intent);
    }

}