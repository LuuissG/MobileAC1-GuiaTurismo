package com.example.guia;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Saiba3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saiba3);

        // Botão para abrir o mapa
        Button bntAbrirMapa3 = findViewById(R.id.bntAbrirMapa3);
        bntAbrirMapa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=La+Doc+Gastronomia");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });

        // Botão para abrir o site
        Button bntAbrirSite3 = findViewById(R.id.bntAbrirSite3);
        bntAbrirSite3.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.ladocgastronomia.com.br/");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        // Botão para ligar
        Button bntligar3 = findViewById(R.id.bntligar3);
        bntligar3.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:1532244747");
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