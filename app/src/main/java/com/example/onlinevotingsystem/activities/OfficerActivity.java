package com.example.onlinevotingsystem.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.onlinevotingsystem.R;
import com.example.onlinevotingsystem.utils.HomeAdapter.FeaturedAdapter;
import com.example.onlinevotingsystem.utils.HomeAdapter.featuredHelperClass;
import com.example.onlinevotingsystem.utils.HomeAdapter.voterAdapter;
import com.example.onlinevotingsystem.utils.HomeAdapter.voterHelperclass;

import java.util.ArrayList;

public class OfficerActivity extends AppCompatActivity {

    RecyclerView featuredRecycler, voterrecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_officer);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        voterrecycler = findViewById(R.id.voter_recycler);

        featuredRecycler();
        voterrecycler();
    }

    private void voterrecycler() {

        voterrecycler.setHasFixedSize(true);
        voterrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        ArrayList<voterHelperclass> voterlists = new ArrayList<>();

        voterlists.add(new voterHelperclass(R.drawable.user2,"Mridul Mittal", "Voted: YES Ward: W10"));
        voterlists.add(new voterHelperclass(R.drawable.user3,"Kshitij Kumar ", "Voted: NO Ward: W10"));
        voterlists.add(new voterHelperclass(R.drawable.user4,"Piyush Gurjar", "Voted: YES Ward: W8"));
        voterlists.add(new voterHelperclass(R.drawable.user1,"Varun Tiwari", "Voted: YES Ward: W1"));

        adapter = new voterAdapter(voterlists);
        voterrecycler.setAdapter(adapter);


    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        ArrayList<featuredHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new featuredHelperClass(R.drawable.user2,"Mridul Mittal", "Party: AAP Ward: W10"));
        featuredLocations.add(new featuredHelperClass(R.drawable.user3,"Kshitij Kumar ", "Party: AAP Ward: W10"));
        featuredLocations.add(new featuredHelperClass(R.drawable.user4,"Piyush Gurjar", "Party: Congress Ward: W8"));
        featuredLocations.add(new featuredHelperClass(R.drawable.user4,"Varun Tiwari", "Party: BJP Ward: W1"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }
}