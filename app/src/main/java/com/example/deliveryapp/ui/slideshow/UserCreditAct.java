package com.example.deliveryapp.ui.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.deliveryapp.MainActivity2;
import com.example.deliveryapp.R;

public class UserCreditAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_credit);
    }

    public void regresarprofile(View view) {
        Intent intent = new Intent(UserCreditAct.this, MainActivity2.class);
        startActivity(intent);
    }

}