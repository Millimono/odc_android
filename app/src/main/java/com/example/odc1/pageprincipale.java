package com.example.odc1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class pageprincipale extends AppCompatActivity
{

    Button myButton;
    TextView tooltipTextView,tooltipTextView2;
    Boolean buttonClicked;

    ImageButton btn1,btn2,btn3,btn4;
    ImageButton[] allButtons;
    View indicator1, indicator2, indicator3, indicator4;
    View[] allIndicators;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageprincipale);

        LinearLayout specialLayoutForBtn1 = findViewById(R.id.specialLayoutForBtn1);


         btn1 = findViewById(R.id.btntest);
        indicator1 = findViewById(R.id.indicator_btntest);
        btn2 = findViewById(R.id.btntest2);
        indicator2 = findViewById(R.id.indicator_btntest2);
        btn3 = findViewById(R.id.btntest3);
        indicator3 = findViewById(R.id.indicator_btntest3);
        btn4 = findViewById(R.id.btntest4);
        indicator4 = findViewById(R.id.indicator_btntest4);

        allButtons = new ImageButton[] {btn1, btn2, btn3, btn4};
        allIndicators = new View[] {indicator1, indicator2, indicator3, indicator4};

      /*  btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentLayout, new Fragment1())
                        .commit();
                setSelectedButton(btn1); // Met à jour les couleurs des boutons
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentLayout, new Fragment2())
                        .commit();
                setSelectedButton(btn2); // Met à jour les couleurs des boutons

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentLayout, new FootballFragment())
                        .commit();
                setSelectedButton(btn3); // Met à jour les couleurs des boutons

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentLayout, new Fragment4())
                        .commit();
                setSelectedButton(btn4); // Met à jour les couleurs des boutons

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
        /**btn1.performClick(); **/

        // Définir le listener et la logique de changement de couleur
        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Réinitialiser la couleur de tous les boutons
                for (ImageButton btn : allButtons) {
                    btn.setColorFilter(getResources().getColor(R.color.icon_not_selected));
                }
                // Changer la couleur de l'icône du bouton cliqué
                ImageButton clickedBtn = (ImageButton) v;
                clickedBtn.setColorFilter(getResources().getColor(R.color.icon_selected));

                // Cacher tous les indicateurs
                for (View indicator : allIndicators) {
                    indicator.setVisibility(View.INVISIBLE);
                    // Mettre specialLayoutForBtn1 invisible par défaut
                    specialLayoutForBtn1.setVisibility(View.GONE);
                }

                // Remplacer le fragment, similaire à votre logique existante
                // Exemple pour btn1:
                if (v.getId() == R.id.btntest)
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentLayout, new Fragment1())
                            .commit();
                    indicator1.setVisibility(View.VISIBLE);
                    specialLayoutForBtn1.setVisibility(View.VISIBLE);
                }
                if (v.getId() == R.id.btntest2)
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentLayout, new Fragment2())
                            .commit();
                    indicator2.setVisibility(View.VISIBLE);
                }
                if (v.getId() == R.id.btntest3)
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentLayout, new FootballFragment())
                            .commit();
                    indicator3.setVisibility(View.VISIBLE);

                }
                if (v.getId() == R.id.btntest4)
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentLayout, new Fragment4())
                            .commit();
                    indicator4.setVisibility(View.VISIBLE);
                }
                // Ajoutez ici la logique pour les autres boutons
            }
        };

        // Appliquer le listener à tous les boutons
        for (ImageButton btn : allButtons) {
            btn.setOnClickListener(btnListener);
        }

        // Simuler un clic sur btn1 pour définir l'état initial
        btn1.performClick();

    }

   /** private void setSelectedButton(ImageButton selectedButton) {
        // Réinitialiser tous les boutons à l'état non sélectionné
        btn1.setBackgroundColor(getResources().getColor(R.color.button_not_selected));
        btn2.setBackgroundColor(getResources().getColor(R.color.button_not_selected));
        btn3.setBackgroundColor(getResources().getColor(R.color.button_not_selected));
        btn4.setBackgroundColor(getResources().getColor(R.color.button_not_selected));

        // Définir le bouton sélectionné avec une couleur différente
        selectedButton.setBackgroundColor(getResources().getColor(R.color.button_selected));
    }**/



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


