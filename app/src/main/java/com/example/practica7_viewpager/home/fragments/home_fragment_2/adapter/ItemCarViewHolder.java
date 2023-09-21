package com.example.practica7_viewpager.home.fragments.home_fragment_2.adapter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica7_viewpager.databinding.ItemCarListBinding;
import com.example.practica7_viewpager.domain.Car;
import com.example.practica7_viewpager.home.fragments.home_fragment_2.HomeFragment2;

public class ItemCarViewHolder extends RecyclerView.ViewHolder {
    private ItemCarListBinding binding;

    public ItemCarViewHolder(@NonNull ItemCarListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bind(Car itemCar){
        binding.itemLayoutListcarName.setText(itemCar.getNameCar());
        binding.itemLayoutListcarPrice.setText("$"+itemCar.getPriceCar()+"/day");
        binding.itemLayoutListcarBackground.setBackgroundColor(ContextCompat.getColor(itemView.getContext(),itemCar.getColorResCar()));
        binding.itemLayoutListcarImg.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(),itemCar.getImgResCar()));

        binding.itemCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.e("Adrian", "El coche seleccionado es: "+itemCar.getNameCar());
                Toast.makeText(itemView.getContext(), "Has pulsado en "+itemCar.getNameCar(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
