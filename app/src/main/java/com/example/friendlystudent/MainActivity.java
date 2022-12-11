package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // FBAuthentication authentication = new FBAuthentication();
       // if (authentication.isRegistered()) {
            //go to next activity
      //  }
    }

    public void openRegistrationScreen(View view) {
        Intent windowChange= new Intent(this, RegistrationPage.class);
        startActivity(windowChange);
    }

    public void signIn(View view) {

    }

}