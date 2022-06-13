package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.olivia.helpers.AdminSQLiteOpenHelper;

public class activity_activity3_registro_alum extends AppCompatActivity {

    private EditText nombreTxt;
    private EditText correoTxt;
    private EditText contraseniaTxt;
    private EditText paisTxt;
    private EditText codigoPostalTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_registro_alum);

        // Variables de la interfaz
        nombreTxt = findViewById(R.id.nombreAlumno);
        correoTxt = findViewById(R.id.correoAlumno);
        contraseniaTxt = findViewById(R.id.contraseniaAlumno);
        paisTxt = findViewById(R.id.paisAlumno);
        codigoPostalTxt = findViewById(R.id.codigoPostalAlumno);
    }

    public void registrar(View view){
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = adminDB.getReadableDatabase();

        String nombre = nombreTxt.getText().toString();
        String correo = correoTxt.getText().toString();
        String contrasenia = contraseniaTxt.getText().toString();
        String pais = paisTxt.getText().toString();
        String codigoPostal = codigoPostalTxt.getText().toString();

        // Comprobaciones para saber si el usuario ha puesto datos en los campos
        if (nombre.isEmpty() || correo.isEmpty() || contrasenia.isEmpty() || pais.isEmpty() || codigoPostal.isEmpty()){
            Toast.makeText(this, "No puede haber ningún campo vacío", Toast.LENGTH_LONG).show();
            return;
        }

        // En caso de que no falte ninguna información, registramos al usuario
        ContentValues registro = new ContentValues();

        registro.put("nombre", nombre);
        registro.put("correo", correo);
        registro.put("contrasenia", contrasenia);
        registro.put("pais", pais);
        registro.put("codigoPostal", codigoPostal);

        BaseDeDatos.insert("Alumno", null, registro);
        BaseDeDatos.close();

        // Limpiamos los registros
        nombreTxt.setText("");
        correoTxt.setText("");
        contraseniaTxt.setText("");
        paisTxt.setText("");
        codigoPostalTxt.setText("");

        // Mensaje de confirmación de que se guardó el registro
        Toast.makeText(this, "El registro se completó éxitosamente", Toast.LENGTH_LONG).show();
    }
}