package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PerfilDocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_docente);
    }

    public void cerrarSesion(View view){
        Intent iniciarSesion = new Intent(this, MainActivity2.class);
        startActivity(iniciarSesion);
        finish();
    }

    public void irCategoriaMaterias(View view){
        Intent categoriaMaterias = new Intent(this, Categoria_Docente.class);
        startActivity(categoriaMaterias);
        finish();
    }
}