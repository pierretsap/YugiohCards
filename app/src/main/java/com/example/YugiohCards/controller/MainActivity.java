package com.example.YugiohCards.controller;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.YugiohCards.R;
import com.example.YugiohCards.fragment.GridFragment;
import com.example.YugiohCards.fragment.MyListFragment;
import com.example.YugiohCards.fragment.VisitedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private final MyListFragment mListFragment = new MyListFragment();
    private final GridFragment mGridFragment = new GridFragment();
    private final VisitedFragment mVisitedFragment = new VisitedFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    Fragment active = mListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm.beginTransaction().add(R.id.fragment_container, mVisitedFragment, null).commit();
        fm.beginTransaction().add(R.id.fragment_container, mGridFragment, null).commit();
        fm.beginTransaction().add(R.id.fragment_container, mListFragment, null).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationBar);
        bottomNavigation.setOnNavigationItemSelectedListener(onBottomNaviationListener);
    }



    // element to create navigation switcher
    private final BottomNavigationView.OnNavigationItemSelectedListener onBottomNaviationListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    if(active != mListFragment) {
                        fm.beginTransaction().show(mListFragment).commit();
                    }
                    else {
                        fm.beginTransaction().hide(active).show(mListFragment).commit();
                    }
                    active = mListFragment;
                    break;
                case R.id.menu_grid:
                    if(active != mGridFragment) {
                        fm.beginTransaction().hide(active).show(mGridFragment).commit();
                        active = mGridFragment;
                    }
                    break;
                case R.id.menu_visited:
                    if(active != mVisitedFragment) {
                        fm.beginTransaction().hide(active).show(mVisitedFragment).commit();
                        active = mVisitedFragment;
                    }
                    break;
            }
            return true;
        }
    };

}