package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_activity3_registro_alum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_registro_alum);
    }

    public void registrar(View view){
        Intent perfil = new Intent(this, SplashScreenPerfilAlumnoActivity.class);
        startActivity(perfil);
        finish();
    }
    public void Cancelar(View view) {
        Intent Login = new Intent(this, MainActivity2.class);
        startActivity(Login);
        finish();
    }
}