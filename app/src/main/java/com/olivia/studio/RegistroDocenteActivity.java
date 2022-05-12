package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistroDocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_docente);
    }

    public void registrarse(View view){

        Intent screenPerfilDocente = new Intent(this, SplashScreenPerfilDocenteActivity.class);
        startActivity(screenPerfilDocente);
        finish();
    }
}