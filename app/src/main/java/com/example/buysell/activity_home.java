package com.example.buysell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class activity_home extends AppCompatActivity {

    private ImageView Buy_ic,Sell_ic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Buy_ic = findViewById(R.id.buy_ig);
        Sell_ic = findViewById(R.id.sell_ig);
        String city = getIntent().getStringExtra("city");

        Buy_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity_home.this, activity_buy.class);
                intent.putExtra("city",city);
                startActivity(intent);

            }
        });

        Sell_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity_home.this,activity_sell.class);
                startActivity(intent);
            }
        });
    }
}