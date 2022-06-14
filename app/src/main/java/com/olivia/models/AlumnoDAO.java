package com.olivia.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.olivia.domain.Alumno;
import com.olivia.helpers.AdminSQLiteOpenHelper;

public class AlumnoDAO {

    private Context context;

    public AlumnoDAO(Context context){
        this.context = context;
    }

    public void registrarAlumno(Alumno alumno){

        // Nos conectamos a la base de datos
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(context, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = adminDB.getReadableDatabase();

        // Creamos el contenido para la base de datos
        ContentValues registro = new ContentValues();

        registro.put("nombre", alumno.getNombre());
        registro.put("correo", alumno.getCorreo());
        registro.put("contrasenia", alumno.getContrasenia());
        registro.put("pais", alumno.getPais());
        registro.put("codigoPostal", alumno.getCodigoPostal());

        BaseDeDatos.insert("Alumno", null, registro);
        BaseDeDatos.close();
    }
}
