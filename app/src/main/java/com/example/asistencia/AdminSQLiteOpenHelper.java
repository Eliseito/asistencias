package com.example.asistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase basededatos) {
        basededatos.execSQL("create table docentes (codigo int primary key autoincrement, dni text, nombres text, apellido text, direccion text, telefono text, email texto, pass texto)");
        basededatos.execSQL("create table asistencia (cod_asis int primary key autoincrement, codigo int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
