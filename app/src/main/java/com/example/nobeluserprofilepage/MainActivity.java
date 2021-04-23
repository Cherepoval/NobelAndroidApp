package com.example.nobeluserprofilepage;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private int selectedAvatar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_projects, R.id.nav_resources, R.id.nav_settings)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        getAvatarView().setImageResource(selectedAvatar);
    }

    public void avatarClick (View view){
        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);
        ImageView image4 = findViewById(R.id.image4);
        ImageView image5 = findViewById(R.id.image5);
        image1.setVisibility(View.VISIBLE);
        image2.setVisibility(View.VISIBLE);
        image3.setVisibility(View.VISIBLE);
        image4.setVisibility(View.VISIBLE);
        image5.setVisibility(View.VISIBLE);
    }

    public ImageView getAvatarView(){
        return findViewById(R.id.profileHeaderImage);
    }


    public void image1Click (View view){
        selectedAvatar = R.drawable.avatar1;
        getAvatarView().setImageResource(selectedAvatar);
        displayToast();
    }

    public void image2Click (View view){
        selectedAvatar = R.drawable.avatar2;
        getAvatarView().setImageResource(selectedAvatar);
        displayToast();
    }

     public void image3Click (View view){
        selectedAvatar = R.drawable.avatar3;
        getAvatarView().setImageResource(selectedAvatar);
        displayToast();
    }

    public void image4Click (View view){
        selectedAvatar = R.drawable.avatar4;
        getAvatarView().setImageResource(selectedAvatar);
        displayToast();
    }

    public void image5Click (View view){
        selectedAvatar = R.drawable.avatar5;
        getAvatarView().setImageResource(selectedAvatar);
        displayToast();
    }

    public void displayToast(){
        Toast.makeText(getApplicationContext(),"Change with success !",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}