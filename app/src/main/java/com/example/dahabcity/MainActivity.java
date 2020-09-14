package com.example.dahabcity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import com.example.dahabcity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
public static DataBase data;
    //private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // object from DataBase class to access methods
        data = new DataBase(getApplicationContext());
        // ViewPager Adapter object
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),this);
        //initializing viewPager and set adapter
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);
    }
}