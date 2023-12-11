package com.example.foodtrackerv1012;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_samplecamera extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samplecamera);

        ImageView butongreen = findViewById(R.id.btnCheckmark);

        butongreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_samplecamera.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView butonred = findViewById(R.id.btnClose);

        butonred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_samplecamera.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
