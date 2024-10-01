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

public class Saiba2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saiba2);

        // Botão para abrir o mapa
        Button bntAbrirMapa2 = findViewById(R.id.bntAbrirMapa2);
        bntAbrirMapa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=DUO+Bistrô");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });

        // Botão para abrir o site
        Button bntAbrirSite2 = findViewById(R.id.bntAbrirSite2);
        bntAbrirSite2.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://duobistro.com.br/");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        // Botão para ligar
        Button bntligar2 = findViewById(R.id.bntligar2);
        bntligar2.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:15991763384");
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