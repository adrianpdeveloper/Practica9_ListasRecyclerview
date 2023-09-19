package com.example.practica7_viewpager.home.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica7_viewpager.databinding.FragmentHome4Binding;
import com.example.practica7_viewpager.home.HomeActivity;

public class HomeFragment4 extends Fragment {

    HomeActivity homeActivity;
    private FragmentHome4Binding binding;
    private int position;
    public HomeFragment4() {
        // Required empty public constructor
    }
    public static HomeFragment4 newInstance(int position) {

        Bundle args = new Bundle();

        HomeFragment4 fragment = new HomeFragment4();
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
        binding = FragmentHome4Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.fragment4Tv.setText("Fragment: "+position);
    }

}