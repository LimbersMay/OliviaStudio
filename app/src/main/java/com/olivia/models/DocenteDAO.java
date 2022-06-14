package com.olivia.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.olivia.domain.Docente;
import com.olivia.helpers.AdminSQLiteOpenHelper;

public class DocenteDAO {

    private Context context;

    public DocenteDAO(Context context){
        this.context = context;
    }
    
    public void registrarDocente(Docente docente){
        // Nos conectamos a la base de datos
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(context, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = adminDB.getReadableDatabase();

        // Creamos el contenido para la base de datos
        ContentValues registro = new ContentValues();

        registro.put("nombre", docente.getNombre());
        registro.put("apellido_paterno", docente.getApelldidoPaterno());
        registro.put("apellido_materno", docente.getApellidoMaterno());
        registro.put("cedula", docente.getCedula());
        registro.put("codigo_postal", docente.getCedula());
        registro.put("contrasenia", docente.getContrasenia());

        BaseDeDatos.insert("Alumno", null, registro);
        BaseDeDatos.close();
    }
}
