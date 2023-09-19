package com.example.practica7_viewpager.OnBoarding.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica7_viewpager.OnBoarding.viewpager.PageAdapter;
import com.example.practica7_viewpager.R;
import com.example.practica7_viewpager.databinding.FragmentOnBoarding1Binding;
import com.example.practica7_viewpager.OnBoarding.fragments.ContentFragment;
import com.example.practica7_viewpager.home.HomeActivity;
import com.example.practica7_viewpager.login.LoginActivity;

public class OnBoardingFragment1 extends Fragment {
    private FragmentOnBoarding1Binding binding;
    public OnBoardingFragment1() {
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
        binding = FragmentOnBoarding1Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
    }

    private void listeners() {
        binding.onboardingNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Utiliza el metodo de la activity implementado en ContentFragment
                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity(intent);
                /*if (getActivity() instanceof ContentFragment.ViewPagerChangeListener) {
                    ((ContentFragment.ViewPagerChangeListener) getActivity()).changeViewPagerPosition(1); // Cambia al fragmento deseado
                }*/

            }
        });
    }
}