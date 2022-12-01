package com.example.friendlystudent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class email extends Fragment {
    private GetName Iname;
    private String name;
    public email(RegistrationPage activity) {
        Iname=activity;
    }
    public email(){}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //RegistrationPage activity= (RegistrationPage) getActivity();
        //this.name= activity.getName();
        // TextView instructions= getActivity().findViewById(R.id.textGetEmail);
        Toast.makeText(getActivity(), ""+Iname.getName(), Toast.LENGTH_SHORT).show();
       // instructions.setText("היי "+name+", מה כתובת האימייל שלך?");

    }

}