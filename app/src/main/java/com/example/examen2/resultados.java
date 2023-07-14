package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class resultados extends AppCompatActivity {

    ListView list1;

    ArrayList<String> listadoEstadisticas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        list1 = findViewById(R.id.list1);

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listadoEstadisticas);
        list1.setAdapter(adaptador);
    }
}