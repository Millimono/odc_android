package com.example.odc1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneAdapter.PersonneViewHolder> {
    private List<Personne> personnes;
    private List<Personne> personnesFull; // Copie complète des données

    public PersonneAdapter(List<Personne> personnes) {
        this.personnes = personnes;
        this.personnesFull = new ArrayList<>(personnes);
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
        //holder.im.setImageIcon(personne.getImagePath());
        //Glide.with(holder.im.getContext()).load(personne.getImagePath()).into(holder.im);
        Glide.with(holder.im.getContext())
                .load(personne.getImagePath())
                .placeholder(R.drawable.baseline_back_hand_24)
                .error(R.drawable.baseline_electric_car_24)
                .into(holder.im);

        // Ajoutez plus de champs ici selon votre besoin
    }

    @Override
    public int getItemCount() {
        return personnes.size();
    }

    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Personne> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(personnesFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Personne item : personnesFull) {
                    if (item.getNom().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            personnes.clear();
            personnes.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };



    public static class PersonneViewHolder extends RecyclerView.ViewHolder {
        TextView nomTextView, prenomTextView;
        ImageView im;
        // Déclarez plus de vues ici si nécessaire

        public PersonneViewHolder(View itemView) {
            super(itemView);
            nomTextView = itemView.findViewById(R.id.nomTextView);
            prenomTextView = itemView.findViewById(R.id.prenomTextView);
            im = itemView.findViewById(R.id.im);

            // Initialisez plus de vues ici si nécessaire
        }
    }
}

