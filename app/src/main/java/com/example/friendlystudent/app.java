package com.example.friendlystudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class app extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
    }
    @Override
    public void onBackPressed(){
return;
    }
}