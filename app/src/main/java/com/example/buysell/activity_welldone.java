package com.example.buysell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_welldone extends AppCompatActivity {

    private Button Home_ic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welldone);
        Home_ic = findViewById(R.id.home_ig);


        Home_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_welldone.this,activity_home.class);
                startActivity(intent);
            }
        });
    }
}