package com.example.emicalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


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

        //Initialize the input and buttons
        EditText mortgageAmount= findViewById(R.id.MortgageAmount);
        EditText loanTenure = findViewById(R.id.Tenure);
        EditText interestRate = findViewById(R.id.InterestRate);
        Button calculateButton = findViewById(R.id.CalculateButton);

        //set up an OnClickListener for the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the input from the EditText fields as a string
                String mortgage = mortgageAmount.getText().toString();
                String tenure = loanTenure.getText().toString();
                String interest = interestRate.getText().toString();

                //create intent
                Intent intent = new Intent(MainActivity.this, EMIResult.class);

                // Pass the input values to EMIResult
                intent.putExtra("mortgage_amount", mortgage);
                intent.putExtra("loan_tenure", tenure);
                intent.putExtra("interest_rate", interest);
                // Go to EMI Result activity
                startActivity(intent);
            }
        });
    }
}