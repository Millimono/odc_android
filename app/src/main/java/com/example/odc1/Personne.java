package com.example.odc1;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private double salaire;
    private String service;
    private String imagePath;

    // Constructeur vide pour initialiser un nouvel objet Personne
    public Personne() {
    }

    // Constructeur avec tous les paramètres
    public Personne(int id, String nom, String prenom, String dateNaissance, double salaire, String service) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.salaire = salaire;
        this.service = service;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    // Getters et setters pour chaque attribut de la classe
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
