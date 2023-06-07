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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class contactoActivity extends AppCompatActivity {
    EditText regName, regInterested, regMessage;
    Button btnCreate;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userRef = database.getReference("users");
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        regName = findViewById(R.id.editTxt_Name);
        regInterested = findViewById(R.id.editTxt_Interests);
        regMessage = findViewById(R.id.editTxt_Message);

        btnCreate = findViewById(R.id.btn_sendContact);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameC = regName.getText().toString();
                String interestedC = regInterested.getText().toString();
                String messageC = regMessage.getText().toString();

                if (!TextUtils.isEmpty(nameC) && !TextUtils.isEmpty(interestedC)) {
                    String reviewId = userRef.child(uid).child("reviews").push().getKey();

                    HashMap<String, Object> reviewMap = new HashMap<>();
                    reviewMap.put("name", nameC);
                    reviewMap.put("interested", interestedC);
                    reviewMap.put("message", messageC);

                    userRef.child(uid).child("reviews").child(reviewId).setValue(reviewMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Review added", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter name, message and interested", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void regresarprofile(View view) {
        Intent intent = new Intent(contactoActivity.this, MainActivity2.class);
        startActivity(intent);
    }

}