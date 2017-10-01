package com.galaxy.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.galaxy.myapplication.model.Cliente;

import java.sql.ClientInfoStatus;


public class MySQLOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "mydb.db";
    public static final Integer DB_VERSION = 1;

    public MySQLOpenHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    private static StringBuilder CREATE_TABLE = new StringBuilder()
            .append("CREATE TABLE "+ Cliente.TABLE_NAME+" (")
            .append(Cliente.ID_FIELD+" INTEGER PRIMARY KEY autoincrement,")
            .append(Cliente.NAME__FIELD+" TEXT,")
            .append(Cliente.LASTNAME_FIELD+" TEXT,")
            .append(Cliente.ADRESS_FIELD+" TEXT,")
            .append(Cliente.AGE_FIELD+" INTEGER ) ");

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
