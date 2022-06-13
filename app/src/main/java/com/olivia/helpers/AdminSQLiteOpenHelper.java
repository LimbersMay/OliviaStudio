package com.olivia.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase oliviaStudioDB) {
        oliviaStudioDB.execSQL("CREATE TABLE Alumno(Id_alumno INTEGER PRIMARY KEY, nombre text, correo text, contrasenia text, " +
                "pais text, codigoPostal text)");

        oliviaStudioDB.execSQL("CREATE TABLE Docente(Id_docente INTEGER PRIMARY KEY, nombre TEXT, apellido_paterno TEXT, " +
                "apellido_materno TEXT, cedula TEXT, codigo_postal TEXT, contrasenia TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
