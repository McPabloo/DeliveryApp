package com.example.deliveryapp.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.deliveryapp.MainActivity2;
import com.example.deliveryapp.R;
import com.example.deliveryapp.contactoActivity;

public class userProfileAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }


    public void regresarprofile(View view) {
        Intent intent = new Intent(userProfileAct.this, MainActivity2.class);
        startActivity(intent);
    }

    public void contactanos(View view) {
        Intent intent = new Intent(userProfileAct.this, contactoActivity.class);
        startActivity(intent);
    }

    public void ajustes(View view) {
        Intent intent = new Intent(userProfileAct.this, ajustesActivity.class);
        startActivity(intent);
    }

    public void pago(View view) {
        Intent intent = new Intent(userProfileAct.this, UserCreditAct.class);
        startActivity(intent);
    }

}