package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Resumen extends AppCompatActivity {

    ListView list2;

    ArrayList<String> resumen = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        list2 = findViewById(R.id.list2);


        resumen.add("¿Con que frecuencia acudes al cine? \n1 vez al mes: " + contarRespuestaPregunta1("1 vez al mes", "frecuencia")
                    + "\n1 vez a la semana: " + contarRespuestaPregunta1("1 vez a la semana", "frecuencia")
                    + "\nMás de una vez a la semana: " + contarRespuestaPregunta1("Más de una vez a la semana", "frecuencia")
                    + "\nCasi nunca: " + contarRespuestaPregunta1("Casi nunca", "frecuencia")
        );
        resumen.add("Califique la calidad de audio de las salas \nMala: " + contarRespuestaPregunta1("Mala", "calidad")
                + "\nRegular: " + contarRespuestaPregunta1("Regular", "calidad")
                + "\nBuena: " + contarRespuestaPregunta1("Buena", "calidad")
                + "\nExcelente: " + contarRespuestaPregunta1("Excelente", "calidad")
        );
        resumen.add("Califique la atención del personal antes, duerante y después de la función \nMala: " + contarRespuestaPregunta1("Mala", "atencion")
                + "\nRegular: " + contarRespuestaPregunta1("Regular", "atencion")
                + "\nBuena: " + contarRespuestaPregunta1("Buena", "atencion")
                + "\nExcelente: " + contarRespuestaPregunta1("Excenlente", "atencion")
        );
        resumen.add("Califique el nivel de higiene en baños y salas \nMala: " + contarRespuestaPregunta1("Mala", "higiene")
                + "\nRegular: " + contarRespuestaPregunta1("Regular", "higiene")
                + "\nBuena: " + contarRespuestaPregunta1("Buena", "higiene")
                + "\nExcelente: " + contarRespuestaPregunta1("Excenlente", "higiene")
        );
        resumen.add("¿Qué tipo de sala prefiere? \n3D: " + contarRespuestaPregunta1("3D", "sala")
                + "\nSala tradicional: " + contarRespuestaPregunta1("Sala tradicional", "sala")
                + "\nMacro XE: " + contarRespuestaPregunta1("Macro XE", "sala")
        );

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,resumen);
        list2.setAdapter(adapter);

    }

    public int contarRespuestaPregunta1(String respuesta, String columna) {
        SQLiteOpenHelper admin = new AdminSQLiteHelper(this, "encuesta", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        String[] columns = {"COUNT(*)"};
        String selection = columna + " = ?";
        String[] selectionArgs = {respuesta};

        Cursor cursor = db.query("encuesta", columns, selection, selectionArgs, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        db.close();

        return count;
    }

}