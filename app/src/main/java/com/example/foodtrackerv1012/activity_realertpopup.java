package com.example.foodtrackerv1012;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_realertpopup extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realalertpopup);

         TextView close = findViewById(R.id.txtGroupSeven);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_realertpopup.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
