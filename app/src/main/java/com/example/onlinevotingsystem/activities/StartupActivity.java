package com.example.onlinevotingsystem.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.viewModels.StartupViewModel;

public class StartupActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        StartupViewModel viewModel=new ViewModelProvider(this).get(StartupViewModel.class);

    }

}