package com.example.odc1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DisplayPersonnesFragment extends Fragment {

    private RecyclerView recyclerView;
    private PersonneAdapter adapter;
    private List<Personne> personneList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_personnes, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DBHelper dbHelper = new DBHelper(getContext());
        personneList = dbHelper.getAllPersonnes();
        adapter = new PersonneAdapter(personneList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}

