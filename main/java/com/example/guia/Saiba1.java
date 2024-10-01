package com.example.guia;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Saiba1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saiba1);

        // Botão para abrir o mapa
        Button bntAbrirMapa = findViewById(R.id.bntAbrirMapa);
        bntAbrirMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=Fior+Di+Zucca+Cucina+D+Italia");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });

        // Botão para abrir o site
        Button bntAbrirSite = findViewById(R.id.bntAbrirSite);
        bntAbrirSite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.facebook.com/fiordizuccagastronomia/");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        // Botão para ligar
        Button bntligar = findViewById(R.id.bntligar);
        bntligar.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:15996221190");
            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            int permissionCheck =
                    ContextCompat.checkSelfPermission(
                            this, android.Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{
                                android.Manifest.permission.CALL_PHONE},1);
            } else{
                startActivity(intent);
            }
        });
    }
}