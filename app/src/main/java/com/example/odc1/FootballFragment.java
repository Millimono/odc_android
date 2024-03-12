package com.example.odc1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    private TextView textView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_football, container, false);
        textView = view.findViewById(R.id.textView);
        textView2 = view.findViewById(R.id.textView2);

        loadCompetitions();
        return view;
    }

    private void loadCompetitions()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.football-data.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FootballDataService service = retrofit.create(FootballDataService.class);

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


       // FootballDataService service2 = retrofit.create(FootballDataService.class);
        service.getCLMatches().enqueue(new Callback<MatchesResponse>() {
            @Override
            public void onResponse(Call<MatchesResponse> call, Response<MatchesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    MatchesResponse matchesResponse = response.body();
                    List<Match> matches = matchesResponse.getMatches();
                    StringBuilder matchesInfo = new StringBuilder();
                    for (Match match : matches) {
                        // Ici, vous pouvez ajuster les informations affichées selon vos besoins
                        matchesInfo.append("Date: ").append(match.getDate())
                                .append("\nHome Team: ").append(match.getHomeTeam().getName())
                                .append("\nAway Team: ").append(match.getAwayTeam().getName())
                                .append("\n\n");
                    }
                         textView2.setText(matchesInfo.toString());
                } else {
                    // Gérez l'erreur, par exemple un code de réponse non réussi
                        textView2.setText("Erreur lors de la récupération des matchs: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MatchesResponse> call, Throwable t) {
                // Gérez l'échec de la requête, par exemple une exception réseau
               textView2.setText("Échec de la connexion: " + t.getMessage());
            }
        });


    }
}
