package com.example.deliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deliveryapp.ui.slideshow.UserCreditAct;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class contactoActivity extends AppCompatActivity {
    EditText name, interested, message;
    String M_ID;
    FirebaseAuth firebaseAuth;

    ContactRegisterModel newContact = new ContactRegisterModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        firebaseAuth = FirebaseAuth.getInstance();
        M_ID = firebaseAuth.getCurrentUser().getUid();
        Toast.makeText(this, "<"+M_ID+">", Toast.LENGTH_SHORT).show();

        name = findViewById(R.id.editTxt_Name);
        interested = findViewById(R.id.editTxt_Interests);
        message = findViewById(R.id.editTxt_Message);

        Button saveBtn = findViewById(R.id.btn_sendContact);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Contact");
                try {
                    if (TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(interested.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter interested", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(message.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter message", Toast.LENGTH_SHORT).show();
                    else {
                    newContact.setName(name.getText().toString());
                    newContact.setInterested(interested.getText().toString());
                    newContact.setMessage(message.getText().toString());

                        Log.d("Firebase", "Attempting to add data to Firebase");
                        dbRef.child(M_ID).setValue(newContact)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d("Firebase", "Data added successfully");
                                    Toast.makeText(contactoActivity.this, "Feedback Added...", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(contactoActivity.this, MainActivity2.class));
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.e("Firebase", "Error adding data to Firebase: " + e.getMessage());
                                    Toast.makeText(contactoActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    }
                } catch(NumberFormatException e) {
                    Log.e("Firebase", "Error: " + e.toString());
                    Toast.makeText(getApplicationContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void regresarprofile(View view) {
        Intent intent = new Intent(contactoActivity.this, MainActivity2.class);
        startActivity(intent);
    }

}