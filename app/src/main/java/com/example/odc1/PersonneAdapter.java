package com.example.odc1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneAdapter.PersonneViewHolder> {
    private List<Personne> personnes;

    public PersonneAdapter(List<Personne> personnes) {
        this.personnes = personnes;
    }

    @NonNull
    @Override
    public PersonneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personne, parent, false);
        return new PersonneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonneViewHolder holder, int position) {
        Personne personne = personnes.get(position);
        holder.nomTextView.setText(personne.getNom());
        holder.prenomTextView.setText(personne.getPrenom());
        // Ajoutez plus de champs ici selon votre besoin
    }

    @Override
    public int getItemCount() {
        return personnes.size();
    }

    public static class PersonneViewHolder extends RecyclerView.ViewHolder {
        TextView nomTextView, prenomTextView;
        // Déclarez plus de vues ici si nécessaire

        public PersonneViewHolder(View itemView) {
            super(itemView);
            nomTextView = itemView.findViewById(R.id.nomTextView);
            prenomTextView = itemView.findViewById(R.id.prenomTextView);
            // Initialisez plus de vues ici si nécessaire
        }
    }
}

