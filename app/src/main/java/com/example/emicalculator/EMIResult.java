package com.example.emicalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EMIResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emi_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialize components
        TextView calculation = findViewById(R.id.Result);
        Button backButton = findViewById(R.id.BackButton);

        //Get the intent from the activity before and get its input data
        double mortgage = Double.parseDouble(getIntent().getStringExtra("mortgage_amount"));
        double interest = Double.parseDouble(getIntent().getStringExtra("interest_rate")) / 12 / 100;
        int months = Integer.parseInt(getIntent().getStringExtra("loan_tenure"));

        //EMI calculation
        double emi = (mortgage * interest * Math.pow(1 + interest, months)) / (Math.pow(1 + interest, months) - 1);

        // Display calculation
        calculation.setText(String.format("$ %.2f", emi));

        //Go back home
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(EMIResult.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}