package com.olivia.studio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.olivia.domain.Alumno;
import com.olivia.models.AlumnoDAO;

public class activity_activity3_registro_alum extends AppCompatActivity {

    private EditText nombreTxt;
    private EditText correoTxt;
    private EditText contraseniaTxt;
    private EditText paisTxt;
    private EditText codigoPostalTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_registro_alum);

        // Variables de la interfaz
        nombreTxt = findViewById(R.id.nombreAlumno);
        correoTxt = findViewById(R.id.correoAlumno);
        contraseniaTxt = findViewById(R.id.contraseniaAlumno);
        paisTxt = findViewById(R.id.paisAlumno);
        codigoPostalTxt = findViewById(R.id.codigoPostalAlumno);
    }

    public void registrar(View view){

        AlumnoDAO alumnoDAO = new AlumnoDAO(this);

        // Obtenemos la información de los campos
        String nombre = nombreTxt.getText().toString();
        String correo = correoTxt.getText().toString();
        String contrasenia = contraseniaTxt.getText().toString();
        String pais = paisTxt.getText().toString();
        String codigoPostal = codigoPostalTxt.getText().toString();

        // Comprobaciones para saber si el usuario ha puesto datos en los campos
        if (nombre.isEmpty() || correo.isEmpty() || contrasenia.isEmpty() || pais.isEmpty() || codigoPostal.isEmpty()){
            Toast.makeText(this, "No puede haber ningún campo vacío", Toast.LENGTH_LONG).show();
            return;
        }

        // Creamos un objeto alumno para registrarlo
        Alumno alumno = new Alumno(nombre, correo, contrasenia, pais, codigoPostal);
        alumnoDAO.registrarAlumno(alumno);

        // Limpiamos los registros
        nombreTxt.setText("");
        correoTxt.setText("");
        contraseniaTxt.setText("");
        paisTxt.setText("");
        codigoPostalTxt.setText("");

        // Mensaje de confirmación de que se guardó el registro
        Toast.makeText(this, "El registro se completó éxitosamente", Toast.LENGTH_LONG).show();

        Intent perfilEstdudiante = new Intent(this, Activity_Perfil_Estudiante.class);
        startActivity(perfilEstdudiante);

        finish();
    }
}