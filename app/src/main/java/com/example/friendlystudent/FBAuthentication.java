package com.example.friendlystudent;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FBAuthentication {
    private FirebaseAuth mAuth= FirebaseAuth.getInstance();
    private RegistrationPage rg;
    public FBAuthentication(){
        rg= new RegistrationPage();
    }
    public boolean isRegistered(){
        return mAuth.getCurrentUser()!=null;
    }
public void registerUSer(String mail, String password){
    mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isComplete()){
                rg.addFifthFragment();
            }
        }
    });
}


}
