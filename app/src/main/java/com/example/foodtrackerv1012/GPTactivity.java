package com.example.foodtrackerv1012;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GPTactivity extends AppCompatActivity {
    public TextView generateArea;
    static final String apiKey = "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";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietprogram);

        Intent intent = getIntent();
        generateArea = findViewById(R.id.textGenerated);
        generateArea.setText("PLEASE WAIT, YOUR PLAN IS BEING GENERATED...");

        String promptText = intent.getStringExtra("PROMPT");
        new GPTAsyncTask().execute(apiKey, promptText);

        Log.d("GPTactivity", "Received prompt: " + promptText);
    }

    private class GPTAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String apiKey = params[0];
            String promptText = params[1];

            try {
                URL url = new URL("https://api.openai.com/v1/chat/completions");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                // Set request method and headers
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("Authorization", "Bearer " + apiKey);
                urlConnection.setDoOutput(true);

                // Create the JSON payload
                String jsonInputString = "{\n" +
                        "  \"model\": \"gpt-3.5-turbo\",\n" +
                        "  \"messages\": [\n" +
                        "    {\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},\n" +
                        "    {\"role\": \"user\", \"content\": \"" + promptText + "\"}\n" +
                        "  ],\n" +
                        "  \"temperature\": 0.7,\n" +
                        "  \"max_tokens\": 150\n" +
                        "}";

                // Write JSON payload to the request
                try (OutputStream os = urlConnection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                // Get the API response
                try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    return response.toString();
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            // Update the TextView with the API response
            generateArea.setText(result);
        }
    }
}
