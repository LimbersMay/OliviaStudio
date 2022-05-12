package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    //estos son para login no los elimines...
    public void MensajeTwetter(View view) {
        Toast.makeText(this, "Twitter", Toast.LENGTH_SHORT).show();
    }
    public void MensajeGoogle(View view) {
        Toast.makeText(this, "Google",Toast.LENGTH_SHORT).show();
    }
    public void MensajeFacebook(View view) {
        Toast.makeText(this, "Facebook",Toast.LENGTH_SHORT).show();
    }

}