package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreenPerfilDocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen_perfil_docente);

        //Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView oliviastudioTextView3 = findViewById(R.id.oliviastudioTextView3);
        TextView cargandoTextView2 = findViewById(R.id.cargandoTextView2);
        ImageView logo3ImageView = findViewById(R.id.logo3ImageView);
        ProgressBar progressBar2 = findViewById(R.id.progressBar2);

        oliviastudioTextView3.setAnimation(animacion1);
        logo3ImageView.setAnimation(animacion1);
        cargandoTextView2.setAnimation(animacion2);
        progressBar2.setAnimation(animacion2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenPerfilDocenteActivity.this, PerfilDocenteActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}