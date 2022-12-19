package com.example.friendlystudent.communication;

import androidx.annotation.NonNull;

import com.example.friendlystudent.RegisterCompleteFrag;
import com.example.friendlystudent.RegistrationPage;
import com.example.friendlystudent.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DB {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    RegisterCompleteFrag activity;
    public DB(RegistrationPage activity){
        this.activity=activity;
    }

    public void addUser(User user){
        db.collection("Users").document(""+user.getEmail()).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    activity.addRegisterCompleteFrag();
                }
                else{

                }
            }
        });
    }
}
