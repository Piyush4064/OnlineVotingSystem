package com.example.onlinevotingsystem.fragments.user;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.activities.UserActivity;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import org.jetbrains.annotations.NotNull;

public class UserHomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_home, container, false);
    }

    CircleMenu circleMenu;
    NavController navController;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        circleMenu=view.findViewById(R.id.cmUserHome);
        navController= Navigation.findNavController(view);

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
                                Toast.makeText(requireActivity(),"Vote Fragment", Toast.LENGTH_SHORT).show();
                                navController.navigate(R.id.voteFragment);

//                                constraintLayout.setBackgroundColor(Color.parseColor("#ecfffb"));

                                break;

                            case 1:
                                Toast.makeText(requireActivity(),"hasas", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#96f7d2"));
                                break;

                            case 2:
                                Toast.makeText(requireActivity(),"hdfdf", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fac4a2"));
                                break;

                            case 3:
                                Toast.makeText(requireActivity(),"dfdfdfdf", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#d3cde6"));
                                break;

                            case 4:
                                Toast.makeText(requireActivity(),"dfdfdfdxsxf", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fff591"));
                                break;
                        }

                    }
                });
    }
}