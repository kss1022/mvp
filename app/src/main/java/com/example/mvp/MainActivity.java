package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().
                findFragmentById(R.id.mainfragment_container);


        if (mainFragment == null) {
             mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add( R.id.mainfragment_container, mainFragment)
                    .commit();
        }

        new MainPresenter(mainFragment);
    }
}