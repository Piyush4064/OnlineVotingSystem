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

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {


    ArrayList<featuredHelperClass> featuredLoactions;

    public FeaturedAdapter(ArrayList<featuredHelperClass> featuredLoactions) {
        this.featuredLoactions = featuredLoactions;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        featuredHelperClass featuredHelperClass = featuredLoactions.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.name.setText(featuredHelperClass.getName());
        holder.info.setText(featuredHelperClass.getInfo());

    }

    @Override
    public int getItemCount() {

        return featuredLoactions.size();
    }


    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name, info;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.featured_img1);
            name = itemView.findViewById(R.id.featured_name1);
            info = itemView.findViewById(R.id.featured_info1);



        }
    }


}
