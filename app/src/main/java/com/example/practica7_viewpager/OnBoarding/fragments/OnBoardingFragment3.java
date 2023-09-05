package com.example.practica7_viewpager.OnBoarding.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica7_viewpager.R;
import com.example.practica7_viewpager.databinding.FragmentOnBoarding1Binding;
import com.example.practica7_viewpager.databinding.FragmentOnboarding2Binding;
import com.example.practica7_viewpager.databinding.FragmentOnboarding3Binding;
import com.example.practica7_viewpager.login.LoginActivity;

public class OnBoardingFragment3 extends Fragment {

    private FragmentOnboarding3Binding binding;

    public OnBoardingFragment3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOnboarding3Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
    }

    private void listeners() {
        binding.onboardingLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}