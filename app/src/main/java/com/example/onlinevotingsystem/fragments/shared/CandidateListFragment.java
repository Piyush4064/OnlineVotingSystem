package com.example.onlinevotingsystem.fragments.shared;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.viewModels.CandidateListViewModel;

import org.jetbrains.annotations.NotNull;

public class CandidateListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_candidate_list, container, false);
    }

    private ProgressIndicatorFragment progressIndicatorFragment;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CandidateListViewModel listViewModel=new ViewModelProvider(requireActivity()).get(CandidateListViewModel.class);

        progressIndicatorFragment=ProgressIndicatorFragment.newInstance("Loading List","Fetching List of Candidates from Server");

        listViewModel.CheckIsListLoading().observe(getViewLifecycleOwner(),aBoolean -> {
            if(aBoolean){
                if(!progressIndicatorFragment.isVisible())
                    progressIndicatorFragment.show(getParentFragmentManager(),"CandidateListProgress");
            }
            else {
                if(progressIndicatorFragment.isVisible())
                    progressIndicatorFragment.dismiss();
            }
        });

        listViewModel.GetPollList().observe(getViewLifecycleOwner(),polls -> {
            Log.d("FetchCandidateList","Number Of Polls - "+polls.size());
        });
    }
}