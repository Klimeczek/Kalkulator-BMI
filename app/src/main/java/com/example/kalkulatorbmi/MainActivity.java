package com.example.kalkulatorbmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight;
    private EditText etHeight;
    private Button btnCalculate;
    private TextView tvResult;
    private TextView tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
        tvCategory = findViewById(R.id.tvCategory);

        btnCalculate.setOnClickListener(v -> calculateBmi());
    }

    public void calculateBmi() {
        String weightStr = etWeight.getText().toString().trim();
        String heightStr = etHeight.getText().toString().trim();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Wypełnij oba pola", Toast.LENGTH_SHORT);
            return;
        }

        double weight;
        double heightCm;

        try {
            weight = Double.parseDouble(weightStr);
            heightCm = Double.parseDouble(heightStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Wprowadź poprawne liczby", Toast.LENGTH_SHORT).show();
            return;
        }

        if (weight <= 0 || heightCm <= 0) {
            Toast.makeText(this, "Waga i wzrost muszą być większe od zera", Toast.LENGTH_SHORT).show();
            return;
        }

        double heightM = heightCm / 100.0;

        double bmi = weight / (heightM * heightM);

        String bmiFormatted = String.format("%.1f", bmi);
        tvResult.setText("BMI: " + bmiFormatted);

        String category;
        if (bmi < 18.5) {
            category = "Niedowaga";
        } else if (bmi < 25.0) {
            category = "Norma";
        } else {
            category = "Nadwaga";
        }

        tvCategory.setText(category);
    }
}