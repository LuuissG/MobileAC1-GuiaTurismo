package com.example.guia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void telasaiba1(View view) {
        // Classe intent é responsável por definir a intenção que deseja (navegar entre telas)
        Intent in = new Intent(MainActivity.this, Saiba1.class);
        startActivity(in);
    }

    public void telasaiba2(View view) {
        // Classe intent é responsável por definir a intenção que deseja (navegar entre telas)
        Intent in = new Intent(MainActivity.this, Saiba2.class);
        startActivity(in);
    }

    public void telasaiba3(View view) {
        // Classe intent é responsável por definir a intenção que deseja (navegar entre telas)
        Intent in = new Intent(MainActivity.this, Saiba3.class);
        startActivity(in);
    }
}