package com.example.deliveryapp.ui.slideshow;

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

import com.example.deliveryapp.MainActivity2;
import com.example.deliveryapp.Producto;
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

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userRef = database.getReference("users");
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    private void obtenerData() {
        userRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                CreditModel creditModel = dataSnapshot.getValue(CreditModel.class);
                if (creditModel != null) {
                    String card = creditModel.getCard();
                    String cvv = creditModel.getCvv();
                    String date = creditModel.getDate();

                    editTextCard.setText(card);
                    editTextCvv.setText(cvv);
                    editTextDate.setText(date);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Firebase", "Error al obtener los datos: " + databaseError.getMessage());
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_credit);

        editTextCard = findViewById(R.id.editTxt_Card);
        editTextCvv = findViewById(R.id.editTxt_Cvv);
        editTextDate = findViewById(R.id.editTxt_Date);

        Button btnUpdate = findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String card = editTextCard.getText().toString();
                String cvv = editTextCvv.getText().toString();
                String date = editTextDate.getText().toString();

                if (!TextUtils.isEmpty(card) && !TextUtils.isEmpty(cvv)) {
                    HashMap<String, Object> cardMap = new HashMap<>();
                    cardMap.put("card", card);
                    cardMap.put("cvv", cvv);
                    cardMap.put("date", date);

                    userRef.child(uid).updateChildren(cardMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Card added", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter name, message and interested", Toast.LENGTH_SHORT).show();
                }
            }
        });
        obtenerData();
    }

    public void regresarprofile(View view) {
        Intent intent = new Intent(UserCreditAct.this, MainActivity2.class);
        startActivity(intent);
    }

}