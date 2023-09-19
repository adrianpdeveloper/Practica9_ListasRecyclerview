package com.example.practica7_viewpager.home.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica7_viewpager.R;
import com.example.practica7_viewpager.databinding.FragmentHome2Binding;
import com.example.practica7_viewpager.databinding.FragmentHomeBinding;
import com.example.practica7_viewpager.databinding.FragmentOnboarding2Binding;
import com.example.practica7_viewpager.home.HomeActivity;

public class HomeFragment2 extends Fragment {


    HomeActivity homeActivity;
    private int position;
    private FragmentHome2Binding binding;
    public HomeFragment2() {
        // Required empty public constructor
    }

    //Recoje la posicion proporcionada de HomePageAdapter
    public static HomeFragment2 newInstance(int position) {

        Bundle args = new Bundle();

        HomeFragment2 fragment = new HomeFragment2();
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position", 0);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHome2Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Muestra la posicion
        binding.fragment2Tv.setText("Fragment: "+position);
    }

}