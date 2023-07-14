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
    public void Encuesta(View view){
        Intent intent = new Intent(this, encuesta.class);
        startActivity(intent);
    }

    public void Resultados(View view){
        Intent intent = new Intent(this, resultados.class);
        startActivity(intent);
    }
}