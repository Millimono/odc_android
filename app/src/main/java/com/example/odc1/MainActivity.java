package com.example.odc1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private Button  btnRegister;

   // private DBHelper dbHelper;

    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth);

        //db = AppDatabase.getDatabase(this);

        DBHelper dbHelper = new DBHelper(this);

        //SharedPreferences sharedPreferences = getSharedPreferences("fichier1", MODE_PRIVATE);


        Button mybtn = findViewById(R.id.btn);

        EditText useremail = findViewById(R.id.edt1email);
        EditText userpasword = findViewById(R.id.edt2passwrd);

        btnRegister = findViewById(R.id.btnRegister);

       /** btnRegister.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = emailEditText.getText().toString().trim();

            // Exécuter dans un thread séparé pour éviter de bloquer le thread UI
            new Thread(() -> {
                db.userDao().insert(new User(0, username, password));
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Utilisateur enregistré", Toast.LENGTH_SHORT).show());
            }).start();
        });

        mybtn.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = emailEditText.getText().toString().trim();

            new Thread(() -> {
                boolean exists = db.userDao().checkUser(username, password);
                runOnUiThread(() -> {
                    if (exists) {
                        Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, pageprincipale.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Échec de la connexion", Toast.LENGTH_SHORT).show();
                    }
                });
            }).start();
        });**/

       /** btnRegister.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = emailEditText.getText().toString().trim();
            dbHelper.addUser(username, password);
            Toast.makeText(MainActivity.this, "Utilisateur enregistré", Toast.LENGTH_SHORT).show();
        });**/

      mybtn.setOnClickListener(view -> {
            String useremailsend= useremail.getText().toString().trim();
            String password = userpasword.getText().toString().trim();
            if (dbHelper.checkUser(useremailsend, password))
            {
                Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, pageprincipale.class);
                startActivity(intent);
            } else

            {
                Toast.makeText(MainActivity.this, "Échec de la connexion", Toast.LENGTH_SHORT).show();
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, enregistrementuser.class);
                startActivity(intent);
            }
        });
       /**mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String email = useremail.getText().toString();
                String password = userpasword.getText().toString();



                String usernametrue = sharedPreferences.getString("username", "null");
                String userfirstname = sharedPreferences.getString("userfirstname", "null");
                String useremail = sharedPreferences.getString("useremail", "null");
                String userpassword = sharedPreferences.getString("userpassword", "null");


                // Utiliser les valeurs récupérées
                //Log.e("MainActivity", "Username: " + email + ", Email: " + email);

                if(email.contentEquals(useremail) && password.contentEquals(userpassword) )
                {
                    Intent intent = new Intent(MainActivity.this, pageprincipale.class);
                    startActivity(intent);
                }

            }
        });
       **/


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("CycleDeVie", "onStart appelé");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("CycleDeVie", "onResume appelé");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("CycleDeVie", "onPause appelé");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("CycleDeVie", "onStop appelé");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("CycleDeVie", "onDestroy appelé");
    }


}

/* // Récupérer les valeurs des EditText
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();

                // Utiliser les valeurs récupérées
                Log.d("MainActivity", "Username: " + username + ", Email: " + email);
                            <FrameLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_weight="4">

                <TextView
                    android:id="@+id/textViewContent"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Contenu principal"
                    android:layout_gravity="center" />

                <TextView
                    android:id="@+id/textViewError"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Une erreur est survenue"
                    android:layout_gravity="center"
                    android:visibility="gone"/>

            </FrameLayout>

            <Button
                android:id="@+id/idbtn"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:layout_weight="1" />


*/