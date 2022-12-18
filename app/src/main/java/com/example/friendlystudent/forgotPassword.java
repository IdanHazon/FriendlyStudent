package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;

public class forgotPassword extends AppCompatActivity implements SentEmail {
private LottieAnimationView animationView;
private FBAuthentication authentication;
private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        authentication= new FBAuthentication(this);
        Intent intent = getIntent();
        email= intent.getStringExtra("email");
        EditText emailEditText = findViewById(R.id.emailEditText);
        emailEditText.setText(email);
        sendEmail();
    }
    public void sendEmail(){
        animationView = findViewById(R.id.animation);
        animationView.setVisibility(View.VISIBLE);
        animationView.playAnimation();
    }

    @Override
    public void sendEmailResult(boolean success) {
        if (success){}
        else{}

    }
}