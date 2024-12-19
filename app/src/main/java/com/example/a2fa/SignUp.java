package com.example.a2fa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button signUpButton, alreadyHaveAccountButton;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        db = new Database(this);


        emailEditText = findViewById(R.id.emailsignup);
        passwordEditText = findViewById(R.id.passwordsignup);
        signUpButton = findViewById(R.id.buttonSignUp);
        alreadyHaveAccountButton = findViewById(R.id.buttonAlreadyAccount);


        signUpButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (validateInput(email, password)) {
                db.insert(email, password);
                Toast.makeText(this, "Success! Account created.", Toast.LENGTH_SHORT).show();
                navigateToLogIn();
            } else {
                Toast.makeText(this, "Email and Password cannot be empty.", Toast.LENGTH_SHORT).show();
            }
        });


        alreadyHaveAccountButton.setOnClickListener(v -> {
            navigateToLogIn();
        });
    }


    private boolean validateInput(String email, String password) {
        return !email.isEmpty() && !password.isEmpty();
    }


    private void navigateToLogIn() {
        Intent intent = new Intent(SignUp.this, LogIn.class);
        startActivity(intent);
        finish();
    }
}
