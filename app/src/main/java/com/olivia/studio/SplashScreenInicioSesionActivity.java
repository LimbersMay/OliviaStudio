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

public class SplashScreenInicioSesionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen_inicio_sesion);

        //Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView oliviastudioTextView4 = findViewById(R.id.oliviastudioTextView4);
        TextView iniciandoTextView = findViewById(R.id.iniciandoTextView);
        ImageView logo4ImageView = findViewById(R.id.logo4ImageView);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        oliviastudioTextView4.setAnimation(animacion1);
        logo4ImageView.setAnimation(animacion1);
        iniciandoTextView.setAnimation(animacion2);
        progressBar.setAnimation(animacion2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenInicioSesionActivity.this, PerfilDocenteActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}