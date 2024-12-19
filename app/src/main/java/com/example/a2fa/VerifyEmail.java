package com.example.a2fa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyEmail extends AppCompatActivity {
    private EditText inputOtpCode;
    private Button validateButton, resendButton, extraButton;
    String recipient;

    @Override
    protected void onCreate(Bundle setBundle){
        super.onCreate(setBundle);
        setContentView(R.layout.activity_verify_email);
        inputOtpCode = findViewById(R.id.inputOtp);
        validateButton = findViewById(R.id.validateOtp);
        resendButton = findViewById(R.id.resendButton);
        extraButton = findViewById(R.id.extraButton);


        String recipient = getIntent().getStringExtra("recipient");
        String Otp = generateOtp();
        MailSender.sendOtp(recipient, "Your OTP Code", Otp);
        validateButton.setOnClickListener(v->{
            String userOtp = inputOtpCode.getText().toString();
            if(userOtp.equals( Otp)){
                Toast.makeText(this, "Success",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });
        resendButton.setOnClickListener(v->{
            Intent intent = new Intent(this,VerifyEmail.class);
            intent.putExtra("recipient",recipient);
            startActivity(intent);

        });
        extraButton.setOnClickListener(v -> {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
        });

    }
    public String generateOtp(){
        int Otp = (int)(Math.random()*1000000);
        return String.valueOf(Otp);
    }
}
