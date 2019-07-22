package com.example.recyclerview_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAcces {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static  DatabaseAcces instance;
    Cursor c = null;


    // private constructor so that object creation from outside the class is avoided
    private DatabaseAcces (Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    // to return the single instance of database
    public  static DatabaseAcces getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAcces(context);
        }

        return instance;
    }

    // to open the database
    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    // closing the database connection
    public void close(){
        if(db != null){
            this.db.close();
        }
    }

    public ArrayList<PersonajeVo> getGrupos(){
        c = db.rawQuery("SELECT gru_nombre FROM grupos WHERE gru_emp_clave = 1 ORDER BY gru_nombre", new String[]{});

        ArrayList <PersonajeVo> grupos = new ArrayList<PersonajeVo>();

        while (c.moveToNext()){
            grupos.add(new PersonajeVo(c.getString(0), R.drawable.mango));
        }

        return grupos;
    }


}