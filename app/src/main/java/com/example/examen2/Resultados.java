package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {

    ListView list1;

    ArrayList<String> p1 = new ArrayList<>();
    ArrayList<String> p2 = new ArrayList<>();
    ArrayList<String> p3 = new ArrayList<>();
    ArrayList<String> p4 = new ArrayList<>();
    ArrayList<String> p5 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        list1 = findViewById(R.id.list1);

        AdminSQLiteHelper admin = new AdminSQLiteHelper(this,"encuesta",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor tabla = db.rawQuery("select * from encuesta", null);

        if(tabla.moveToFirst()){
            do{
                String frecuencia = tabla.getString(tabla.getColumnIndexOrThrow("frecuencia"));
                String calidad = tabla.getString(tabla.getColumnIndexOrThrow("calidad"));
                String atencion = tabla.getString(tabla.getColumnIndexOrThrow("atencion"));
                String higiene = tabla.getString(tabla.getColumnIndexOrThrow("higiene"));
                String sala = tabla.getString(tabla.getColumnIndexOrThrow("sala"));
                p1.add("Pregunta 1: " + frecuencia + "\nPregunta 2: " + calidad + "\nPregunta 3: " + atencion + "\nPregunta 4: " + higiene + "\nPregunta 5: " + sala);
                Log.d("String respuestas", String.valueOf(p1));
                //p2.add(calidad);
                //p3.add(atencion);
                //p4.add(higiene);
                //p5.add(sala);
            }while(tabla.moveToNext());

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,p1);
            list1.setAdapter(adapter);
        }

        //ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,p1);
        //list1.setAdapter(adaptador);
    }

    public void salir(View view){
        finish();
    }
}