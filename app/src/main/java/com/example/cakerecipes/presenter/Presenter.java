package com.example.cakerecipes.presenter;

import com.example.cakerecipes.model.CakeDetailsPojo;
import com.example.cakerecipes.model.NetworkConnection;
import com.example.cakerecipes.view.ViewContract;

import java.util.List;

public class Presenter implements PresenterContract {

    private ViewContract view;
    private NetworkConnection network;
    private List<CakeDetailsPojo> dataSet;

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

    /**
     *
     * @return the list of cakes to the view
     */
    @Override
    public List<CakeDetailsPojo> getCakes() {
        return null;
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
