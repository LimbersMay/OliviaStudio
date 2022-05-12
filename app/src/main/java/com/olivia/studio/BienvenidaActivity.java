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

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bienvenida);

        //Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView oliviastudioTextView = findViewById(R.id.oliviastudioTextView);
        TextView bienvenidoTextView = findViewById(R.id.bienvenidoTextView);
        ImageView logoBienvenidaImageView = findViewById(R.id.logoBienvenidaImageView);


        oliviastudioTextView.setAnimation(animacion1);
        logoBienvenidaImageView.setAnimation(animacion1);
        bienvenidoTextView.setAnimation(animacion2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BienvenidaActivity.this, SplashScreenPerfilAlumnoActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}