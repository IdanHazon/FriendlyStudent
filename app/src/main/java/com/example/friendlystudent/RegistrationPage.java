package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    private User user;
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

        }

    }

    private boolean validateName(View view) {
        EditText name= findViewById(R.id.editTextName);
        int nameLength=name.getText().toString().length();
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

}