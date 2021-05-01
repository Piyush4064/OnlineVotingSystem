package com.example.onlinevotingsystem.utils.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinevotingsystem.R;

import java.util.ArrayList;

public class voterAdapter extends RecyclerView.Adapter<voterAdapter.Voterviewholder> {

    ArrayList<voterHelperclass> voterlists;


    public voterAdapter(ArrayList<voterHelperclass> voterlists) {
        this.voterlists = voterlists;
    }


    @NonNull
    @Override
    public voterAdapter.Voterviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voter_list_card_design,parent,false);
        Voterviewholder voterviewholder = new voterAdapter.Voterviewholder(view);
        return voterviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull voterAdapter.Voterviewholder holder, int position) {

        voterHelperclass voterHelperclass = voterlists.get(position);



        holder.image.setImageResource(voterHelperclass.getImage());
        holder.name.setText(voterHelperclass.getName());
        holder.info.setText(voterHelperclass.getInfo());


    }

    @Override
    public int getItemCount() {

        return voterlists.size();
    }

    public static class Voterviewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, info;

        public Voterviewholder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.voter_img);
            name = itemView.findViewById(R.id.voter_name);
            info = itemView.findViewById(R.id.voter_data1);

        }

    }
}
