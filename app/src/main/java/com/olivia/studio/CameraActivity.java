package com.olivia.studio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {

    ImageView picture;
    ImageButton imageButtonCamera;

    private static final int REQUEST_PERMISSION_CAMERA = 101;
    private static final int REQUEST_IMAGE_CAMERA = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //picture = findViewById(R.id.picture);
        imageButtonCamera = findViewById(R.id.imageButtonCamera);

        imageButtonCamera.setOnClickListener((view) -> {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ActivityCompat.checkSelfPermission(CameraActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                        openCamera();
                    }else{
                        ActivityCompat.requestPermissions(CameraActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CAMERA);
                    }
                }else{
                    openCamera();
                }

        });
    }

    public void back(View view){
        Intent regresar = new Intent(this, PerfilDocenteActivity.class);
        startActivity(regresar);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_PERMISSION_CAMERA){
            if(permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera();
            }else{
                Toast.makeText(this, "Necesitas habilitar los permisos", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAMERA){
            if (requestCode == Activity.RESULT_OK){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                picture.setImageBitmap(bitmap);
                Log.i("TAG", "Result=>" + bitmap);
            }
        }
    }
    */

    private void openCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(cameraIntent, REQUEST_IMAGE_CAMERA);
        }else{
            startActivityForResult(cameraIntent, REQUEST_IMAGE_CAMERA);
        }
    }

}