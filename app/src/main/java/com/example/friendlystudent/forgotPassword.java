package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.friendlystudent.communication.FBAuthentication;

public class forgotPassword extends AppCompatActivity implements SentEmail {
private LottieAnimationView animationView;//get loading animation
private FBAuthentication authentication;// access to forgotPassword
private String email;
private EditText emailEditText;
private ImageView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        authentication= new FBAuthentication(this);
       emailEditText= findViewById(R.id.emailEditText);
       button= findViewById(R.id.imageView7);

        setTextInEditText();
    }
    public void setTextInEditText(){
        Intent intent = getIntent();
        email= intent.getStringExtra("email");
        emailEditText.setText(email);
    }
    public void sendEmail(View view){
        button.setClickable(false);
        animationView = findViewById(R.id.animation);
        animationView.setVisibility(View.VISIBLE);
        animationView.playAnimation();//starts loading animation
        email=emailEditText.getText().toString();//gets user input
        authentication.forgotPassword(email);//sends the email to the user
    }

    @Override
    public void sendEmailResult(boolean success, String exception) {
        TextView textView= findViewById(R.id.textView11);
        animationView.loop(false);


        if (success){
            textView.setText("הודעה נשלחה לכתובת האימייל");
        }
        else{
            button.setClickable(true);
            textView.setText("כתובת אימייל שגויה");
            }

        }

    public void moveToMainActivity(View view) {
        onBackPressed();
    }
}