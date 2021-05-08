package com.example.onlinevotingsystem.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.onlinevotingsystem.R;

public class OfficerActivity extends AppCompatActivity {

    RecyclerView featuredRecycler, voterrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_officer);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        voterrecycler = findViewById(R.id.voter_recycler);

    }

}