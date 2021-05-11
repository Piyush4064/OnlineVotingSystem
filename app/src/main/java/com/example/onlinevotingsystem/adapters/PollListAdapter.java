package com.example.onlinevotingsystem.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.classes.Poll;
import com.example.onlinevotingsystem.fragments.shared.PollListFragmentDirections;
import com.example.onlinevotingsystem.utils.DateTimeUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;

public class PollListAdapter extends RecyclerView.Adapter<PollListAdapter.ViewHolder> {

    ArrayList<Poll> PollList;
    NavController navController;

    public PollListAdapter(ArrayList<Poll> pollList, NavController navController) {
        PollList = pollList;
        this.navController = navController;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvPollNum, tvOfficer, tvAddress, tvNumOfCandidates, tvElectionStartTime, tvElectionEndTime;
        Button btnViewCandidates, btnViewResult;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvPollNum=itemView.findViewById(R.id.tvPollItemNumber);
            tvOfficer=itemView.findViewById(R.id.tvPollitemOfficer);
            tvAddress=itemView.findViewById(R.id.tvPollitemAddress);
            tvNumOfCandidates=itemView.findViewById(R.id.tvPollitemCandidateNo);
            tvElectionStartTime=itemView.findViewById(R.id.tvPollitemStartTime);
            tvElectionEndTime=itemView.findViewById(R.id.tvPollItemEndTime);
            btnViewCandidates=itemView.findViewById(R.id.btnPollListViewCandidates);
            btnViewResult=itemView.findViewById(R.id.btnPollListViewResult);
        }
    }

    @NonNull
    @NotNull
    @Override
    public PollListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.poll_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PollListAdapter.ViewHolder holder, int position) {
        Poll poll= PollList.get(position);
        holder.tvPollNum.setText(String.format("%d",poll.getPollNumber()));

        if(poll.getOfficerUsername()!=null)
            holder.tvOfficer.setText(poll.getOfficerUsername());
        else
            holder.tvOfficer.setText("No Officer Assigned");

        holder.tvAddress.setText(poll.getAddress());
        holder.tvNumOfCandidates.setText(String.format("%d",poll.getNumberOfCandidates()));
        holder.tvElectionStartTime.setText(getDisplayTime(poll.getElectionStartTime()));
        holder.tvElectionEndTime.setText(getDisplayTime(poll.getElectionEndTime()));

        holder.btnViewResult.setEnabled(poll.getElectionEndTime() <= new Date().getTime());
        holder.btnViewCandidates.setEnabled(poll.getNumberOfCandidates() != 0);

        holder.btnViewResult.setOnClickListener(v -> {

        });

        holder.btnViewCandidates.setOnClickListener(v -> {
            NavDirections action= PollListFragmentDirections.actionPollListFragmentToCandidateListFragment(position);
            navController.navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return PollList.size();
    }

    private String  getDisplayTime(long time){
        return DateTimeUtils.getDisplayDate(time)+" "+DateTimeUtils.getDisplayTime(time);
    }
}
