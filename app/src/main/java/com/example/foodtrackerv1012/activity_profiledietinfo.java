package com.example.foodtrackerv1012;

import android.os.Bundle;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class activity_profiledietinfo extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiledietinfo);

        ImageView imageArrowleft = findViewById(R.id.btnOk);

        imageArrowleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_profilelogin.setCurrentdailyActivityLevel();
                activity_profilelogin.setCurrentage();
                activity_profilelogin.setCurrentgender();
                activity_profilelogin.setCurrentweight();
                activity_profilelogin.setCurrentheight();
                Intent intent = new Intent(activity_profiledietinfo.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
