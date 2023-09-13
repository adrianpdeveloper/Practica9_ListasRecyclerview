package com.example.practica7_viewpager.home;

import static com.example.practica7_viewpager.Constants.*;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.practica7_viewpager.OnBoarding.viewpager.PageAdapter;
import com.example.practica7_viewpager.R;
import com.example.practica7_viewpager.databinding.ActivityHomeBinding;
import com.example.practica7_viewpager.home.fragments.HomeFragment;
import com.example.practica7_viewpager.home.viewpager.HomePageAdapter;
import com.example.practica7_viewpager.model.User;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private String name;
    private User user;
    private String password;

    private Bundle bundle;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getNameAndPass();
        //inflateFragment();
        viewPager();
        listeners();
    }

    private void viewPager() {
        HomePageAdapter adapter = new HomePageAdapter(this);
        viewPager2 = binding.homeVp2;
        viewPager2.setAdapter(adapter);
        tabLayout = binding.homeTablayout;


        //Configura tabs
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setIcon(R.drawable.baseline_camera_alt_black_24dp);
                    tab.view.setBackground(ContextCompat.getDrawable(this, R.drawable.blue_tab_background));

                    break;
                case 1:
                    tab.setIcon(R.drawable.baseline_directions_car_white_24dp);
                    tab.view.setBackground(ContextCompat.getDrawable(this, R.drawable.purple_tab_background));
                    break;
                case 2:
                    tab.setIcon(R.drawable.baseline_terrain_black_24dp);
                    tab.view.setBackground(ContextCompat.getDrawable(this, R.drawable.pink_tab_background));
                    break;
                case 3:
                    tab.setIcon(R.drawable.baseline_face_black_24dp);
                    tab.view.setBackground(ContextCompat.getDrawable(this, R.drawable.yellow_tab_background));
                    break;
            }

            //Cambia color de tab según la seleccion
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    tab.getIcon().setTint(ContextCompat.getColor(getApplicationContext(),R.color.white));
                }
                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    tab.getIcon().setTint(ContextCompat.getColor(getApplicationContext(),R.color.black));
                }
                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
        }).attach();

    }

    private void listeners() {
        HomePageAdapter adapter = new HomePageAdapter(this);
        binding.mainActivityToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_coche){
                    Log.i("Fragment","PULSADO");
                    //Genera fragment RentCar de HomeFragment1
                    homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("f0");
                    if (homeFragment!=null){
                        Log.i("Fragment","NO NULO");
                        homeFragment.fragmentRentCar();
                    }
                }
                if (item.getItemId() == R.id.menu_disney){
                    String url = "https://www.disneylandparis.com/";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    private void getNameAndPass() {
        try {
            bundle = new Bundle();
            bundle = getIntent().getExtras().getBundle(KEY_USER_BUNDLE);
            user = bundle.getParcelable(KEY_USER);
            if (user!=null){
                name = user.getUsername();
                password = user.getPassword();
                Log.i("Nombre","Nombre: "+name);
                Log.i("Pass","Contraseña: "+password);
            }else {
                Log.e("NULO","NULO");
            }


        }catch (Exception e){
            Log.i("Mensaje", "No hay password ni contraseña");
        }

    }
    /*private void inflateFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.homefragmentFrame.getId(), new HomeFragment())
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }*/

}