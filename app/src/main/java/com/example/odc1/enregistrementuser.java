package com.example.odc1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class enregistrementuser  extends AppCompatActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enre);
        //SharedPreferences sharedPreferences = getSharedPreferences("fichier1", MODE_PRIVATE);
        DBHelper dbHelper = new DBHelper(this);


        Button btnenre = findViewById(R.id.btnRegisteruser);
        EditText edtnom = findViewById(R.id.edtnom);
        EditText edtprenom = findViewById(R.id.edtprenom);
        EditText edtemail= findViewById(R.id.edtemail);
        EditText edtpassword = findViewById(R.id.edtpassword);

        btnenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtnom.getText().toString();
                String userfirstname = edtprenom.getText().toString();
                String useremail = edtemail.getText().toString();
                String userpassword = edtpassword.getText().toString();

                /**SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("userfirstname",userfirstname);
                editor.putString("useremail", useremail);
                editor.putString("userpassword",userpassword);
                editor.apply();**/
                dbHelper.addUser(useremail, userpassword);

                Intent intent = new Intent(enregistrementuser.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
