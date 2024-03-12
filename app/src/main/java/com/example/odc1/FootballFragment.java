package com.example.odc1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FootballFragment extends Fragment {

    private TextView textView;
    private TextView matchesTextView;
    private FootballDataService service; // Déclaration de service au niveau de la classe

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_football, container, false);
       // textView = view.findViewById(R.id.textView);
        //matchesTextView = view.findViewById(R.id.matchesTextView);

        // Initialisation de Retrofit et du service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.football-data.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         service = retrofit.create(FootballDataService.class);


        loadCompetitions();
        loadCompetitionMatches();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
    private void loadCompetitions() {
        service.getCompetitions().enqueue(new Callback<CompetitionsResponse>() {
            @Override
            public void onResponse(Call<CompetitionsResponse> call, Response<CompetitionsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Competition> lesCompetitions = response.body().getCompetitions();

                    // Mettre à jour le RecyclerView ici
                    CompetitionsAdapter adapter = new CompetitionsAdapter(lesCompetitions);
                    RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
                    recyclerView.setAdapter(adapter);

                } else {
                    textView.setText("Erreur: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<CompetitionsResponse> call, Throwable t) {
                textView.setText("Échec de la connexion: " + t.getMessage());
            }
        });
    }

   /** private void loadCompetitions()
    {
        service.getCompetitions().enqueue(new Callback<CompetitionsResponse>() {
            @Override
            public void onResponse(Call<CompetitionsResponse> call, Response<CompetitionsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Competition competition : response.body().getCompetitions()) {
                        stringBuilder.append(competition.getName()).append("\n");
                    }
                    textView.setText(stringBuilder.toString());
                } else {
                    textView.setText("Erreur: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<CompetitionsResponse> call, Throwable t) {
                textView.setText("Échec de la connexion: " + t.getMessage());
            }
        });

    }**/

   /** private void loadCompetitionMatches() {
        service.getCompetitionMatches().enqueue(new Callback<MatchesResponse>() {
            @Override
            public void onResponse(Call<MatchesResponse> call, Response<MatchesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    // Supposons que MatchesResponse contient une liste de matches
                    for (Match match : response.body().getMatches()) {
                        stringBuilder.append(match.getHomeTeam().getName())
                                .append(" vs ")
                                .append(match.getAwayTeam().getName())
                                .append("\n");
                    }
                    matchesTextView.setText(stringBuilder.toString());
                } else {
                    matchesTextView.setText("Erreur: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<MatchesResponse> call, Throwable t) {
                matchesTextView.setText("Échec de la connexion: " + t.getMessage());
            }
        });
    }**/

   // Dans FootballFragment, après avoir obtenu la réponse de l'API
   private void loadCompetitionMatches() {
       service.getCompetitionMatches().enqueue(new Callback<MatchesResponse>() {
           @Override
           public void onResponse(Call<MatchesResponse> call, Response<MatchesResponse> response) {
               if (response.isSuccessful() && response.body() != null) {
                   RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewMatches); // Assurez-vous d'avoir ce RecyclerView dans votre layout
                   MatchesAdapter adapter = new MatchesAdapter(response.body().getMatches());
                   recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                   recyclerView.setAdapter(adapter);
               } else {
                   // Gérer l'erreur
               }
           }

           @Override
           public void onFailure(Call<MatchesResponse> call, Throwable t) {
               // Gérer l'échec de la requête
           }
       });
   }


}
