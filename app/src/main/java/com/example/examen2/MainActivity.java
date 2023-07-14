package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenEncuesta(View view){
        Intent intent = new Intent(this, Encuesta.class);
        startActivity(intent);
    }

    public void OpenResultados(View view){
        Intent intent = new Intent(this, Resultados.class);
        startActivity(intent);
    }

    public void OpenResumen(View view){
        Intent intent = new Intent(this, Resumen.class);
        startActivity(intent);
    }
}