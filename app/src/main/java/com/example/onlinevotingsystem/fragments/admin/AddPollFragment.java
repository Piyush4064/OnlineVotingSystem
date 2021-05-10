package com.example.onlinevotingsystem.fragments.admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.constants.HashMapConstants;
import com.example.onlinevotingsystem.database.DatabaseUpdater;
import com.example.onlinevotingsystem.fragments.shared.ProgressIndicatorFragment;
import com.example.onlinevotingsystem.utils.DateTimeUtils;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.HashMap;

public class AddPollFragment extends Fragment implements DatabaseUpdater.DatabaseUpdateInterface {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_poll, container, false);
    }

    TextInputLayout ilAddress;
    TextView tvElectionStartTime, tvElectionEndTime;
    Button btnSetElectionStartTime, btnSetElectionEndTime, btnAddPoll;

    long electionStartTime, electionEndTime;

    private ProgressIndicatorFragment progressIndicatorFragment;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ilAddress=view.findViewById(R.id.ilAddPollAddress);
        tvElectionStartTime=view.findViewById(R.id.tvAddPollElectionStartTime);
        tvElectionEndTime=view.findViewById(R.id.tvAddPollElectionEndTime);

        btnSetElectionStartTime=view.findViewById(R.id.btnSetElectionStartTime);
        btnSetElectionEndTime=view.findViewById(R.id.btnSetElectionEndTime);
        btnAddPoll=view.findViewById(R.id.btnAddPollSubmit);

        electionStartTime=new Date().getTime();
        electionEndTime=new Date().getTime();

        tvElectionStartTime.setText(getDisplayTime(electionStartTime));
        tvElectionEndTime.setText(getDisplayTime(electionEndTime));

        btnSetElectionStartTime.setOnClickListener(v -> {

        });

        btnSetElectionEndTime.setOnClickListener(v -> {

        });

        btnAddPoll.setOnClickListener(v -> {
            String address=ilAddress.getEditText().getText().toString();
            if(address.isEmpty()){
                Toast.makeText(requireActivity(),"Address Cannot be Empty",Toast.LENGTH_SHORT).show();
            }
            else {
                HashMap<String,Object> hashMap=new HashMap<>();
                hashMap.put(HashMapConstants.UPDATE_TYPE_KEY,HashMapConstants.UPDATE_TYPE_ADD_POLL);
                hashMap.put(HashMapConstants.UPDATE_PARAM_POLL_ADDRESS_KEY,address);
                hashMap.put(HashMapConstants.UPDATE_PARAM_POLL_ELECTION_START_TIME_KEY,electionStartTime);
                hashMap.put(HashMapConstants.UPDATE_PARAM_POLL_ELECTION_END_TIME_KEY,electionEndTime);

                progressIndicatorFragment=ProgressIndicatorFragment.newInstance("Syncing with Server","Adding New Poll");
                progressIndicatorFragment.show(getParentFragmentManager(),"NewPollProcess");
                new DatabaseUpdater(hashMap,this).execute();
            }
        });

    }

    private String  getDisplayTime(long time){
        return DateTimeUtils.getDisplayDate(time)+" "+DateTimeUtils.getDisplayTime(time);
    }

    @Override
    public void onDataUpdated(String type, boolean result, String error) {
        if(type.equals(HashMapConstants.UPDATE_TYPE_ADD_POLL)){
            progressIndicatorFragment.dismiss();
            if(result){
                Toast.makeText(requireActivity(), "Poll Added Successfully", Toast.LENGTH_SHORT).show();
                ilAddress.getEditText().setText("");
            }
            else {
                Toast.makeText(requireActivity(), "Error in Adding Poll: "+error, Toast.LENGTH_SHORT).show();
            }
        }
    }
}