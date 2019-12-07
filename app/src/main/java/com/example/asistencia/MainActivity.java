package com.example.asistencia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ServiceCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText us, cla;
    private ProgressDialog progres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        us = (EditText)findViewById(R.id.et_us);
        cla = (EditText)findViewById(R.id.et_cla);



    }

    // metodo aceptar
    public void aceptar (View view){
        Intent i = new Intent(this, Main5Activity.class);
        startActivity(i);
    }


}











































































































/*
            SQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "asistencia", null,1);
            SQLiteDatabase basededatos= admin.getWritableDatabase();

            String user=us.getText().toString();
            String passw=cla.getText().toString();

            if(!user.isEmpty() && !passw.isEmpty()){
                Cursor fila=basededatos.rawQuery("select nombres, apellido, email from docentes where email='" + user + "' and pass='" + passw + "'",null);
                progres.setMessage("Cargando");
                progres.show();
                if(fila.moveToFirst()){
                    String nombres = fila.getString( 0);
                    String apellido = fila.getString( 1);
                    String email = fila.getString( 2);
                    Intent main = new Intent(this, Main2Activity.class);

                    main.putExtra("nombres", nombres);
                    main.putExtra("apellido", apellido);
                    main.putExtra("email", email);
                    progres.dismiss();
                    Toast.makeText(MainActivity.this,"Bienvenido" +nombres+" "+apellido+"", Toast.LENGTH_LONG).show();
                    startActivity(main);
                    basededatos.close();

                }else {
                    progres.dismiss();
                    Toast.makeText(MainActivity.this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                }

            }else{
                progres.dismiss();
                Toast.makeText(MainActivity.this, "Faltan ingresar datos", Toast.LENGTH_SHORT).show();
            }
        }

    // registrar
    public void registrar (View view){
        Intent i = new Intent(this, Main3Activity.class);
        startActivity(i);
    }
*/
/*
public void aceptar (View view) {
    Intent i = new Intent(this, Main2Activity.class);
    startActivity(i);

        String user=us.getText().toString();
        String passw=cla.getText().toString();

        if (user.equals("admin") && passw.equals("123")) {
            Intent i = new Intent(this, Main2Activity.class);
            startActivity(i);
            us.setText("");
            cla.setText("");

        } else {
            Toast.makeText(this, "usuario o clave incorrecto", Toast.LENGTH_SHORT).show();
            us.setText("");
            cla.setText("");
            us.requestFocus();
        }
}

 */