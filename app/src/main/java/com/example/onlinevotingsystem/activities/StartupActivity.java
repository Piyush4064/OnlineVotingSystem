package com.example.onlinevotingsystem.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.database.ConnectionEstablisher;
import com.example.onlinevotingsystem.firebase.SendOtpToMobile;
import com.example.onlinevotingsystem.utils.ProgressIndicatorFragment;
import com.google.android.material.snackbar.Snackbar;

public class StartupActivity extends AppCompatActivity implements
        ConnectionEstablisher.ConnectionInterface{

    private ProgressIndicatorFragment progressIndicatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        progressIndicatorFragment=ProgressIndicatorFragment.newInstance("Connecting","Establishing Connection");
        progressIndicatorFragment.show(getSupportFragmentManager(),"ConnectionProgress");
        new ConnectionEstablisher(this).execute();
    }

    @Override
    public void onConnectionResult(boolean result, String error) {
        progressIndicatorFragment.dismiss();
        String resultStr;
        if(result)
            resultStr="Connection Successful";
        else
            resultStr="Error in Establishing Connection! "+error;
        Snackbar.make(getWindow().getDecorView().getRootView(),resultStr,2500).show();
    }
}