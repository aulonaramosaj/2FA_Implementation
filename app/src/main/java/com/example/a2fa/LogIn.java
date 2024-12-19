package com.example.a2fa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private String email;
    private Button loginButton;
    private Button signupButton;
    private Database db;

    @Override
    protected void onCreate(Bundle setBundle) {
        super.onCreate(setBundle);
        setContentView(R.layout.activity_login);

        db = new Database(this);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.buttonLogIn);
        signupButton = findViewById(R.id.buttonSignUp);

        loginButton.setOnClickListener(v -> {
            email = editTextEmail.getText().toString().trim();
            String userPassword = editTextPassword.getText().toString().trim();

            if (validateCredentials(email, userPassword)) {
                Toast.makeText(this, "Valid Credentials", Toast.LENGTH_SHORT).show();
                navigateToVerifyEmail();
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
        signupButton.setOnClickListener(v -> {
            Intent intent = new Intent(LogIn.this, SignUp.class);
            startActivity(intent);
            finish();
        });
    }
    public boolean validateCredentials(String email, String password) {
        return db.doesUserExist(email, password);
    }
    public void navigateToVerifyEmail() {
        Intent intent = new Intent(this, VerifyEmail.class);
        intent.putExtra("recipient", email);
        startActivity(intent);
    }

}
