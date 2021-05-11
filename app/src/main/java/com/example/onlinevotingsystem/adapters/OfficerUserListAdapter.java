package com.example.onlinevotingsystem.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.classes.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OfficerUserListAdapter extends RecyclerView.Adapter<OfficerUserListAdapter.ViewHolder> {

    ArrayList<User> UserList;

    public OfficerUserListAdapter(ArrayList<User> userList) {
        UserList=userList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvVoterName, tvVoterID;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tvVoterName=itemView.findViewById(R.id.voter_name);
            tvVoterID=itemView.findViewById(R.id.voter_data1);
        }
    }

    @NonNull
    @NotNull
    @Override
    public OfficerUserListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.voter_list_card_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OfficerUserListAdapter.ViewHolder holder, int position) {
        User user=UserList.get(position);
        holder.tvVoterName.setText(user.getName());
        holder.tvVoterID.setText(user.getVoterID());
    }

    @Override
    public int getItemCount() {
        return UserList.size();
    }
}
