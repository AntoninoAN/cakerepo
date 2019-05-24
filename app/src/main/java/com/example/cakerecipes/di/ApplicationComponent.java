package com.example.cakerecipes.di;

import com.example.cakerecipes.model.NetworkConnection;
import com.example.cakerecipes.presenter.Presenter;
import com.example.cakerecipes.view.CustomAdapter;
import com.example.cakerecipes.view.CustomViewHolder;
import com.example.cakerecipes.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                NetworkConnection.class
        }
)
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
