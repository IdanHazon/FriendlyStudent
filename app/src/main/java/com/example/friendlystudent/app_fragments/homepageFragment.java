package com.example.friendlystudent.app_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friendlystudent.R;
import com.example.friendlystudent.User;
import com.example.friendlystudent.UserData;
import com.example.friendlystudent.app;
import com.example.friendlystudent.communication.DB;
import com.google.firebase.firestore.DocumentSnapshot;


public class homepageFragment extends Fragment{
private User user;
    public homepageFragment() {
        // Required empty public constructor
    }
    public homepageFragment(User user) {
        this.user=user;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.fragment_home_page, container, false);
         return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateData();

    }
public void updateData(){
        TextView username= (TextView) getView().findViewById(R.id.userNameDisplay);
        TextView friendlyPoints= (TextView) getView().findViewById(R.id.friendlyPointsCounter);
        TextView content= (TextView) getView().findViewById(R.id.contentCounter);
        username.setText(user.getName().toString());
        friendlyPoints.setText(""+user.getFriendlyPoints());
        content.setText(""+user.getContentCounter());

}

}
