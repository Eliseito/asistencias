package com.example.asistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private EditText cod, docu, nomb, dire, tele, apet, us, ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cod = (EditText)findViewById(R.id.et_cod);
        docu = (EditText)findViewById(R.id.et_dni);
        nomb = (EditText)findViewById(R.id.et_nombre);
        dire = (EditText)findViewById(R.id.et_direccion);
        tele = (EditText)findViewById(R.id.et_telefono);
        apet = (EditText)findViewById(R.id.et_apellido);
        us = (EditText)findViewById(R.id.et_us);
        ps = (EditText)findViewById(R.id.et_pas);

    }

    //metodo para registrar
    public void registrar (View view){
        AdminSQLiteOpenHelper admi = new AdminSQLiteOpenHelper(this, "asistencia", null, 1);

        SQLiteDatabase BasedeDatos = admi.getWritableDatabase();
        //convertir a cadena de texto
        String codigo = cod.getText().toString();
        String dni = docu.getText().toString();
        String nombre = nomb.getText().toString();
        String direccion = dire.getText().toString();
        String telefono = tele.getText().toString();
        String apellido = apet.getText().toString();
        String usuario = us.getText().toString();
        String password = ps.getText().toString();

        if (!codigo.isEmpty() && !dni.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !usuario.isEmpty() && !password.isEmpty()){

            ContentValues registra = new ContentValues();

            registra.put("codigo", codigo);
            registra.put("dni", dni);
            registra.put("nombres", nombre);
            registra.put("apellido", apellido);
            registra.put("direccion", direccion);
            registra.put("telefono", telefono);
            registra.put("email", usuario);
            registra.put("pass", password);


            BasedeDatos.insert("docentes", null, registra);
            BasedeDatos.close();

            cod.setText("");
            docu.setText("");
            nomb.setText("");
            dire.setText("");
            tele.setText("");
            apet.setText("");
            us.setText("");
            ps.setText("");

            Toast.makeText(this, "Gracias por registrarse", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para buscar
    public void buscar (View view){
        AdminSQLiteOpenHelper admi = new AdminSQLiteOpenHelper(this, "asistencia", null, 1);

        SQLiteDatabase BasedeDatos = admi.getWritableDatabase();

        String codigo = cod.getText().toString();

        if (!codigo.isEmpty()){
            Cursor fila = BasedeDatos.rawQuery("select dni, nombres, apellido, direccion, telefono, email, pass from docentes where codigo="+ codigo, null);

            if (fila.moveToFirst()){//movetofirst es para rrecorrer toda la tabla
                docu.setText(fila.getString(0));
                nomb.setText(fila.getString(1));
                apet.setText(fila.getString(2));
                dire.setText(fila.getString(3));
                tele.setText(fila.getString(4));
                us.setText(fila.getString(5));
                ps.setText(fila.getString(6));


                BasedeDatos.close();
            }else{
                Toast.makeText(this, "El docente no esta rregistrado", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Que buscas?", Toast.LENGTH_SHORT).show();
        }
    }
}
