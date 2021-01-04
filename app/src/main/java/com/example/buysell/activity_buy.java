package com.example.buysell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class activity_buy extends AppCompatActivity {

    private GridView gv;
    private DatabaseReference dref;
    private Spinner Sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        gv = findViewById(R.id.gv);
        Sp = findViewById(R.id.sp_city);

        dref = FirebaseDatabase.getInstance().getReference("user");
        String city = getIntent().getStringExtra("city");

        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<User> list = new ArrayList<User>();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    User p = ds.getValue(User.class);
                    list.add(p);
                }
                CustomAdapter adp = new CustomAdapter(list);
                gv.setAdapter(adp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        Sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String UserCity = String.valueOf(Sp.getItemAtPosition(i));

                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (UserCity.equalsIgnoreCase(city)) {
                            Intent intent = new Intent(activity_buy.this, activity_welldone.class);
                            startActivity(intent);
                        } else
                            Toast.makeText(activity_buy.this, "You Can't Buy Items of another CITY", Toast.LENGTH_SHORT).show();

                    }
                });
                //Toast.makeText(BuyActivity.this, "You Can Buy", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

            class CustomAdapter extends BaseAdapter {
                private final List<User> list;
                public CustomAdapter(List<User> list) {
                    this.list=list;
                }
                @Override
                public int getCount() {
                    return list.size();
                }
                @Override
                public Object getItem(int i) {
                    return list.get(i);
                }
                @Override
                public long getItemId(int i) {
                    return 0;
                }
                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {
                    View vv=getLayoutInflater().inflate(R.layout.product_item,null,false);
                    TextView title=vv.findViewById(R.id.tv1);
                    TextView dop=vv.findViewById(R.id.tv2);
                    TextView des=vv.findViewById(R.id.tv3);
                    TextView mrp=vv.findViewById(R.id.tv4);
                    TextView sp=vv.findViewById(R.id.tv5);
                    User p=list.get(i);
                    title.setText(p.getPname());
                    dop.setText(p.getPdate());
                    des.setText(p.getPdesc());
                    mrp.setText("Rs. "+p.getPmrp());
                    sp.setText("Rs. "+p.getPsell());
                    return vv;
                }

            }


}