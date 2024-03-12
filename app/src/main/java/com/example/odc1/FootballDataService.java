package com.example.odc1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface FootballDataService {
    @Headers("X-Auth-Token: 0d05df95aa504c3c880b1708311bc680")
    @GET("v4/competitions/")
    Call<CompetitionsResponse> getCompetitions();
    @Headers("X-Auth-Token: 0d05df95aa504c3c880b1708311bc680")
    @GET("v4/competitions/CL/matches")
    Call<MatchesResponse> getCompetitionMatches();

}
