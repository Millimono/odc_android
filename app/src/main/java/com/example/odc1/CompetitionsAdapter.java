package com.example.odc1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.CompetitionViewHolder> {

    private List<Competition> competitions;

    public CompetitionsAdapter(List<Competition> competitions) {
        this.competitions = competitions;
    }

    @NonNull
    @Override
    public CompetitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_competition, parent, false);
        return new CompetitionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionViewHolder holder, int position) {
        Competition competition = competitions.get(position);
        holder.tvName.setText(competition.getName());
    }

    @Override
    public int getItemCount()
    {
        return competitions.size();
    }

    public static class CompetitionViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;

        public CompetitionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
