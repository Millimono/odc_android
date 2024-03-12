package com.example.odc1;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneAdapter.ViewHolder> {

    private List<Personne> personneList;

    public PersonneAdapter(List<Personne> personneList) {
        this.personneList = personneList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personne_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Personne personne = personneList.get(position);
        holder.nomTextView.setText(personne.getNom()); // Assurez-vous que Personne a des getters
        holder.prenomTextView.setText(personne.getPrenom());
    }

    @Override
    public int getItemCount() {
        return personneList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomTextView, prenomTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nomTextView = itemView.findViewById(R.id.nomTextView);
            prenomTextView = itemView.findViewById(R.id.prenomTextView);
        }
    }
}
