package com.example.digitalegyptlenovo.movieapp;

import android.app.Application;

import com.example.digitalegyptlenovo.movieapp.dagger.component.DaggerNetworkComponent;
import com.example.digitalegyptlenovo.movieapp.dagger.component.NetworkComponent;
import com.example.digitalegyptlenovo.movieapp.dagger.module.NetModule;
import com.example.digitalegyptlenovo.movieapp.webservice.MovieDbAPiConst;

/**
 * Created by Mohamed Elshafey on 4/15/2018.
 */
public class App extends Application {

    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent.builder()
                .netModule(new NetModule(MovieDbAPiConst.BaseURL))
                .build();

    }

    public NetworkComponent getNetComponent() {
        return networkComponent;
    }
}
