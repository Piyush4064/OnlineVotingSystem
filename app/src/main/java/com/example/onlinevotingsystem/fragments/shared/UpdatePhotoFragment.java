package com.example.onlinevotingsystem.fragments.shared;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.constants.HashMapConstants;
import com.example.onlinevotingsystem.database.DatabaseUpdater;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class UpdatePhotoFragment extends Fragment implements DatabaseUpdater.DatabaseUpdateInterface {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_photo, container, false);
    }

    private String role, photoUrl, id;
    private ProgressIndicatorFragment progressIndicatorFragment;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        role="Admin";
        photoUrl="photo";
        id="testAdmin";

    }

    private void updatePhoto(){
        HashMap<String,Object> hashMap=new HashMap<>();
        switch (role){
            case "Admin":{
                hashMap.put(HashMapConstants.UPDATE_TYPE_KEY,HashMapConstants.UPDATE_TYPE_ADMIN_PHOTO);
                hashMap.put(HashMapConstants.UPDATE_PARAM_ADMIN_PHOTO_USERNAME_KEY,id);
                hashMap.put(HashMapConstants.UPDATE_PARAM_ADMIN_PHOTO_KEY,photoUrl);

                progressIndicatorFragment=ProgressIndicatorFragment.newInstance("Syncing","Updating Admin Photo");
                progressIndicatorFragment.show(getParentFragmentManager(),"AdminPhoto");
                new DatabaseUpdater(hashMap,this).execute();
                break;
            }
            case "Officer":{
                hashMap.put(HashMapConstants.UPDATE_TYPE_KEY,HashMapConstants.UPDATE_TYPE_OFFICER_PHOTO);
                hashMap.put(HashMapConstants.UPDATE_PARAM_OFFICER_PHOTO_USERNAME_KEY,id);
                hashMap.put(HashMapConstants.UPDATE_PARAM_OFFICER_PHOTO_KEY,photoUrl);

                progressIndicatorFragment=ProgressIndicatorFragment.newInstance("Syncing","Updating Officer Photo");
                progressIndicatorFragment.show(getParentFragmentManager(),"OfficerPhoto");
                new DatabaseUpdater(hashMap,this).execute();
                break;
            }
            case "Voter":{
                hashMap.put(HashMapConstants.UPDATE_TYPE_KEY,HashMapConstants.UPDATE_TYPE_VOTER_PHOTO);
                hashMap.put(HashMapConstants.UPDATE_PARAM_VOTER_PHOTO_ID_KEY,id);
                hashMap.put(HashMapConstants.UPDATE_PARAM_VOTER_PHOTO_KEY,photoUrl);

                progressIndicatorFragment=ProgressIndicatorFragment.newInstance("Syncing","Updating Voter Photo");
                progressIndicatorFragment.show(getParentFragmentManager(),"VoterPhoto");
                new DatabaseUpdater(hashMap,this).execute();
                break;
            }
        }
    }

    @Override
    public void onDataUpdated(String type, boolean result, String error) {
        switch (type){
            case HashMapConstants.UPDATE_TYPE_ADMIN_PHOTO:{
                progressIndicatorFragment.dismiss();
                if(result){
                    Toast.makeText(requireActivity(),"Photo Updated Successfully for Admin",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(requireActivity(),"Error in Updating Photo",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case HashMapConstants.UPDATE_TYPE_OFFICER_PHOTO:{
                progressIndicatorFragment.dismiss();
                if(result){
                    Toast.makeText(requireActivity(),"Photo Updated Successfully for Officer",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(requireActivity(),"Error in Updating Photo",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case HashMapConstants.UPDATE_TYPE_VOTER_PHOTO:{
                progressIndicatorFragment.dismiss();
                if(result){
                    Toast.makeText(requireActivity(),"Photo Updated Successfully for Voter",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(requireActivity(),"Error in Updating Photo",Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}