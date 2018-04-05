package com.example.digitalegyptlenovo.movieapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.digitalegyptlenovo.movieapp.R;
import com.example.digitalegyptlenovo.movieapp.databinding.ActivityHomeBinding;
import com.example.digitalegyptlenovo.movieapp.viewmodel.HomeViewModel;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
    }
}
