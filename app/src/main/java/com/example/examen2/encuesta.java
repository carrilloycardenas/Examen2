package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class encuesta extends AppCompatActivity {

    RadioGroup RadioGroupFrecuencia, RadioGroupCalidad, RadioGroupAtencion, RadioGroupHigiene, RadioGroupSala;
    RadioButton btnP1op1, btnP1op2, btnP1op3, btnP1op4, btnP2op1, btnP2op2, btnP2op3, btnP2op4,
            btnP3op1, btnP3op2, btnP3op3, btnP3op4, btnP4op1, btnP4op2, btnP4op3, btnP4op4, btnP5op1, btnP5op2, btnP5op3, btnP5op4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        RadioGroupFrecuencia = findViewById(R.id.RadioGroupFrecuencia);
        RadioGroupCalidad = findViewById(R.id.RadioGroupCalidad);
        RadioGroupAtencion = findViewById(R.id.RadioGroupAtencion);
        RadioGroupHigiene = findViewById(R.id.RadioGroupHigiene);
        RadioGroupSala = findViewById(R.id.RadioGroupSala);
        btnP1op1 = findViewById(R.id.btnP1op1);
        btnP1op2 = findViewById(R.id.btnP1op1);
        btnP1op3 = findViewById(R.id.btnP1op1);
        btnP1op4 = findViewById(R.id.btnP1op1);
        btnP2op1 = findViewById(R.id.btnP1op1);
        btnP2op2 = findViewById(R.id.btnP1op1);
        btnP2op3 = findViewById(R.id.btnP1op1);
        btnP2op4 = findViewById(R.id.btnP1op1);
        btnP3op1 = findViewById(R.id.btnP1op1);
        btnP3op2 = findViewById(R.id.btnP1op1);
        btnP3op3 = findViewById(R.id.btnP1op1);
        btnP3op4 = findViewById(R.id.btnP1op1);
        btnP4op1 = findViewById(R.id.btnP1op1);
        btnP4op2 = findViewById(R.id.btnP1op1);
        btnP4op3 = findViewById(R.id.btnP1op1);
        btnP4op4 = findViewById(R.id.btnP1op1);
        btnP5op1 = findViewById(R.id.btnP1op1);
        btnP5op2 = findViewById(R.id.btnP1op1);
        btnP5op3 = findViewById(R.id.btnP1op1);
        btnP5op4 = findViewById(R.id.btnP1op1);

    }

    public void save(View view){
        SQLiteOpenHelper admin = new AdminSQLiteHelper(this, "encuesta", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if(RadioGroupFrecuencia.isSelected() && RadioGroupCalidad.isSelected() && RadioGroupAtencion.isSelected() && RadioGroupHigiene.isSelected() && RadioGroupSala.isSelected()){
            ContentValues registro = new ContentValues();
            //registro.put("frecuencia", RadioGroupFrecuencia.);
        } else {

        }
    }
}