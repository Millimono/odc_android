package com.example.odc1;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class Fragment1 extends Fragment implements PersonneAdapter.OnItemClickListener{

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.personneRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DBHelper dbHelper = new DBHelper(getContext());
        List<Personne> personnes = dbHelper.getAllPersonness();

        PersonneAdapter adapter = new PersonneAdapter(personnes,this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Implémentation de onItemClick
    @Override
    public void onItemClick(Personne personne) {
        Intent intent = new Intent(getContext(), PersonDetails.class);
        intent.putExtra("nom", personne.getNom());
        intent.putExtra("prenom", personne.getPrenom());
        intent.putExtra("imagePath", personne.getImagePath());

        // Ajoutez d'autres informations comme extras selon les besoins
        startActivity(intent);
    }
}


