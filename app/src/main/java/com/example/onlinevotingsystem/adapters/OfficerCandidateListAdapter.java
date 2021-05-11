package com.example.onlinevotingsystem.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.classes.Candidate;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OfficerCandidateListAdapter extends RecyclerView.Adapter<OfficerCandidateListAdapter.ViewHolder> {

    ArrayList<Candidate> CandidateList;

    public OfficerCandidateListAdapter(ArrayList<Candidate> candidateList){
        CandidateList=candidateList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvId;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvCandidateItemName);
            tvId=itemView.findViewById(R.id.tvCandidateItemID);
        }
    }

    @NonNull
    @NotNull
    @Override
    public OfficerCandidateListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OfficerCandidateListAdapter.ViewHolder holder, int position) {
        Candidate candidate=CandidateList.get(position);
        holder.tvId.setText(candidate.getID());
        holder.tvName.setText(candidate.getName());
    }

    @Override
    public int getItemCount() {
        return CandidateList.size();
    }
}
