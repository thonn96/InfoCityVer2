package com.example.infocity.Presenter;

import android.content.Context;

import com.example.infocity.Model.Cities;
import com.example.infocity.Model.HandleDataCity;
import com.example.infocity.Model.LoadDataCityListener;
import com.example.infocity.View.MainView;

import java.util.ArrayList;

public class MainPresenter  implements LoadDataCityListener {
    private HandleDataCity handleDataCity;
    private MainView mainView;
    public MainPresenter(MainView mainView,Context context) {
        this.mainView = mainView;
        handleDataCity = new HandleDataCity(this,context);
    }

    public void loadData() {
        handleDataCity.open();
        handleDataCity.createListCityData();
    }

    public void displayOnListView(ArrayList<Cities> listCity) {
        mainView.displayMain(listCity);
    }

    @Override
    public void onLoadDataCitySuccess(ArrayList<Cities> listCity) {
        mainView.displayMain(listCity);
    }
}
