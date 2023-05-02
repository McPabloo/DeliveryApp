package com.example.deliveryapp.ui.slideshow;

import android.content.Intent;
import android.content.res.Configuration;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.deliveryapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class ajustesActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener{

    private GestureLibrary libreria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        libreria = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if(!libreria.load()) {
            finish();
        }

        GestureOverlayView gestureView = findViewById(R.id.gtr);
        gestureView.addOnGesturePerformedListener(this);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = libreria.recognize(gesture);
        if(predictions.size() > 0 && predictions.get(0).score>1.0){
            String action = predictions.get(0).name;
            if(action.equals("Cambio")){
                //Intent intent = new Intent();
                //intent.setComponent( new ComponentName("com.android.settings","com.android.settings.Settings$LanguageAndInputSettingsActivity" ));
                //startActivity(intent);

                String languageToLoad  = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_ajustes);

                super.onRestart();

                Toast.makeText(this, "Locale English !", Toast.LENGTH_LONG).show();
            }else if(action.equals("insta")){
                Intent explorar = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
                this.startActivity(explorar);
                Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show();
            }
            else if(action.equals("espanol")){
                String languageToLoad  = "es"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_ajustes);

                super.onRestart();

                Toast.makeText(this, "Locale Español !", Toast.LENGTH_LONG).show();
            }

        }
    }
}