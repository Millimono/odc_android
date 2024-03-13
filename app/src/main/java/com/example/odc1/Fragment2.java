package com.example.odc1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment2 extends Fragment {

    private EditText nomEditText, prenomEditText, dateNaissanceEditText, salaireEditText, serviceEditText;
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        nomEditText = view.findViewById(R.id.nom);
        prenomEditText = view.findViewById(R.id.prenom);
        dateNaissanceEditText = view.findViewById(R.id.dateNaissance);
        salaireEditText = view.findViewById(R.id.salaire);
        serviceEditText = view.findViewById(R.id.service);
        saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                saveData();
            }
        });

        return view;
    }

    private void saveData() {
        String nom = nomEditText.getText().toString();
        String prenom = prenomEditText.getText().toString();
        String dateNaissance = dateNaissanceEditText.getText().toString();
       // double salaire = Double.parseDouble(salaireEditText.getText().toString());

        double salaire = 0;
        try {
            salaire = Double.parseDouble(salaireEditText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Salaire invalide", Toast.LENGTH_SHORT).show();
            return;
        }

        String service = serviceEditText.getText().toString();

        DBHelper dbHelper = new DBHelper(getContext());
        dbHelper.addPersonne(nom, prenom, dateNaissance, salaire, service);

        // Effacer les champs
        nomEditText.setText("");
        prenomEditText.setText("");
        dateNaissanceEditText.setText("");
        salaireEditText.setText("");
        serviceEditText.setText("");

        // Afficher le toast de confirmation
        Toast.makeText(getContext(), "Données enregistrées", Toast.LENGTH_SHORT).show();
    }
}



