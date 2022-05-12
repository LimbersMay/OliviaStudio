package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Categoria_Docente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_docente);
    }

    public void volver(View view){
        Intent volverPerfil = new Intent(this, PerfilDocenteActivity.class);
        startActivity(volverPerfil);

        finish();
    }
}