package com.example.odc1;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Fragment2 extends Fragment {
    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_CAMERA_PERMISSION = 2;
    private String currentPhotoPath; // Chemin de la photo actuelle
    private EditText nomEditText, prenomEditText, dateNaissanceEditText, salaireEditText, serviceEditText;
    private Button saveButton,TakeButton, pickImageButton;
    ImageView im;
    static final int REQUEST_IMAGE_PICK = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        nomEditText = view.findViewById(R.id.nom);
        prenomEditText = view.findViewById(R.id.prenom);
        dateNaissanceEditText = view.findViewById(R.id.dateNaissance);
        salaireEditText = view.findViewById(R.id.salaire);
        serviceEditText = view.findViewById(R.id.service);
        saveButton = view.findViewById(R.id.saveButton);
        pickImageButton = view.findViewById(R.id.pickImageButton);

        TakeButton = view.findViewById(R.id.TakeButton);
        im  = view.findViewById(R.id.im);
        TakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                requestCameraPermission();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                saveData();
            }
        });

        pickImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchPickPictureIntent();saveData();
            }
        });


        return view;
    }

    private void saveData() {
        String nom = nomEditText.getText().toString();
        String prenom = prenomEditText.getText().toString();
        String dateNaissance = dateNaissanceEditText.getText().toString();
       // double salaire = Double.parseDouble(salaireEditText.getText().toString());

        double salaire = 0;
        try {
            salaire = Double.parseDouble(salaireEditText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Salaire invalide", Toast.LENGTH_SHORT).show();
            return;
        }

        String service = serviceEditText.getText().toString();

        // Vérifiez si une image a été prise ou sélectionnée
        if (currentPhotoPath == null || currentPhotoPath.isEmpty()) {
            Toast.makeText(getContext(), "Aucune image sélectionnée", Toast.LENGTH_SHORT).show();
            return;
        }

        DBHelper dbHelper = new DBHelper(getContext());
        dbHelper.addPersonne(nom, prenom, dateNaissance, salaire, service,currentPhotoPath);

        // Effacer les champs
        nomEditText.setText("");
        prenomEditText.setText("");
        dateNaissanceEditText.setText("");
        salaireEditText.setText("");
        serviceEditText.setText("");

        // Afficher le toast de confirmation
        Toast.makeText(getContext(), "Données enregistrées", Toast.LENGTH_SHORT).show();
    }

    private void requestCameraPermission() {
        // Vérifie si la permission est déjà accordée
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Demande la permission
            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
        } else {
            // Permission déjà accordée
            dispatchTakePictureIntent();
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Assurez-vous que l'appareil dispose d'une application caméra pour gérer l'intention
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Traitement des erreurs de création de fichier
                Toast.makeText(getContext(), "Erreur lors de la création du fichier de la photo", Toast.LENGTH_SHORT).show();
            }
            // Continuez uniquement si le fichier a été créé avec succès
            if (photoFile != null) {

                Uri photoURI = FileProvider.getUriForFile(getContext(),
                        "com.example.odc1.fileprovider", // Ceci doit correspondre à l'authority définie dans le manifeste
                        photoFile);

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Création d'un nom de fichier d'image unique
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName, /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        );

        // Sauvegarde du chemin complet pour utilisation avec ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //Gérer le résultat de l'intention : Modifiez la méthode onActivityResult pour gérer le résultat
    // //de la sélection d'image, en plus de la prise de photo.
    /**  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK)
        {
            Glide.with(this).load(currentPhotoPath).into(im);
        }
    }**/
   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Glide.with(this).load(currentPhotoPath).into(im);
        } else if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                currentPhotoPath = getPathFromUri(selectedImageUri); // Convertir l'URI en chemin de fichier
                Glide.with(this).load(selectedImageUri).into(im);
            }
        }
    }

**/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Glide.with(this).load(currentPhotoPath).into(im);
        } else if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                try {
                    currentPhotoPath = createImageFileFromUri(selectedImageUri); // Copiez l'image et obtenez le nouveau chemin
                    if (currentPhotoPath != null) {
                        Glide.with(this).load(currentPhotoPath).into(im);
                    }
                } catch (IOException e) {
                    Toast.makeText(getContext(), "Erreur lors de la sauvegarde de l'image", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission accordée, lancez l'intention de capture d'image
                dispatchTakePictureIntent();
            } else {
                // Permission refusée, montrez un message à l'utilisateur
                Toast.makeText(getContext(), "Permission de l'appareil photo refusée", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Créer une méthode pour ouvrir la galerie
    private void dispatchPickPictureIntent() {
        Intent pickPictureIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (pickPictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(pickPictureIntent, REQUEST_IMAGE_PICK);
        }
    }

    //Convertir l'URI en chemin de fichier : Créez une méthode pour convertir l'URI
    // de l'image sélectionnée en chemin de fichier, si nécessaire.

    private String getPathFromUri(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            return cursor.getString(column_index);
        }
        return null;
    }

    private String createImageFileFromUri(Uri imageUri) throws IOException {
        InputStream inputStream = getActivity().getContentResolver().openInputStream(imageUri);
        if (inputStream != null) {
            File photoFile = createImageFile(); // Utilise la méthode existante pour créer un fichier vide

            try (FileOutputStream outputStream = new FileOutputStream(photoFile)) {
                // Copiez le contenu de l'URI vers le fichier
                byte[] buf = new byte[1024];
                int len;
                while ((len = inputStream.read(buf)) > 0) {
                    outputStream.write(buf, 0, len);
                }
                return photoFile.getAbsolutePath();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                inputStream.close();
            }
        }
        return null;
    }



}



