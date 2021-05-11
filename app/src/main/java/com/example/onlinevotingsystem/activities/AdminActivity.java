package com.example.onlinevotingsystem.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.fragments.shared.ProgressIndicatorFragment;
import com.example.onlinevotingsystem.viewModels.AdminViewModel;
import com.google.android.material.appbar.MaterialToolbar;

public class AdminActivity extends AppCompatActivity {

    ProgressIndicatorFragment progressIndicatorFragment;
    MaterialToolbar toolbar;

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        AdminViewModel adminViewModel=new ViewModelProvider(this).get(AdminViewModel.class);

        toolbar=findViewById(R.id.toolbarAdmin);
        navController= Navigation.findNavController(this,R.id.navHostAdmin);

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

        toolbar.setOnMenuItemClickListener(item -> {

            if(item==toolbar.getMenu().findItem(R.id.menuAdminLogout)){
                Intent intent=new Intent(this,StartupActivity.class);
                startActivity(intent);
                this.finish();
            }

            return false;
        });
    }
}