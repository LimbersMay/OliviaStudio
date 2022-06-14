package com.olivia.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.olivia.helpers.AdminSQLiteOpenHelper;

public class UsuarioLogIn {

    private Context context;

    String SQL_SELECT_DOCENTE = "SELECT * FROM Docente WHERE nombre=? AND contrasenia=?";
    String SQL_SELECT_ALUMNO = "SELECT * FROM Alumno WHERE nombre=? AND contrasenia=?";

    // Clase encargada de valuar los inicios de sesión de los usuarios y validar sus credenciales
    public UsuarioLogIn(Context context){
        this.context = context;
    }

    public String IniciarSesion(String usuario, String contrasenia){
        // Nos conectamos a la base de datos
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(context, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = adminDB.getReadableDatabase();

        // Obtenemos la información de inicio de sesión
        String[] datos = {usuario, contrasenia};

        // Declaramos el cursor para realizar las consultas
        Cursor fila = null;

        // Comprobamos si las credenciales coinciden con la de algún alumno
        fila = BaseDeDatos.rawQuery(this.SQL_SELECT_ALUMNO, datos);
        if (fila.getCount() > 0){
            fila.close(); // Cerramos el cursor

            return "Alumno";
        }

        // Comprobamos si las credenciales coinciden con la de algún docente
        fila = BaseDeDatos.rawQuery(this.SQL_SELECT_DOCENTE, datos);
        if (fila.getCount() > 0){
            fila.close(); // Cerramos el cursor

            return "Docente";
        }

        // Si llegamos al final quiere decir que no se encontró ningún registro de ambos
        return null;
    }
}
