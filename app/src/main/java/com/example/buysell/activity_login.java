package com.example.buysell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_login extends AppCompatActivity {

    TextInputLayout Log_user,Log_pass,Log_city;
    Button Signin;
    TextView Signup;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log_user = findViewById(R.id.log_user);
        Log_pass = findViewById(R.id.log_pass);
        Signin = findViewById(R.id.sign_in);
        Signup = findViewById(R.id.sign_up);
        mAuth = FirebaseAuth.getInstance();
        Log_city = findViewById(R.id.log_city);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Log_user.getEditText().getText().toString();
                String password = Log_pass.getEditText().getText().toString();
                String city = Log_city.getEditText().getText().toString();


                mAuth.signInWithEmailAndPassword(user, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(activity_login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(activity_login.this, activity_home.class);
                                intent.putExtra("city",city);

                                startActivity(intent);
                            } else {
                                Toast.makeText(activity_login.this, "Failed ", Toast.LENGTH_SHORT).show();

                            }

                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity_login.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this,activity_register.class);
                startActivity(intent);
            }
        });


    }
}