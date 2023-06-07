package com.example.deliveryapp.ui.slideshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deliveryapp.MainActivity2;
import com.example.deliveryapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UserCreditAct extends AppCompatActivity {

    EditText editTextCard, editTextCvv, editTextDate;
    String M_ID;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_credit);

        editTextCard=findViewById(R.id.editTxt_Card);
        editTextCvv=findViewById(R.id.editTxt_Cvv);
        editTextDate=findViewById(R.id.editTxt_Date);

        firebaseAuth = FirebaseAuth.getInstance();
        M_ID = firebaseAuth.getCurrentUser().getUid();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("users").child(M_ID);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    if (dataSnapshot.child("card").exists())
                        editTextCard.setText(dataSnapshot.child("card").getValue().toString());
                    if (dataSnapshot.child("cvv").exists())
                        editTextCvv.setText(dataSnapshot.child("cvv").getValue().toString());
                    if (dataSnapshot.child("date").exists())
                        editTextDate.setText(dataSnapshot.child("date").getValue().toString());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        Button btnUpadte = findViewById(R.id.btn_update);
        btnUpadte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("users").child(M_ID);
                String cardReg = editTextCard.getText().toString();
                String cvvReg = editTextCvv.getText().toString();
                String DateRg = editTextDate.getText().toString();

                if (!TextUtils.isEmpty(cardReg) && !TextUtils.isEmpty(cvvReg)) {
                    HashMap<String, Object> cardMap = new HashMap<>();
                    cardMap.put("card", cardReg);
                    cardMap.put("cvv", cvvReg);
                    cardMap.put("date", DateRg);

                    readRef.updateChildren(cardMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Card updated", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getApplicationContext(), "Failed to update card. Please try again.", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter card number, CVV, and a valid date.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void regresarprofile(View view) {
        Intent intent = new Intent(UserCreditAct.this, MainActivity2.class);
        startActivity(intent);
    }

}