package com.example.cakerecipes.presenter;

import com.example.cakerecipes.model.CakeDetailsPojo;
import com.example.cakerecipes.view.ViewContract;

import java.util.List;

public interface PresenterContract {
    void bind(ViewContract view);
    void unBind();
    void initNetworkConnection();
    void networkSuccessful(List<CakeDetailsPojo> dataSet);
    void networkFailure(String message);
}
