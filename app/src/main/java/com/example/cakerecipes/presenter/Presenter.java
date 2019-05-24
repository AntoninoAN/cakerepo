package com.example.cakerecipes.presenter;

import com.example.cakerecipes.model.CakeDetailsPojo;
import com.example.cakerecipes.model.NetworkConnection;
import com.example.cakerecipes.view.ViewContract;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Module;
import dagger.Provides;


public class Presenter implements PresenterContract {

    private ViewContract view;
//    @Inject
    private NetworkConnection network;

    private List<CakeDetailsPojo> dataSet;

    @Inject
    public Presenter(NetworkConnection network){
        this.network = network;
//        network.setPresenter(this);
    }


//    @Provides
//    public Presenter initPresenter(){
//        return new Presenter();
//    }

    @Override
    public void bind(ViewContract view) {
        this.view = view;
        network = NetworkConnection.getInstance();
    }

    @Override
    public void unBind() {
        view = null;
        dataSet = null;
        network = null;
    }

    @Override
    public void initNetworkConnection() {
        network.setPresenter(this);
        network.initRetrofit();
    }

    @Override
    public void networkSuccessful(List<CakeDetailsPojo> dataSet) {
        view.getCakeList(dataSet);
    }

    @Override
    public void networkFailure(String message) {
        view.onError(message);
    }
}
