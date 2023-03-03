package com.example.deliveryapp.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.deliveryapp.R;

public class acercadenosotrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercadenosotros);
    }

    public void insta(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/"));
        startActivity(intent);
    }

    public void fb(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/"));
        startActivity(intent);
    }

}