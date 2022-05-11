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


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView oliviastudioTextView = findViewById(R.id.oliviastudioTextView);
        TextView cargandoTextView = findViewById(R.id.cargandoTextView);
        ImageView logoImageView = findViewById(R.id.logoImageView);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        oliviastudioTextView.setAnimation(animacion1);
        logoImageView.setAnimation(animacion1);
        cargandoTextView.setAnimation(animacion2);
        progressBar.setAnimation(animacion2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, InicioActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);


    }
}