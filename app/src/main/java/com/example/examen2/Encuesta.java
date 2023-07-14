package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {

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
        btnP1op2 = findViewById(R.id.btnP1op2);
        btnP1op3 = findViewById(R.id.btnP1op3);
        btnP1op4 = findViewById(R.id.btnP1op4);
        btnP2op1 = findViewById(R.id.btnP2op1);
        btnP2op2 = findViewById(R.id.btnP2op2);
        btnP2op3 = findViewById(R.id.btnP2op3);
        btnP2op4 = findViewById(R.id.btnP2op4);
        btnP3op1 = findViewById(R.id.btnP3op1);
        btnP3op2 = findViewById(R.id.btnP3op2);
        btnP3op3 = findViewById(R.id.btnP3op3);
        btnP3op4 = findViewById(R.id.btnP3op4);
        btnP4op1 = findViewById(R.id.btnP4op1);
        btnP4op2 = findViewById(R.id.btnP4op2);
        btnP4op3 = findViewById(R.id.btnP4op3);
        btnP4op4 = findViewById(R.id.btnP4op4);
        btnP5op1 = findViewById(R.id.btnP5op1);
        btnP5op2 = findViewById(R.id.btnP5op2);
        btnP5op3 = findViewById(R.id.btnP5op3);
    }

    public void save(View view){
        SQLiteOpenHelper admin = new AdminSQLiteHelper(this, "encuesta", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        // Evaluar que todas las preguntas se encuentren contestadas
        if(RadioGroupFrecuencia.getCheckedRadioButtonId() != -1 && RadioGroupCalidad.getCheckedRadioButtonId() != -1 && RadioGroupAtencion.getCheckedRadioButtonId() != -1 && RadioGroupHigiene.getCheckedRadioButtonId() != -1 && RadioGroupSala.getCheckedRadioButtonId() != -1){
            ContentValues registro = new ContentValues();
            //registro.put("frecuencia", RadioGroupFrecuencia.);
            // Registro de primer respuesta
            if(btnP1op1.isChecked()){
                registro.put("frecuencia", btnP1op1.getText().toString());
            } else if(btnP1op2.isChecked()){
                registro.put("frecuencia", btnP1op2.getText().toString());
            } else if(btnP1op3.isChecked()){
                registro.put("frecuencia", btnP1op3.getText().toString());
            } else if(btnP1op4.isChecked()){
                registro.put("frecuencia", btnP1op4.getText().toString());
            }
            // Registro de segunda respuesta
            if(btnP2op1.isChecked()){
                registro.put("calidad", btnP2op1.getText().toString());
            } else if(btnP2op2.isChecked()){
                registro.put("calidad", btnP2op2.getText().toString());
            } else if(btnP2op3.isChecked()){
                registro.put("calidad", btnP2op3.getText().toString());
            } else if(btnP2op4.isChecked()){
                registro.put("calidad", btnP2op4.getText().toString());
            }
            // Registro de tercer respuesta
            if(btnP3op1.isChecked()){
                registro.put("atencion", btnP3op1.getText().toString());
            } else if(btnP3op2.isChecked()){
                registro.put("atencion", btnP3op2.getText().toString());
            } else if(btnP3op3.isChecked()){
                registro.put("atencion", btnP3op3.getText().toString());
            } else if(btnP3op4.isChecked()){
                registro.put("atencion", btnP3op4.getText().toString());
            }
            // Registro de cuarta respuesta
            if(btnP4op1.isChecked()){
                registro.put("higiene", btnP4op1.getText().toString());
            } else if(btnP4op2.isChecked()){
                registro.put("higiene", btnP4op2.getText().toString());
            } else if(btnP4op3.isChecked()){
                registro.put("higiene", btnP4op3.getText().toString());
            } else if(btnP4op4.isChecked()){
                registro.put("higiene", btnP4op4.getText().toString());
            }
            // Registro de quinta respuesta
            if(btnP5op1.isChecked()){
                registro.put("sala", btnP5op1.getText().toString());
            } else if(btnP5op2.isChecked()){
                registro.put("sala", btnP5op2.getText().toString());
            } else if(btnP5op3.isChecked()){
                registro.put("sala", btnP5op3.getText().toString());
            }

            db.insert("encuesta", null, registro);
            db.close();

            Toast.makeText(this, "Encuesta Registrada", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Encuesta Incompleta", Toast.LENGTH_SHORT).show();
        }
    }
}