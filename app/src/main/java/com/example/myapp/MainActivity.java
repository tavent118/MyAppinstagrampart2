package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapp.fragments.ComposeFragment;
import com.example.myapp.fragments.PostsFragment;
import com.example.myapp.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";


    private BottomNavigationView buttonNavigationView;

   // private ParseUser parseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager= getSupportFragmentManager();


        buttonNavigationView = findViewById(R.id.bottomNavigation);

        buttonNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment ;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        fragment =new PostsFragment();
                     //   Toast.makeText(MainActivity.this,"Home!",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.action_compose:
                        fragment =new ComposeFragment();
                     //   Toast.makeText(MainActivity.this,"Compose!",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                    default:
                        fragment =new ProfileFragment();
                      //  Toast.makeText(MainActivity.this,"Profile!",Toast.LENGTH_SHORT).show();
                        break;
                    }
                fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();
                   return  true;
                }

           });
             //set default selection
             buttonNavigationView.setSelectedItemId(R.id.action_home);
        }

    }
