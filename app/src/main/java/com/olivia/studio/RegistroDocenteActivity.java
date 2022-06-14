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

public class RegistroDocenteActivity extends AppCompatActivity {

    private EditText nombreTxt;
    private EditText apellidoPaternoTxt;
    private EditText apellidoMaternoTxt;
    private EditText cedulaTxt;
    private EditText codigoPostalTxt;
    private EditText contraseniaTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_docente);

        nombreTxt = findViewById(R.id.nombreDocente);
        apellidoPaternoTxt = findViewById(R.id.apellidoPaterno);
        apellidoMaternoTxt = findViewById(R.id.apellidoMaterno);
        cedulaTxt = findViewById(R.id.cedula_docente);
        codigoPostalTxt = findViewById(R.id.codigo_postal);
        contraseniaTxt = findViewById(R.id.contrasenia);
    }

    public void registrarse(View view){
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = adminDB.getReadableDatabase();

        String nombre = nombreTxt.getText().toString();
        String apellido_paterno = apellidoPaternoTxt.getText().toString();
        String apellido_materno = apellidoMaternoTxt.getText().toString();
        String cedula = cedulaTxt.getText().toString();
        String codigo_postal = codigoPostalTxt.getText().toString();
        String contrasenia = contraseniaTxt.getText().toString();

        // Comprobaciones para saber si el usuario ha puesto datos en los campos
        if (nombre.isEmpty() || apellido_paterno.isEmpty() || contrasenia.isEmpty() ||
                apellido_materno.isEmpty() || codigo_postal.isEmpty() || cedula.isEmpty()){

            Toast.makeText(this, "No puede haber ningún campo vacío", Toast.LENGTH_LONG).show();
            return;
        }

        // En caso de que no falte ninguna información, registramos al usuario
        ContentValues registro = new ContentValues();

        registro.put("nombre", nombre);
        registro.put("apellido_paterno", apellido_paterno);
        registro.put("apellido_materno", apellido_materno);
        registro.put("cedula", cedula);
        registro.put("codigo_postal", codigo_postal);
        registro.put("contrasenia", contrasenia);

        BaseDeDatos.insert("Docente", null, registro);
        BaseDeDatos.close();

        // Limpiamos los registros
        nombreTxt.setText("");
        apellidoPaternoTxt.setText("");
        apellidoMaternoTxt.setText("");
        cedulaTxt.setText("");
        codigoPostalTxt.setText("");
        contraseniaTxt.setText("");

        // Mensaje de confirmación de que se guardó el registro
        Toast.makeText(this, "El registro se completó éxitosamente", Toast.LENGTH_LONG).show();

        Intent perfil = new Intent(this, PerfilDocenteActivity.class);
        startActivity(perfil);
        finish();
    }

    public void cancelar(View view){

    }
}