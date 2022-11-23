package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
    }
    public void addFirstFragment(View view)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, name.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("start")
                .commit();
    }

    public void addSecondFragment(View view)
    {

        boolean validate = validateName(view);
        if (validate){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, email.class, null)
            .setReorderingAllowed(true)
            .addToBackStack("name")
            .commit();
            TextView c= (TextView) findViewById(R.id.);
            String m= c.getText().toString();
            Toast.makeText(this, ""+m, Toast.LENGTH_SHORT).show();
        }

    }

    private boolean validateName(View view) {
        EditText name= findViewById(R.id.editTextName);
        int nameLength=name.getText().toString().length();
        if (nameLength<2 || nameLength>8){
            TextView alert= findViewById(R.id.alert);
            alert.setText("שם משתמש קצר/ארוך מידי");
            return false;
        }
            return true;
    }

}