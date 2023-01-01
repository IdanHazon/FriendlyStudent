package com.example.friendlystudent.communication;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.friendlystudent.MainActivity;
import com.example.friendlystudent.RegisterCallback;
import com.example.friendlystudent.RegistrationPage;
import com.example.friendlystudent.UserSignIn;
import com.example.friendlystudent.forgotPassword;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

public class FBAuthentication {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private RegisterCallback activity;
    private UserSignIn mainActivity;
    private forgotPassword forgotPasswordActivity;

    public FBAuthentication(RegistrationPage activity) {
        this.activity = activity;
    }
    public FBAuthentication(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }
    public FBAuthentication(forgotPassword forgotPasswordActivity) {this.forgotPasswordActivity=forgotPasswordActivity;}

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
                mainActivity.signInResult(true, "");
            }
            else{
                try {
                    throw task.getException();
                } catch (FirebaseNetworkException e) {
                    mainActivity.signInResult(false, "שגיאת אינטרנט");

                } catch (FirebaseAuthInvalidUserException e) {
                    mainActivity.signInResult(false, "כתובת אימייל או סיסמה לא נכונים");
                } catch (Exception e) {
                    mainActivity.signInResult(false, "שגיאה");
                 }
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
                            forgotPasswordActivity.sendEmailResult(true, "");
                        }
                        else
                        {
                            forgotPasswordActivity.sendEmailResult(false, task.getException().toString());

                        }
                    }
                });
    }
}
