package com.galaxy.myapplication.dao;


import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.galaxy.myapplication.MySQLOpenHelper;
import com.galaxy.myapplication.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private MySQLOpenHelper mySQLOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public ClienteDAO(Context context){
        this.mySQLOpenHelper = new MySQLOpenHelper(context);
        this.sqLiteDatabase = mySQLOpenHelper.getWritableDatabase();
    }

    public long insertarCliente(Cliente cliente){

        long result;

        ContentValues contentValues = new ContentValues();
        contentValues.put(Cliente.ID_FIELD,cliente.getId());
        contentValues.put(Cliente.NAME__FIELD,cliente.getName());
        contentValues.put(Cliente.LASTNAME_FIELD,cliente.getLastname());
        contentValues.put(Cliente.ADRESS_FIELD,cliente.getAdress());
        contentValues.put(Cliente.AGE_FIELD,cliente.getAge());

        try {
            openDB();
            result = sqLiteDatabase.insert(Cliente.TABLE_NAME,null,contentValues);
        }catch (SQLException e){
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int actualizarCliente(Cliente cliente){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Cliente.NAME__FIELD,cliente.getName());
        contentValues.put(Cliente.LASTNAME_FIELD,cliente.getLastname());
        contentValues.put(Cliente.ADRESS_FIELD,cliente.getAdress());
        contentValues.put(Cliente.AGE_FIELD,cliente.getAge());

        String whereClause = Cliente.ID_FIELD+"=?";
        String[] whereArgs = {cliente.getId().toString()};

        int result = sqLiteDatabase.update(Cliente.TABLE_NAME,contentValues,whereClause,whereArgs);
        return result;
    }

    public int eliminarCliente(Integer mcliente){

        String whereClause = Cliente.ID_FIELD+"=?";
        String[] whereArgs = {String.valueOf(mcliente)};

        int result = sqLiteDatabase.delete(Cliente.TABLE_NAME,whereClause,whereArgs);

        return result;
    }

    public List<Cliente> obtenerClientes(){

        String[] fields = {
                Cliente.ID_FIELD,
                Cliente.NAME__FIELD,
                Cliente.LASTNAME_FIELD,
                Cliente.ADRESS_FIELD,
                Cliente.AGE_FIELD
        };

        Cursor cursor = sqLiteDatabase.query(Cliente.TABLE_NAME,fields,null,null,null,null,null);

        return convertirCursor(cursor);

    }

    public List<Cliente> convertirCursor(Cursor cursor){

        List<Cliente> arraysClientes = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                Cliente cliente = new Cliente();
                cliente.setId(cursor.getInt(cursor.getColumnIndex(Cliente.ID_FIELD)));
                cliente.setName(cursor.getString(cursor.getColumnIndex(Cliente.NAME__FIELD)));
                cliente.setLastname(cursor.getString(cursor.getColumnIndex(Cliente.LASTNAME_FIELD)));
                cliente.setAdress(cursor.getString(cursor.getColumnIndex(Cliente.ADRESS_FIELD)));
                cliente.setAge(cursor.getInt(cursor.getColumnIndex(Cliente.AGE_FIELD)));

                arraysClientes.add(cliente);

            }while (cursor.moveToNext());
        }
        return arraysClientes;
    }

    public void closeDB(){
        sqLiteDatabase.close();
    }

    public void openDB(){
        if (!sqLiteDatabase.isOpen()){
            this.sqLiteDatabase = mySQLOpenHelper.getWritableDatabase();
        }

    }


}
