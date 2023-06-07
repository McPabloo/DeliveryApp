package com.example.deliveryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity  {
    EditText username, email, phone, password;
    Button btn;

    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(RegisterActivity.this, MainActivity2.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_register);

        username = findViewById(R.id.editText);
        email = findViewById(R.id.editTextz3);
        phone = findViewById(R.id.editTextz2);
        password = findViewById(R.id.editTextz);
        btn = findViewById(R.id.btn_splash2);
        mAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email, Password, Phone, Username;
                Email = String.valueOf(email.getText());
                Password = String.valueOf(password.getText());
                Username = String.valueOf(username.getText());
                Phone = String.valueOf(phone.getText());


                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(RegisterActivity.this, "Ingresa el email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    Toast.makeText(RegisterActivity.this, "Ingresa el password", Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.createUserWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Obtener el usuario registrado
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    String userEmail = user.getEmail();
                                    // Guardar el email en Realtime Database
                                    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("users");
                                    databaseRef.child(user.getUid()).child("email").setValue(userEmail);
                                    databaseRef.child(user.getUid()).child("address").setValue(Phone);
                                    // Continuar con el flujo de la aplicación
                                    Toast.makeText(RegisterActivity.this, "Authentication succeeded", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, MainActivity2.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Si ocurre un error al registrar, muestra un mensaje al usuario
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });

    }

    public void vlogin(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }

    public void registrarme(View v) {

        Context context = getApplicationContext();

        String text = getString(R.string.inicioregistro);

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);

        toast.show();
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}