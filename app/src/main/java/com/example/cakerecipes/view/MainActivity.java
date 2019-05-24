package com.example.cakerecipes.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.cakerecipes.R;
import com.example.cakerecipes.di.CustomApp;
import com.example.cakerecipes.model.CakeDetailsPojo;
import com.example.cakerecipes.presenter.Presenter;

import java.lang.ref.WeakReference;
import java.util.List;


import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewContract {

    @Inject
    public Presenter presenter;
    private CustomAdapter adapter;
    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((CustomApp)getApplicationContext()).getComponent().inject(this);

        //todo bind the recyclerview and adapter
//        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(
                this,
                2
                ));

        bindPresenter();

    }

    @Override
    public void populateCakeList() {
        presenter.initNetworkConnection();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this,
                message,
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void bindPresenter() {
//        presenter = new Presenter();
        presenter.bind(this);
        populateCakeList();
    }

    @Override
    public void getCakeList(List<CakeDetailsPojo> dataSet) {
        //todo send data set to adapter.
        recyclerView.setAdapter(adapter);
        adapter.setDataset(dataSet);
    }
}
