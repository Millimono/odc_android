package com.example.odc1;

public class Match {
    // Attributs basiques d'un match, adaptez selon les données réelles de l'API
    private int id;
    private String utcDate;
    private Team homeTeam;
    private Team awayTeam;

    public String getDate() {
        return utcDate;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }
    // Getters et éventuellement setters
}
