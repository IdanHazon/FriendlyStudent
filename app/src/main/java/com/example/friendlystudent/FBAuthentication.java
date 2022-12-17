package com.example.friendlystudent;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class FBAuthentication {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private RegisterCallback activity;
    private UserSignIn mainActivity;

    public FBAuthentication(RegistrationPage activity) {
        this.activity = activity;
    }
    public FBAuthentication(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    public boolean isRegistered() {
        return mAuth.getCurrentUser() != null;
    }

    public void registerUser(String mail, String password) {
        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // registered success
                    activity.authenticateResult(true, "");
                } else {
                    activity.authenticateResult(false, task.getException().getMessage());

                }

            }
        });
    }

    public void signInUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
                mainActivity.signInResult(true);
            }
            else{
                    mainActivity.signInResult(false);
            }
            }
        });
    }
    public void forgotPassword(String emailAddress){
        mAuth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                        }
                        else
                        {

                        }
                    }
                });
    }
}
