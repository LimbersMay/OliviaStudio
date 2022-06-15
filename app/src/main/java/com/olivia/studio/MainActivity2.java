package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.olivia.models.UsuarioLogIn;

public class MainActivity2 extends AppCompatActivity {

    private EditText usuarioTxt;
    private EditText contraseniaTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usuarioTxt = findViewById(R.id.usuario_inicio);
        contraseniaTxt = findViewById(R.id.contrasenia_inicio);
    }

    public void iniciarSesion(View view){

        // Objeto que nos servirá para validar las credenciales del usuario
        UsuarioLogIn usuarioLogIn = new UsuarioLogIn(this);

        String usuario = usuarioTxt.getText().toString();
        String contrasenia = contraseniaTxt.getText().toString();

        if (usuario.isEmpty() || contrasenia.isEmpty()){
            Toast.makeText(this, "No puede faltar ningún campo", Toast.LENGTH_LONG).show();
            return;
        }

        // Creamos el intent de perfil para navegar hacía él
        Intent perfil = new Intent(this, SplashScreenInicioSesionActivity.class);

        String registroExitoso = usuarioLogIn.IniciarSesion(usuario, contrasenia);

        if (registroExitoso != null){
            perfil.putExtra(registroExitoso, true);

            startActivity(perfil);
            finish();

            return;
        }

        // Si llegamos hasta aquí damos por hecho de que el registro no existe
        Toast.makeText(this, "El usuario o contraseña no son correctos", Toast.LENGTH_LONG).show();
    }

    public void registrarAlumno(View view){
        Intent perfil = new Intent(this, activity_activity3_registro_alum.class);
        startActivity(perfil);
        finish();
    }

    public void registrarDocente(View view){
        Intent perfil = new Intent(this, RegistroDocenteActivity.class);
        startActivity(perfil);
        finish();
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