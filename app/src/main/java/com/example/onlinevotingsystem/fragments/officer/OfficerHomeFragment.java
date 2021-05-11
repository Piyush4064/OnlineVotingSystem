package com.example.onlinevotingsystem.fragments.officer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.adapters.OfficerCandidateListAdapter;
import com.example.onlinevotingsystem.adapters.OfficerUserListAdapter;
import com.example.onlinevotingsystem.viewModels.OfficerViewModel;

import org.jetbrains.annotations.NotNull;

public class OfficerHomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_officer_home, container, false);
    }

    private OfficerViewModel officerViewModel;
    private RelativeLayout rlAddCandidate;
    private NavController navController;

    RecyclerView rcvCandidateList;
    RecyclerView rcvUserList;

    TextView tvPollAddress;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        officerViewModel=new ViewModelProvider(requireActivity()).get(OfficerViewModel.class);

        rlAddCandidate=view.findViewById(R.id.rlBtnAddCandidate);
        rcvCandidateList=view.findViewById(R.id.rcvAdminCandidateList);
        rcvUserList=view.findViewById(R.id.rcvOfficerUserList);
        tvPollAddress=view.findViewById(R.id.tvAddressOfficerWardListItem);

        navController= Navigation.findNavController(view);

        rlAddCandidate.setOnClickListener(v -> {
            navController.navigate(R.id.addCandidateFragment);
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(requireActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rcvCandidateList.setLayoutManager(linearLayoutManager);
        rcvCandidateList.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(requireActivity());
        linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);
        rcvUserList.setLayoutManager(linearLayoutManager1);
        rcvUserList.setHasFixedSize(true);

        officerViewModel.GetPollDetails().observe(getViewLifecycleOwner(),poll -> {
            if(poll!=null){
                OfficerCandidateListAdapter adapter=new OfficerCandidateListAdapter(poll.getCandidateList());
                rcvCandidateList.setAdapter(adapter);

                tvPollAddress.setText(poll.getAddress());
            }
        });

        officerViewModel.GetUserList().observe(getViewLifecycleOwner(),users -> {
            if(users!=null && users.size()!=0){
                OfficerUserListAdapter adapter=new OfficerUserListAdapter(users);
                rcvUserList.setAdapter(adapter);
            }
        });
    }
}