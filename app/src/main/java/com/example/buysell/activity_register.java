package com.example.buysell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class activity_register extends AppCompatActivity {

    TextInputLayout F_name,F_pass,F_contact,F_city,F_user,F_email;
    Button Go_fire;
    TextView Log_ac;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        F_name = findViewById(R.id.f_name);
        F_city = findViewById(R.id.f_city);
        F_contact = findViewById(R.id.f_no);
        F_email = findViewById(R.id.f_mail);
        F_user = findViewById(R.id.f_user);
        F_pass = findViewById(R.id.f_pass);
        Go_fire = findViewById(R.id.go_fire);
        Log_ac = findViewById(R.id.log_ac);
        mAuth = FirebaseAuth.getInstance();

        Log_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register.this,activity_login.class);
                startActivity(intent);
            }
        });

        Go_fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name =F_name.getEditText().getText().toString();
                String user =F_user.getEditText().getText().toString();
                String email =F_email.getEditText().getText().toString();
                String contact =F_contact.getEditText().getText().toString();
                String  city = F_city.getEditText().getText().toString();
                String password = F_pass.getEditText().getText().toString();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(activity_register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(activity_register.this, activity_login.class);
                                String name1=F_name.getEditText().getText().toString();
                                intent.putExtra("name",name);
                                String city1=F_city.getEditText().getText().toString();
                                intent.putExtra("city",city);
                                startActivity(intent);
                            } else {
                                Toast.makeText(activity_register.this, "Failed ", Toast.LENGTH_SHORT).show();

                            }

                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity_register.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }

            });
        };


    }















