package com.example.friendlystudent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.friendlystudent.app_fragments.addFilesFragment;
import com.example.friendlystudent.app_fragments.chatsFragment;
import com.example.friendlystudent.app_fragments.homepageFragment;
import com.example.friendlystudent.app_fragments.searchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class app extends AppCompatActivity {
private BottomNavigationView bottomNavigationView;

private homepageFragment homepageFragment;
private chatsFragment chatsFragment;
private searchFragment searchFragment;
private addFilesFragment addFilesFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        homepageFragment=new homepageFragment();
        chatsFragment= new chatsFragment();
        searchFragment=new searchFragment();
        addFilesFragment=new addFilesFragment();
        bottomNavigationView= findViewById(R.id.navigationBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,homepageFragment).commit();
        bottomNavigationView.setSelectedItemId(R.id.homepage);
        replaceFragments();
    }
    @Override
    public void onBackPressed(){
return;
    }
    private void replaceFragments(){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,homepageFragment).commit();
                        return true;
                    case R.id.chats:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,chatsFragment).commit();
                        return true;
                    case R.id.addFiles:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,addFilesFragment).commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,searchFragment).commit();
                        return true;
                }
                return false;

            }
        });
    }
}