package com.example.cakerecipes.model;

import android.util.Log;

import com.example.cakerecipes.presenter.Presenter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.PUT;

@Module
public class NetworkConnection {
    private static final String TAG = "NetworkConnection";

    @Inject
    public NetworkConnection() {
    }

    private static NetworkConnection instance;

    public Presenter presenter;


    Callback<List<CakeDetailsPojo>> callback = new Callback<List<CakeDetailsPojo>>() {
        @Override
        public void onResponse(Call<List<CakeDetailsPojo>> call,
                               Response<List<CakeDetailsPojo>> response) {
            if(response.isSuccessful() && response.body() != null)
                presenter.networkSuccessful(response.body());
        }

        @Override
        public void onFailure(Call<List<CakeDetailsPojo>> call, Throwable t) {
            presenter.networkFailure(t.getMessage());
        }
    };

    @Provides
    @Singleton
    public static NetworkConnection getInstance() {
        if (instance == null) {
            instance = new NetworkConnection();
        }
        return instance;
    }

    public NetworkConnection getNetwork(){
        return new NetworkConnection();
    }

    public void setPresenter(Presenter presenter){
        instance.presenter = presenter;
    }


    public void initRetrofit() {
        Log.d(TAG, "initRetrofit: ");
        new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CakeApiInterface.class)
                .getCakeList()
                .enqueue(callback);
    }

}
