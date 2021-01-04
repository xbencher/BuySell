package com.example.buysell;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class activity_two extends AppCompatActivity {
private Spinner sp;
private String Ucity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        sp = findViewById(R.id.spinner);


        String Usercity = getIntent().getStringExtra("city") ;
       sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(activity_two.this, "City "+sp.getItemAtPosition(i),
                       Toast.LENGTH_SHORT).show();

               Ucity = String.valueOf(sp.getItemAtPosition(i));
               if(Ucity.equalsIgnoreCase(Usercity))
               {

                   Toast.makeText(activity_two.this, "You Can Buy Same hai teri", Toast.LENGTH_SHORT).show();
               }
               else{

                   Toast.makeText(activity_two.this, "You can not buy same nhi hai ", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

    }
}