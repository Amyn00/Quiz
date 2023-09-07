package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText numericEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numericEditText = findViewById(R.id.numericEditText);

        numericEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Convert the entered text to a number
                try {
                    int value = Integer.parseInt(charSequence.toString());
                    // Limit the value to the range 5-120
                    if (value < 5 || value > 120) {
                        numericEditText.setError("Enter a number between 5 and 120");
                    } else {
                        numericEditText.setError(null);
                    }
                } catch (NumberFormatException e) {
                    numericEditText.setError("Invalid number");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}