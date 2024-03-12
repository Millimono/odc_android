package com.example.odc1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pageprincipale extends AppCompatActivity
{

    Button myButton;
    TextView tooltipTextView,tooltipTextView2;
    Boolean buttonClicked;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageprincipale);

        Button btn1 = findViewById(R.id.btntest);
        Button btn2 = findViewById(R.id.btntest2);
        Button btn3 = findViewById(R.id.btntest3);
        Button btn4 = findViewById(R.id.btntest4);
        Button btn5 = findViewById(R.id.btntest5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentLayout, new Fragment1())
                        .commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentLayout, new Fragment2())
                        .commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentLayout, new FootballFragment())
                        .commit();
            }
        });



        /**myButton = findViewById(R.id.idbtn);
        tooltipTextView = findViewById(R.id.textViewContent);
        tooltipTextView2 = findViewById(R.id.textViewError);


        if (savedInstanceState != null)
        {
            tooltipTextView2.setText(savedInstanceState.getString("cleTexte"));
            tooltipTextView2.setVisibility(savedInstanceState.getInt("tooltipVisibility", View.VISIBLE));

            tooltipTextView.setText(savedInstanceState.getString("cleTexte1"));
            tooltipTextView.setVisibility(savedInstanceState.getInt("tooltipVisibility1", View.VISIBLE));

            buttonClicked = savedInstanceState.getBoolean("buttonClicked", false);
            if(buttonClicked)
            {
               myButton.setBackgroundColor(Color.RED);
            }
        }


        myButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // Log.d("MainActivity", "Le bouton a été cliqué");
                tooltipTextView.setVisibility(View.GONE);
                tooltipTextView2.setVisibility(View.VISIBLE);

                // Changez la couleur du bouton et mettez à jour buttonClicked
                myButton.setBackgroundColor(Color.RED);
                buttonClicked = true;
            }
        });**/

    }


    /**protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("cleTexte", tooltipTextView2.getText().toString());
        outState.putString("cleTexte1", tooltipTextView.getText().toString());

        outState.putBoolean("buttonClicked", buttonClicked);
        // Sauvegardez l'état de visibilité
        outState.putInt("tooltipVisibility", tooltipTextView2.getVisibility());
        outState.putInt("tooltipVisibility1", tooltipTextView.getVisibility());

    }*/
}


