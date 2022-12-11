package com.example.friendlystudent;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class FBAuthentication {
    private FirebaseAuth mAuth= FirebaseAuth.getInstance();
    private RegisterCallback activity;

    public FBAuthentication(RegistrationPage activity){
        this.activity=activity;
    }
    public boolean isRegistered(){
        return mAuth.getCurrentUser()!=null;
    }
public void registerUSer(String mail, String password){
    mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful())
            {
                // registered success
                activity.authenticateResult(true,"");
            }
            else
            {
                activity.authenticateResult(false,task.getException().getMessage());

            }

        }
    });
}


}
