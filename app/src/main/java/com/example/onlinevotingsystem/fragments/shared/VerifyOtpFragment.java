package com.example.onlinevotingsystem.fragments.shared;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinevotingsystem.R;

import org.jetbrains.annotations.NotNull;

public class VerifyOtpFragment extends DialogFragment {

    public VerifyOtpFragment() {
        // Required empty public constructor
    }

    public static VerifyOtpFragment newInstance(String phoneNum) {
        VerifyOtpFragment fragment = new VerifyOtpFragment();
        Bundle args = new Bundle();
        args.putString("PhoneNum",phoneNum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            PhoneNum=getArguments().getString("PhoneNum");
        }
    }

    String PhoneNum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify_otp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}