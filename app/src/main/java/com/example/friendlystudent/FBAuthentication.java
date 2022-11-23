package com.example.friendlystudent;

import com.google.firebase.auth.FirebaseAuth;

public class FBAuthentication {
    private FirebaseAuth mAuth= FirebaseAuth.getInstance();

    public boolean isRegistered(){
        return mAuth.getCurrentUser()!=null;
    }
public void registerUSer(String mail, String password){

}


}
