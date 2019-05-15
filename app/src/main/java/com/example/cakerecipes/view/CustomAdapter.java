package com.example.cakerecipes.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cakerecipes.R;
import com.example.cakerecipes.model.CakeDetailsPojo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    //todo we need the dataset
    List<CakeDetailsPojo> dataset;
    LayoutInflater layoutInflater;

//    public CustomAdapter (LayoutInflater layoutInflater){
//        this.layoutInflater = layoutInflater;
//    }
//
//    public CustomAdapter (Context context){
//        this.context = context;
//    }

    public void setDataset(List<CakeDetailsPojo> data){
        this.dataset = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(
                LayoutInflater
        .from(viewGroup.getContext()).inflate(
                        R.layout.item_layout,
                        viewGroup,
                        false
                ));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.textView.setText(
                dataset.get(i).title
        );
        Picasso.get()
                .load(dataset.get(i).image)
                .into(customViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataset != null ? dataset.size() : 0;
    }
}
