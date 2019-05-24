package com.example.cakerecipes.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cakerecipes.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Module;
import dagger.Provides;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.cakeImage)
    public ImageView imageView;
    @BindView(R.id.cakeTitle)
    public TextView textView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
