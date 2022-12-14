package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friendlystudent.communication.FBAuthentication;

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
        TextView text= findViewById(R.id.textView8);
        text.setText("");
        if (!email.getText().toString().isEmpty()&&!password.getText().toString().isEmpty()){
            authentication.signInUser(email.getText().toString(), password.getText().toString());

        }
    }
    public void signInResult(boolean success, String exception){
        if(success){
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(this, app.class);
            EditText email= findViewById(R.id.emailAdress);
            intent.putExtra("email",email.getText().toString());
            startActivity(intent);
        }
        else{
            TextView text= findViewById(R.id.textView8);
            text.setText(exception);
        }
    }
    public void changePasswordActivity(View view) {
        Intent intent= new Intent(this, forgotPassword.class );
        EditText email= findViewById(R.id.emailAdress);
        intent.putExtra("email",email.getText().toString());
        startActivity(intent);
    }

}