package com.example.onlinevotingsystem.fragments.admin;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.adapters.OfficerListAdapter;
import com.example.onlinevotingsystem.adapters.OfficerUserListAdapter;
import com.example.onlinevotingsystem.viewModels.AdminViewModel;
import com.example.onlinevotingsystem.viewModels.OfficerViewModel;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import org.jetbrains.annotations.NotNull;

public class AdminHomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_home, container, false);
    }

    Button btnAddAdmin, btnAddPoll, btnUpdateElectionTime, btnViewPollList, btnAddOfficer, btnAddUser, btnChangePassword, btnUpdatePhoto;
    NavController navController;

    RecyclerView rcvOfficerList, rcvUsersList;
    CircleMenu circleMenu;

    AdminViewModel adminViewModel;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //menu animation
        circleMenu=view.findViewById(R.id.cmUserHome);
        navController= Navigation.findNavController(view);

        circleMenu.setMainMenu(Color.parseColor("#ff8a5c"),R.drawable.menu,R.drawable.cancel)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.adminhome_new_admin)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.adminhome_new_poll)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.adminhome_update_time)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.adminhome_poll_list)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.adminhome_new_officer)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.adminhome_new_voter)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.adminhome_change_password)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.adminhome_update_photo)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        switch (index){

                            case 0:
                                Toast.makeText(requireActivity(),"Add a New Admin", Toast.LENGTH_SHORT).show();
                                navController.navigate(R.id.voteFragment);

//                                constraintLayout.setBackgroundColor(Color.parseColor("#ecfffb"));

                                break;

                            case 1:
                                Toast.makeText(requireActivity(),"Add a New Poll", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#96f7d2"));
                                break;

                            case 2:
                                Toast.makeText(requireActivity(),"Update Election Time", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fac4a2"));
                                break;

                            case 3:
                                Toast.makeText(requireActivity(),"List of Polls", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#d3cde6"));
                                break;

                            case 4:
                                Toast.makeText(requireActivity(),"Add a New Officer", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fff591"));
                                break;

                            case 5:
                                Toast.makeText(requireActivity(),"Add a New Voter", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fff591"));
                                break;

                            case 6:
                                Toast.makeText(requireActivity(),"Change Password", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fff591"));
                                break;

                            case 7:
                                Toast.makeText(requireActivity(),"Update Photo", Toast.LENGTH_SHORT).show();
//                                constraintLayout.setBackgroundColor(Color.parseColor("#fff591"));
                                break;
                        }

                    }
                });

        adminViewModel=new ViewModelProvider(requireActivity()).get(AdminViewModel.class);

        navController=Navigation.findNavController(view);

        btnAddAdmin=view.findViewById(R.id.btnNavigateToAddAdmin);
        btnAddPoll=view.findViewById(R.id.btnNavigateToAddPoll);
        btnUpdateElectionTime=view.findViewById(R.id.btnUpdateElectionTimeOfPoll);
        btnViewPollList=view.findViewById(R.id.btnAdminViewPollList);
        btnAddOfficer=view.findViewById(R.id.btnAdminAddOfficer);
        btnAddUser=view.findViewById(R.id.btnAdminAddUser);
        btnChangePassword=view.findViewById(R.id.btnAdminChangePassword);
        btnUpdatePhoto=view.findViewById(R.id.btnAdminUpdatePhoto);
        rcvOfficerList=view.findViewById(R.id.rcvAdminOfficerList);
        rcvUsersList=view.findViewById(R.id.rcvAdminUsersList);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(requireActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rcvOfficerList.setLayoutManager(linearLayoutManager);
        rcvOfficerList.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(requireActivity());
        linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);
        rcvUsersList.setLayoutManager(linearLayoutManager1);
        rcvUsersList.setHasFixedSize(true);

        adminViewModel.GetOfficersList().observe(getViewLifecycleOwner(),officers -> {
            if(officers!=null){
                OfficerListAdapter adapter=new OfficerListAdapter(officers);
                rcvOfficerList.setAdapter(adapter);
            }
        });

        adminViewModel.GetUserList().observe(getViewLifecycleOwner(),users -> {
            if(users!=null){
                OfficerUserListAdapter adapter=new OfficerUserListAdapter(users);
                rcvUsersList.setAdapter(adapter);
            }
        });

        btnAddAdmin.setOnClickListener(v -> {
            NavDirections action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAddAdminFragment();
            navController.navigate(action);
        });

        btnAddPoll.setOnClickListener(v -> {
            NavDirections action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAddPollFragment();
            navController.navigate(action);
        });

        btnUpdateElectionTime.setOnClickListener(v -> {
           NavDirections action=AdminHomeFragmentDirections.actionAdminHomeFragmentToUpdateElectionTimeFragment();
           navController.navigate(action);
        });

        btnViewPollList.setOnClickListener(v -> {
            NavDirections action=AdminHomeFragmentDirections.actionAdminHomeFragmentToPollListFragment();
            navController.navigate(action);
        });

        btnAddOfficer.setOnClickListener(v -> {
            NavDirections action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAddOfficerFragment();
            navController.navigate(action);
        });

        btnAddUser.setOnClickListener(v -> {
            NavDirections action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAddUserFragment();
            navController.navigate(action);
        });

        btnChangePassword.setOnClickListener(v -> {
            NavDirections action=AdminHomeFragmentDirections.actionAdminHomeFragmentToChangePasswordFragment("Admin",adminViewModel.GetUsername());
            navController.navigate(action);
        });

        btnUpdatePhoto.setOnClickListener(v -> {
            String currentPhoto="null";
            if(adminViewModel.GetPhotoUrl()!=null)
                currentPhoto=adminViewModel.GetPhotoUrl();
            NavDirections action=AdminHomeFragmentDirections.actionAdminHomeFragmentToUpdatePhotoFragment("Admin",adminViewModel.GetUsername(),currentPhoto);
            navController.navigate(action);
        });
    }

}