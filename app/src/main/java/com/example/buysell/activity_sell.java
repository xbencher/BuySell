package com.example.buysell;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_sell extends AppCompatActivity {

    TextInputLayout P_name,P_date,P_sell,P_desc,P_mrp;
    Button P_submit;
    private DatabaseReference dref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        P_name = findViewById(R.id.p_name);
        P_date = findViewById(R.id.p_date);
        P_desc = findViewById(R.id.p_description);
        P_mrp = findViewById(R.id.p_mrp);
        P_sell = findViewById(R.id.p_sell);
        P_submit = findViewById(R.id.p_submit);
        dref = FirebaseDatabase.getInstance().getReference("user");

        P_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               final String pname = P_name.getEditText().getText().toString();
                final  String pdate = P_date.getEditText().getText().toString();
                final String pdesc = P_desc.getEditText().getText().toString();
                final  String pmrp = P_mrp.getEditText().getText().toString();
                final  String psell = P_sell.getEditText().getText().toString();

                User p = new User(pname,pdate,pdesc,pmrp,psell);
                dref.push().setValue(p);
                Toast.makeText(activity_sell.this, "Record Saved", Toast.LENGTH_SHORT).show();



            }
        });


    }


}