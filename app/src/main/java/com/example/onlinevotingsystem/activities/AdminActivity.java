package com.example.onlinevotingsystem.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.fragments.shared.ProgressIndicatorFragment;
import com.example.onlinevotingsystem.viewModels.AdminViewModel;

public class AdminActivity extends AppCompatActivity {

    ProgressIndicatorFragment progressIndicatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        AdminViewModel adminViewModel=new ViewModelProvider(this).get(AdminViewModel.class);

        progressIndicatorFragment=ProgressIndicatorFragment.newInstance("Syncing with Server","Updating the Database");

        adminViewModel.CheckIsProcessPerformed().observe(this,aBoolean -> {
            if(aBoolean){
                if(!progressIndicatorFragment.isVisible())
                    progressIndicatorFragment.show(getSupportFragmentManager(),"DbProcess");
            }
            else {
                if(progressIndicatorFragment.isVisible())
                    progressIndicatorFragment.dismiss();
            }
        });
    }
}