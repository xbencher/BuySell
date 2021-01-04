package com.example.buysell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_one extends AppCompatActivity {

    private EditText Et1;
    private Button Bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Et1 = findViewById(R.id.et1);
        Bt1 = findViewById(R.id.bt1);


        Bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = Et1.getText().toString();

                Intent intent = new Intent(activity_one.this,activity_two.class);

                intent.putExtra("city",city);

                startActivity(intent);
            }
        });
    }
}