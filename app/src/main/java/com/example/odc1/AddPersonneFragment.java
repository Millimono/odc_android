package com.example.odc1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPersonneFragment extends Fragment {

    private EditText editTextNom, editTextPrenom;
    private Button buttonSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_personne, container, false);

        editTextNom = view.findViewById(R.id.editTextNom);
        editTextPrenom = view.findViewById(R.id.editTextPrenom);
        buttonSave = view.findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(v -> {
            String nom = editTextNom.getText().toString().trim();
            String prenom = editTextPrenom.getText().toString().trim();

            DBHelper dbHelper = new DBHelper(getContext());
            dbHelper.addPersonne(nom, prenom);

            Toast.makeText(getContext(), "Personne ajoutée", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}

