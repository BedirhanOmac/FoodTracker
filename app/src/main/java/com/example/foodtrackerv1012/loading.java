package com.example.foodtrackerv1012;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class loading extends AppCompatActivity {

        private EditText allergensEditText;
        private EditText unwantedIngredientsEditText;
        private Button continueButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            allergensEditText = findViewById(R.id.editTextText2);
            unwantedIngredientsEditText = findViewById(R.id.editTextText3);
            continueButton = findViewById(R.id.button2);

            continueButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    onContinueButtonClick();
                }
            });
        }

        private void onContinueButtonClick() {


            String allergens = allergensEditText.getText().toString();
            String unwantedIngredients = unwantedIngredientsEditText.getText().toString();

            // For now, let's just display a toast message
            String message = "Allergens: " + allergens + "\nUnwanted Ingredients: " + unwantedIngredients;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MyProductsActivity.class);

            // Pass data to the intent using extras
            intent.putExtra("ALLERGENS_KEY", allergens);
            intent.putExtra("UNWANTED_INGREDIENTS_KEY", unwantedIngredients);

            // Start the activity with the intent
            startActivity(intent);
        }
    }


