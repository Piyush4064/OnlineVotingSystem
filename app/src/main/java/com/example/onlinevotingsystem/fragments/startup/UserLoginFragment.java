package com.example.onlinevotingsystem.fragments.startup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.activities.UserActivity;
import com.example.onlinevotingsystem.constants.HashMapConstants;
import com.example.onlinevotingsystem.database.FetchFromDatabase;
import com.example.onlinevotingsystem.utils.ProgressIndicatorFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;

public class UserLoginFragment extends Fragment implements FetchFromDatabase.FetchDbInterface {

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

    Button btnOpenRegister,btnSubmit;
    TextInputLayout inputLayoutUsername, inputLayoutPassword;
    ProgressIndicatorFragment progressIndicatorFragment;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnOpenRegister=view.findViewById(R.id.btnLoginToRegister);

        inputLayoutUsername=view.findViewById(R.id.ilUserUsername);
        inputLayoutPassword=view.findViewById(R.id.ilUserPassword);
        btnSubmit=view.findViewById(R.id.btnUserLoginSubmit);

        btnSubmit.setOnClickListener(v -> {
            String username=inputLayoutUsername.getEditText().getText().toString();
            String password=inputLayoutPassword.getEditText().getText().toString();

            Intent intent=new Intent(requireActivity(), UserActivity.class);
            startActivity(intent);
            requireActivity().finish();

        });

        btnOpenRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireActivity(),R.id.navHostStartup).navigate(R.id.registerFragment);
            }
        });
    }

    @Override
    public void onFetchCompleted(HashMap<String, Object> resultHashMap) {

    }
}