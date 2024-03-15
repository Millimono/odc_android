package com.example.odc1;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.File;

public class PersonDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        if (getIntent() != null) {
            String nom = getIntent().getStringExtra("nom");
            String prenom = getIntent().getStringExtra("prenom");
            String imagePath = getIntent().getStringExtra("imagePath");

            ImageView imageView = findViewById(R.id.image_detail);
            // Récupérez d'autres informations si nécessaire

            TextView nomTextView = findViewById(R.id.nom_detail);
            TextView prenomTextView = findViewById(R.id.prenom_detail);

            // Initialiser d'autres vues

            nomTextView.setText(nom);
            prenomTextView.setText(prenom);

            // Utilisez Glide pour charger l'image
            Glide.with(this)
                    .load(imagePath) // Assurez-vous que imagePath est une URI valide ou un chemin de fichier
                    .circleCrop() // Pour arrondir l'image
                    .into(imageView);
        }
            // Définir le texte pour d'autres vues
        }
}


