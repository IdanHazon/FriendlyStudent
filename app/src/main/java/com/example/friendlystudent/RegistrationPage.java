package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity implements RegisterCallback, GetNameTextView, RegisterCompleteFrag {

    private FBAuthentication FB; // handle the authentication
    private FragmentManager fragmentManager;//replace between registration fragments
    private boolean allowBack;//defines if the user can press the 'Back' button
    private User user;// creating the user for the firebase
    private email emailFrag;//reference to the email fragment class
    private DB db;// firebase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        FB=new FBAuthentication(this);
         fragmentManager = getSupportFragmentManager();
         allowBack=true;
         user=new User();
         emailFrag= new email(this);
         db= new DB(this);
    }
    public void addNameFragment(View view)
    {

        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, name.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }

    public void addEmailFragment(View view)
    {
        EditText name= findViewById(R.id.editTextName);
        int nameLength=name.getText().toString().length();
        if (validName(nameLength)){//returns if the input is valid
            user.setName(name.getText().toString());
            fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, emailFrag, null)
            .setReorderingAllowed(true)
            .addToBackStack("email")
            .commit();
        }

    }

    private boolean validName(int nameLength) {//Checks if the input (username) is at least 2 characters long
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
    public void addPasswordFragment(View view){
        EditText eMail= findViewById(R.id.editEmail);
        String mail= eMail.getText().toString();
        if (validEmail(mail)) {

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, password.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("password")
                    .commit();
            user.setEmail(mail);
        }
        else{
            TextView alert= findViewById(R.id.alertEmail);
            alert.setText("כתובת אימייל לא תקינה");

        }
    }

    public  boolean validEmail(String mail) {
        return  (!mail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(mail).matches());
    }

    public void addLoadingScreenFragment(View view){
        EditText editPassword= findViewById(R.id.editPassword);
        String password= editPassword.getText().toString();
        if (validPassword(password)) {//if password valid
            addToFirebase(password);
            allowBack=false;
        }
        else{
            TextView alert= findViewById(R.id.alertPass);
            alert.setText("סיסמה לא תקינה");
        }
    }

    private void addToFirebase(String password) {
        FB.registerUser(user.getEmail(), password);
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, loading_screen.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("loading_screen")
                .commit();
    }


    public  boolean validPassword(String pass) {
        return (pass.length()>6 && pass.length()<20);
    }

public String getName(){
        return user.getName();
}

    @Override
    public TextView getTextView() {
        return findViewById(R.id.textGetEmail);
    }

    public void addRegisterCompleteFrag() {//called after the user information is uploaded to the firebase
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, registerComplete.class, null)
                .setReorderingAllowed(true)
                .commit();
    }

    @Override
    public void authenticateResult(boolean success,String message) {
        if (success){
            db.addUser(user);
        }
    else{
            allowBack=true;
            fragmentManager.popBackStack("email", 0);
            alertUser(message);
          }
    }

    private void alertUser(String message) {
        TextView alert= findViewById(R.id.alertEmail);
       // if (message.equals("The email address is badly formatted."))
           // alert.setText("כתובת אימייל לא תקינה");
      //  if (message.equals("The email address is already in use by another account."))
          //  alert.setText("כתובת אימייל תפוסה");
        Toast.makeText(this, "שגיאה", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed(){
        if (allowBack)
            super.onBackPressed();
    }
}