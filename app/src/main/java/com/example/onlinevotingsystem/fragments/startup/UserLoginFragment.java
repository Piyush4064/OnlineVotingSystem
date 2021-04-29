package com.example.onlinevotingsystem.fragments.startup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onlinevotingsystem.R;

public class UserLoginFragment extends Fragment {

    public UserLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void onConnectionResult(boolean result, String error) {
        //progressIndicatorFragment.dismiss();
        if(result){
            Navigation.findNavController(requireActivity(),R.id.navHostStartup).navigate(R.id.registerFragment);

        }
        else {
            Toast.makeText(requireActivity(),"Error in establishing connection: "+error,Toast.LENGTH_LONG).show();
            requireActivity().finish();
        }
    }
}