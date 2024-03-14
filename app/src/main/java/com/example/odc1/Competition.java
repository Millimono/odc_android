package com.example.odc1;

public class Competition {
    private int id;
    private String name;

    private String emblem; // Type modifié pour stocker l'URL de l'emblème sous forme de String

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmblem() {
        return emblem;
    }
}

