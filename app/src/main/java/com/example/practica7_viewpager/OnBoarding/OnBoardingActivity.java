package com.example.practica7_viewpager.OnBoarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.practica7_viewpager.OnBoarding.fragments.ContentFragment;
import com.example.practica7_viewpager.R;

public class OnBoardingActivity extends AppCompatActivity implements ContentFragment.ViewPagerChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
    }



    @Override
    //Metodo para navegar entre fragments
    public void changeViewPagerPosition(int position) {
        ViewPager2 viewPager2 = findViewById(R.id.content_vp2);
        viewPager2.setCurrentItem(position);
    }
}