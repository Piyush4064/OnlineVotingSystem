package com.example.onlinevotingsystem.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.drm.DrmStore;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.onlinevotingsystem.R;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class UserActivity extends AppCompatActivity {

    CircleMenu circleMenu;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        circleMenu = findViewById(R.id.circle_menu);
        constraintLayout = findViewById(R.id.constraint_layout);


//        //loadout1
//        circleMenu.setMainMenu(Color.parseColor("#fece2f"),R.drawable.menu,R.drawable.cancel)
//                .addSubMenu(Color.parseColor("#fece2f"),R.drawable.vote1)
//                .addSubMenu(Color.parseColor("#fece2f"),R.drawable.update_profile1)
//                .addSubMenu(Color.parseColor("#fece2f"),R.drawable.result1)
//                .addSubMenu(Color.parseColor("#fece2f"),R.drawable.candidates1)
//                .addSubMenu(Color.parseColor("#fece2f"),R.drawable.complain1)
//                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
//                    @Override
//                    public void onMenuSelected(int index) {
//
//                        switch (index){
//
//                            case 0:
//                                Toast.makeText(UserActivity.this,"home", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#ecfffb"));
//
//                                break;
//
//                            case 1:
//                                Toast.makeText(UserActivity.this,"hasas", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#96f7d2"));
//                                break;
//
//                            case 2:
//                                Toast.makeText(UserActivity.this,"hdfdf", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fac4a2"));
//                                break;
//
//                            case 3:
//                                Toast.makeText(UserActivity.this,"dfdfdfdf", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fece2f"));
//                                break;
//
//                            case 4:
//                                Toast.makeText(UserActivity.this,"dfdfdfdxsxf", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fece2f"));
//                                break;
//                        }


       //Loadout2
       circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.menu,R.drawable.cancel)
                .addSubMenu(Color.parseColor("#88bef5"),R.drawable.vote1)
                .addSubMenu(Color.parseColor("#83e85a"),R.drawable.update_profile1)
                .addSubMenu(Color.parseColor("#FF4B32"),R.drawable.result1)
                .addSubMenu(Color.parseColor("#ba53de"),R.drawable.candidates1)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.complain1)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        switch (index){

                            case 0:
                                Toast.makeText(UserActivity.this,"home", Toast.LENGTH_SHORT).show();

                                constraintLayout.setBackgroundColor(Color.parseColor("#ecfffb"));

                                break;

                            case 1:
                                Toast.makeText(UserActivity.this,"hasas", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#96f7d2"));
                                break;

                            case 2:
                                Toast.makeText(UserActivity.this,"hdfdf", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#fac4a2"));
                                break;

                            case 3:
                                Toast.makeText(UserActivity.this,"dfdfdfdf", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#d3cde6"));
                                break;

                            case 4:
                                Toast.makeText(UserActivity.this,"dfdfdfdxsxf", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#fff591"));
                                break;
                        }

                    }
                });

    }
}