package com.rocio.poma.evaluacion2_tecnologiasemergentes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class AdminBD_SQL extends SQLiteOpenHelper {

    private static  final String NOMBRE_BD="votacion_te.db";
    private  static  final int VERSION_BD=1;
    private static final String TABLA_VOTACION="CREATE TABLE VOTACION1(ID text PRIMARY KEY,OPCIONA TEXT, OPCIONB TEXT, OPCIONC TEXT,OPCION D TEXT)";

    public AdminBD_SQL(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_VOTACION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLA_VOTACION);
        sqLiteDatabase.execSQL(TABLA_VOTACION);
    }
    public void agregarVotacion(String id,String opciona,String opcionb,String opcionc,String opciond){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO VOTACION1('"+id+"','"+opciona+"','"+opcionb+"','"+opcionc+"','"+opciond+"')");
            bd.close();
        }
    }
}
