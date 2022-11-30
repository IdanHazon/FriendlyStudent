package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationPage extends AppCompatActivity implements RegisterCallback{

    private FBAuthentication FB;
    private FragmentManager fragmentManager;
    private boolean allowBack;

    private String name;
    private String email;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        FB=new FBAuthentication(this);
         fragmentManager = getSupportFragmentManager();
         allowBack=true;
    }
    public void addFirstFragment(View view)
    {

        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, name.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }

    public void addSecondFragment(View view)
    {

        EditText name= findViewById(R.id.editTextName);
        int nameLength=name.getText().toString().length();
        if (validName(nameLength)){
            this.name=name.getText().toString();

            fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, email.class, null)
            .setReorderingAllowed(true)
            .addToBackStack("email")
            .commit();
        }

    }

    private boolean validName(int nameLength) {
        TextView alert= findViewById(R.id.alert);

        if (nameLength<2){
            alert.setText("שם משתמש קצר מדי");
            return false;
        }
        if (nameLength>8){
            alert.setText("שם משתמש ארוך מדי");
            return false;
        }
        return true;
    }
    public void addThirdFragment(View view){
        EditText eMail= findViewById(R.id.editEmail);
        String mail= eMail.getText().toString();
        if (validEmail(mail)) {

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, password.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("password")
                    .commit();
            this.email = mail;
        }
        else{
            TextView alert= findViewById(R.id.alertEmail);
            alert.setText("כתובת אימייל לא תקינה");

        }
    }

    public  boolean validEmail(String mail) {
        return  (!mail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(mail).matches());
    }

    public void addFourthFragment(View view){
        EditText editPassword= findViewById(R.id.editPassword);
        String password= editPassword.getText().toString();
        if (validPassword(password)) {
            this.password=password;
            FB.registerUSer(this.email,this.password);
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, loading_screen.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("loading_screen")
                    .commit();
            allowBack=false;
        }
        else{
            TextView alert= findViewById(R.id.alertPass);
            alert.setText("סיסמה לא תקינה");
        }
    }


    public  boolean validPassword(String pass) {
        return (pass.length()>6 && pass.length()<20);
    }
public String getName(){
        return name;
}

    public void addFifthFragment() {

        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, registerComplete.class, null)
                .setReorderingAllowed(true)
                .commit();
    }

    @Override
    public void authenticateResult(boolean success,String message) {
        if (success)
        addFifthFragment();
    else{
            allowBack=true;
            fragmentManager.popBackStack("email", 0);
            alertUser(message);
          }
    }

    private void alertUser(String message) {
        TextView alert= findViewById(R.id.alertEmail);
        if (message.equals("The email address is badly formatted."))
            alert.setText("כתובת אימייל לא תקינה");
        if (message.equals("The email address is already in use by another account."))
            alert.setText("כתובת אימייל תפוסה");

    }

    @Override
    public void onBackPressed(){
        if (allowBack)
            super.onBackPressed();
    }
}