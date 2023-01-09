package com.example.friendlystudent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.friendlystudent.app_fragments.addFilesFragment;
import com.example.friendlystudent.app_fragments.chatsFragment;
import com.example.friendlystudent.app_fragments.homepageFragment;
import com.example.friendlystudent.app_fragments.searchFragment;
import com.example.friendlystudent.communication.DB;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class app extends AppCompatActivity implements UserData {
private BottomNavigationView bottomNavigationView;
private homepageFragment homepageFragment;
private chatsFragment chatsFragment;
private searchFragment searchFragment;
private addFilesFragment addFilesFragment;
    private DB database=new DB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        chatsFragment= new chatsFragment();
        searchFragment=new searchFragment();
        addFilesFragment=new addFilesFragment();
        bottomNavigationView= findViewById(R.id.navigationBar);
        replaceFragments();

        database.getUserDataByEmail(getIntent().getStringExtra("email"));
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

    @Override
    public void userDataResult(User data, Boolean success, String exception) {
        if (success){
            findViewById(R.id.loadingGif).setVisibility(View.GONE);//loading animation gone
            findViewById(R.id.loadingText).setVisibility(View.GONE);
            findViewById(R.id.frameLayout).setVisibility(View.VISIBLE);//show the elements
            bottomNavigationView.setVisibility(View.VISIBLE);//show the navigation bar

            homepageFragment=new homepageFragment(data);//create homepage fragment with the user data
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,homepageFragment).commit();
            bottomNavigationView.setSelectedItemId(R.id.homepage);
        }
        else
            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();

    }
}
