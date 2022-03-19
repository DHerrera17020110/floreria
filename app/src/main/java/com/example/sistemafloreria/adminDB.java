package com.example.sistemafloreria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
//CLASE CREADORA DE TABLAS CON LA EXTENSION DE SQL
public class adminDB extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;

    private static final String Nombre_BD="ejercicio";
    //2 TABLAS CREADAS
    private  static final String clientes= "CREATE TABLE CLIENTES(" + " id_cli INTEGER PRIMARY KEY, "+"nombre_cli TEXT," +"edad TEXT,"+"telefono TEXT,"+ "sexo TEXT);";
    private static final String flores="CREATE TABLE FLORES("+ "id_flores integrer primary key,"+"tipo TEXT,"+"precio DOUBLE,"+"cantidad DOUBLE,"+"color TEXTO);";

    public adminDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase BD) {
        BD.execSQL(clientes);
        BD.execSQL(flores);
    }

    @Override
    public void onUpgrade(SQLiteDatabase BD, int oldVersion, int newVersion) {
  BD.execSQL("drop table if exists clientes");
  BD.execSQL("drop table if exists flores");
  onCreate(BD);
    }
}
