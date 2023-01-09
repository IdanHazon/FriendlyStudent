package com.example.friendlystudent;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.Map;

public interface UserData {
    void userDataResult(User data, Boolean success, String exception);
}
