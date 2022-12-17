package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.animation.ObjectAnimator;

public class MainActivity extends AppCompatActivity implements UserSignIn {
private FBAuthentication authentication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         authentication = new FBAuthentication(this);
       // if (authentication.isRegistered()) {
            //go to next activity
      //  }
    }

    public void openRegistrationScreen(View view) {
        Intent windowChange= new Intent(this, RegistrationPage.class);
        startActivity(windowChange);

    }

    public void signIn(View view) {
        EditText email= findViewById(R.id.emailAdress);
        EditText password= findViewById(R.id.password);

        if (!email.getText().toString().isEmpty()&&!password.getText().toString().isEmpty())
            authentication.signInUser(email.getText().toString(), password.getText().toString());
       else{
           TextView text= findViewById(R.id.textView8);
           text.setText("כתובת אימייל או סיסמה לא נכונים");
       }
       //        authentication.forgotPassword(email.getText().toString());
    }
    public void signInResult(boolean success){
        if(success){
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(this, app.class);
            startActivity(intent);
        }
        else{
            TextView text= findViewById(R.id.textView8);
            text.setText("כתובת אימייל או סיסמה לא נכונים");
        }
    }

}