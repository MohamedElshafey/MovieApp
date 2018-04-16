package com.example.digitalegyptlenovo.movieapp.dagger.component;

import com.example.digitalegyptlenovo.movieapp.dagger.module.NetModule;
import com.example.digitalegyptlenovo.movieapp.view.HomeActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mohamed Elshafey on 4/15/2018.
 */
@Singleton

@Component(modules = {NetModule.class})
public interface NetworkComponent {
    void inject(HomeActivity activity);
}
