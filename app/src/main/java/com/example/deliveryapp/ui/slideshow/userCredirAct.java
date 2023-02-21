package com.example.deliveryapp.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.deliveryapp.MainActivity2;
import com.example.deliveryapp.R;

public class userCredirAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }


    public void regresarprof(View view) {
        Intent intent = new Intent(userCredirAct.this, MainActivity2.class);
        startActivity(intent);
    }

}