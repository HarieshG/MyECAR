package com.hariesh.acer.mye_car;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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

public class ModeSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        CardView card1 = (CardView) findViewById(R.id.c1);
        CardView modeButton1 = (CardView) findViewById(R.id.c2);
        CardView modeButton2 = (CardView) findViewById(R.id.c3);
        CardView modeButton3 = (CardView) findViewById(R.id.c4);
        CardView modeButton4 = (CardView) findViewById(R.id.c5);
        CardView modeButton5 = (CardView) findViewById(R.id.c6);
        ImageView back = (ImageView)findViewById(R.id.backk);
        final TextView modedis = (TextView)findViewById(R.id.modedisp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toselectmode = new Intent(ModeSelect.this, MainActivity.class);
                startActivity(toselectmode);
            }
        });
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("MODE").setValue("1");
                Toast.makeText(ModeSelect.this, "Car mode changed successfully", Toast.LENGTH_SHORT).show();
            }
        });

        modeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("MODE").setValue("2");
                Toast.makeText(ModeSelect.this, "Car mode changed successfully", Toast.LENGTH_SHORT).show();
            }
        });

        modeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("MODE").setValue("3");
                Toast.makeText(ModeSelect.this, "Car mode changed successfully", Toast.LENGTH_SHORT).show();
            }
        });

        modeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("MODE").setValue("4");
                Toast.makeText(ModeSelect.this, "Car mode changed successfully", Toast.LENGTH_SHORT).show();
            }
        });

        modeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("MODE").setValue("5");
                Toast.makeText(ModeSelect.this, "Car mode changed successfully", Toast.LENGTH_SHORT).show();
            }
        });

        modeButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("MODE").setValue("6");
                Toast.makeText(ModeSelect.this, "Car mode changed successfully", Toast.LENGTH_SHORT).show();
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("MODE").getValue(String.class);
                modedis.setText("MODE "+value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
