package com.hariesh.acer.mye_car;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference newRef = database.getReference();
         Button Tomode = (Button)findViewById(R.id.selectbutton);

        final TextView bat1display = findViewById(R.id.textView);
        final TextView bat2display = findViewById(R.id.textView2);
        final ImageView condition1 = findViewById(R.id.imageView5);
        final ImageView condition2 = findViewById(R.id.imageView6);

        Tomode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toselectmode = new Intent(MainActivity.this, ModeSelect.class);
                startActivity(toselectmode);
            }
        });


        newRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value1 = dataSnapshot.child("Btry1").getValue(String.class);

                if(value1.equals("") )
                    condition1.setImageResource(R.drawable.close);


                else if(value1.equals("1"))
                condition1.setImageResource(R.drawable.car);
                else if(value1.equals("0"))
                    condition1.setImageResource(R.drawable.flash);
                String value2 = dataSnapshot.child("Btry2").getValue(String.class);

                if(value2.equals("") )
                    condition2.setImageResource(R.drawable.close);
                else if(value2.equals("0"))
                    condition2.setImageResource(R.drawable.flash);
                else if(value2.equals("1"))
                    condition2.setImageResource(R.drawable.car);
            }
            @Override
            public void onCancelled(DatabaseError error) {

                Toast.makeText(MainActivity.this, "Failed to read", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
