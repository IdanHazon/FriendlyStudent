package com.example.friendlystudent;

public interface RegisterCallback {//connects between FBauthentication to the registration page
    void authenticateResult(boolean success,String data);//פעולה שמטפלת במקרה של רישום מוצלח/נכשל

}
