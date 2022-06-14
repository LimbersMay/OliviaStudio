package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.olivia.helpers.AdminSQLiteOpenHelper;

public class MainActivity2 extends AppCompatActivity {

    private EditText usuarioTxt;
    private EditText contraseniaTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usuarioTxt = findViewById(R.id.usuario_inicio);
        contraseniaTxt = findViewById(R.id.contrasenia_inicio);
    }

    public void iniciarSesion(View view){

        // Comprobamos si el registro que proporcionó el usuario existe
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDataBase = adminDB.getWritableDatabase();

        String usuario = usuarioTxt.getText().toString();
        String contrasenia = contraseniaTxt.getText().toString();

        if (usuario.isEmpty() || contrasenia.isEmpty()){
            Toast.makeText(this, "No puede faltar ningún campo", Toast.LENGTH_LONG).show();
            return;
        }

        // Creamos el intent de perfil para navegar hacía él
        Intent perfil = new Intent(this, SplashScreenInicioSesionActivity.class);

        String SQL_SELECT_DOCENTE = "SELECT * FROM Docente WHERE nombre=? AND contrasenia=?";
        String SQL_SELECT_ALUMNO = "SELECT * FROM Alumno WHERE nombre=? AND contrasenia=?";

        // Ponemos en un arreglo los valores de usuario y contrasenia
        String[] datos = {usuario, contrasenia};

        // En caso de que si haya proporcionado ambos datos
        // Verificamos si la información es la de un docente
        Cursor fila = null;

        fila = BaseDataBase.rawQuery(SQL_SELECT_DOCENTE, datos);
        // Verificamos si la fila tiene filas de información
        if (fila.getCount() > 0){
            fila.close();

            perfil.putExtra("docente", true);
            startActivity(perfil);
            finish();

            return;
        }

        // Verificamos si la información concuerda con la de un alumno
        fila = BaseDataBase.rawQuery(SQL_SELECT_ALUMNO, datos);
        if (fila.getCount() > 0){
            fila.close();

            perfil.putExtra("alumno", true);
            startActivity(perfil);
            finish();

            return;
        }

        // Si llegamos hasta aquí damos por hecho de que el registro no existe
        Toast.makeText(this, "El usuario o contraseña no son correctos", Toast.LENGTH_LONG).show();
    }

    public void registrarAlumno(View view){
        Intent perfil = new Intent(this, activity_activity3_registro_alum.class);
        startActivity(perfil);
        finish();
    }

    public void registrarDocente(View view){
        Intent perfil = new Intent(this, RegistroDocenteActivity.class);
        startActivity(perfil);
        finish();
    }

    //estos son para login no los elimines...
    public void MensajeTwetter(View view) {
        Toast.makeText(this, "Twitter", Toast.LENGTH_SHORT).show();
    }
    public void MensajeGoogle(View view) {
        Toast.makeText(this, "Google",Toast.LENGTH_SHORT).show();
    }
    public void MensajeFacebook(View view) {
        Toast.makeText(this, "Facebook",Toast.LENGTH_SHORT).show();
    }

}