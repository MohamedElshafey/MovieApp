package com.example.digitalegyptlenovo.movieapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.digitalegyptlenovo.movieapp.App;
import com.example.digitalegyptlenovo.movieapp.R;
import com.example.digitalegyptlenovo.movieapp.databinding.ActivityHomeBinding;
import com.example.digitalegyptlenovo.movieapp.viewmodel.HomeViewModel;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;

    HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((App) getApplication()).getNetComponent().inject(HomeActivity.this);

        super.onCreate(savedInstanceState);

        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        if (retrofit != null)
            homeViewModel = new HomeViewModel(this, binding, retrofit);

    }

    @Override
    protected void onDestroy() {
        if (homeViewModel != null)
            homeViewModel.dispose();

        super.onDestroy();
    }
}
