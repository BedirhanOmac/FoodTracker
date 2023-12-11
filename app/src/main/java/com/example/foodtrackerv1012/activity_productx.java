package com.example.foodtrackerv1012;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_productx extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productx);

        ImageView imageArrowleft = findViewById(R.id.imageArrowleft);

        imageArrowleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_productx.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
