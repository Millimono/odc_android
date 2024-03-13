package com.example.odc1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AppDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
        db.execSQL("CREATE TABLE personne (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, prenom TEXT, dateNaissance TEXT, salaire REAL, service TEXT,imagePath TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    // Méthode pour ajouter un utilisateur
    public void addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        db.insert("users", null, values);
        db.close();
    }

    public void addPersonne(String nom, String prenom, String dateNaissance, double salaire, String service) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nom", nom);
        values.put("prenom", prenom);
        values.put("dateNaissance", dateNaissance);
        values.put("salaire", salaire);
        values.put("service", service);
        db.insert("personne", null, values);
        db.close();
    }

    public void addPersonne(String nom, String prenom, String dateNaissance, double salaire, String service, String imagePath) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nom", nom);
        values.put("prenom", prenom);
        values.put("dateNaissance", dateNaissance);
        values.put("salaire", salaire);
        values.put("service", service);
        values.put("imagePath", imagePath);
        db.insert("personne", null, values);
        db.close();
    }

    // Méthode pour vérifier l'utilisateur
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[]{username, password});
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return exists;
    }

    public List<Personne> getAllPersonnes() {
        List<Personne> personnes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM personne", null);

        if (cursor.moveToFirst()) {
            do {
                Personne personne = new Personne();
                // Assurez-vous que ces index correspondent à ceux de votre table

                int nomIndex = cursor.getColumnIndex("nom");
                if (nomIndex != -1) {
                    personne.setNom(cursor.getString(nomIndex));
                }

                int prenomIndex = cursor.getColumnIndex("prenom");
                if (prenomIndex != -1) {
                    personne.setPrenom(cursor.getString(prenomIndex));
                }

                // Initialisez les autres attributs de Personne ici
                personnes.add(personne);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return personnes;
    }

    public List<Personne> getAllPersonness() {
        List<Personne> personnes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM personne", null);

        if (cursor.moveToFirst()) {
            do {
                Personne personne = new Personne();
                // Assurez-vous que ces index correspondent à ceux de votre table

                int nomIndex = cursor.getColumnIndex("nom");
                if (nomIndex != -1) {
                    personne.setNom(cursor.getString(nomIndex));
                }

                int prenomIndex = cursor.getColumnIndex("prenom");
                if (prenomIndex != -1) {
                    personne.setPrenom(cursor.getString(prenomIndex));
                }

                int dateNaissanceIndex = cursor.getColumnIndex("dateNaissance");
                if (dateNaissanceIndex != -1) {
                    personne.setDateNaissance(cursor.getString(dateNaissanceIndex));
                }

                int salaireIndex = cursor.getColumnIndex("salaire");
                if (salaireIndex != -1) {
                    personne.setSalaire(cursor.getDouble(salaireIndex));
                }

                int serviceIndex = cursor.getColumnIndex("service");
                if (serviceIndex != -1) {
                    personne.setService(cursor.getString(serviceIndex));
                }

                int imagePathIndex = cursor.getColumnIndex("imagePath");
                if (imagePathIndex != -1) {
                    personne.setImagePath(cursor.getString(imagePathIndex));
                }

                // Ajoutez la personne à la liste
                personnes.add(personne);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return personnes;
    }


}

