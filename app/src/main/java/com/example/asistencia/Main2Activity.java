package com.example.asistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    // registrar
    public void registrar (View view){
        Intent i = new Intent(this, Main3Activity.class);
        startActivity(i);
    }

    //registrar asistencia
    public void asistencia (View view){
        Intent i = new Intent(this, Main4Activity.class);
        startActivity(i);
    }
}
