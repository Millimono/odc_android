package com.example.odc1.views;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.odc1.R;

public class Classviture extends AppCompatActivity {

    private boolean buttonClicked = false;
    Button myButton;
    TextView tooltipTextView;
    TextView tooltipTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framl);

        myButton = findViewById(R.id.idbtn);
        tooltipTextView = findViewById(R.id.textViewContent);
        tooltipTextView2 = findViewById(R.id.textViewError);
        Log.d("CycleDeVie", "onCreate appelé");

        if (savedInstanceState != null) {
            tooltipTextView2.setText(savedInstanceState.getString("cleTexte"));
            tooltipTextView2.setVisibility(savedInstanceState.getInt("tooltipVisibility", View.VISIBLE));

            tooltipTextView.setText(savedInstanceState.getString("cleTexte"));
            tooltipTextView.setVisibility(savedInstanceState.getInt("tooltipVisibility1", View.VISIBLE));

            buttonClicked = savedInstanceState.getBoolean("buttonClicked", false);
            if(buttonClicked) {
                myButton.setBackgroundColor(Color.RED);
            }
        }




        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log.d("MainActivity", "Le bouton a été cliqué");
                tooltipTextView.setVisibility(View.GONE);
                tooltipTextView2.setVisibility(View.VISIBLE);

                // Changez la couleur du bouton et mettez à jour buttonClicked
                myButton.setBackgroundColor(Color.RED);
                buttonClicked = true;
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CycleDeVie", "onStart appelé");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CycleDeVie", "onResume appelé");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CycleDeVie", "onPause appelé");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CycleDeVie", "onStop appelé");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CycleDeVie", "onDestroy appelé");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("cleTexte", tooltipTextView2.getText().toString());
        outState.putString("cleTexte1", tooltipTextView.getText().toString());

        outState.putBoolean("buttonClicked", buttonClicked);
        // Sauvegardez l'état de visibilité
        outState.putInt("tooltipVisibility", tooltipTextView2.getVisibility());
        outState.putInt("tooltipVisibility1", tooltipTextView.getVisibility());

    }



}