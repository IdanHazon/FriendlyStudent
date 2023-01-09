package com.example.friendlystudent.communication;

import android.util.Log;

import androidx.annotation.NonNull;
import com.example.friendlystudent.RegisterCompleteFrag;
import com.example.friendlystudent.RegistrationPage;
import com.example.friendlystudent.User;
import com.example.friendlystudent.UserData;
import com.example.friendlystudent.app;
import com.example.friendlystudent.app_fragments.homepageFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class DB {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    RegisterCompleteFrag activity;
    UserData activity1;
    public DB(RegistrationPage activity){
        this.activity=activity;
    }
    public DB(app activity1){
        this.activity1=activity1;
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
    public void getUserDataByEmail(String email){
        DocumentReference docRef = db.collection("Users").document(email);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        activity1.userDataResult(document.toObject(User.class),true,"");
                    } else {
                        activity1.userDataResult(null,false,"no user");
                    }
                } else {
                    activity1.userDataResult(null,false,task.getException().toString());
                }
            }
        });
    }
}
