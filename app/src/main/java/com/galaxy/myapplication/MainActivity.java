package com.galaxy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.galaxy.myapplication.dao.ClienteDAO;
import com.galaxy.myapplication.model.Cliente;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClienteDAO clienteDAO = new ClienteDAO(this);

        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setName("ABEL");
        cliente1.setLastname("VASQUEZ");
        cliente1.setAdress("VILLA CITY");
        cliente1.setAge(21);

        long insertando = clienteDAO.insertarCliente(cliente1);

        if (insertando>0){
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            Log.i(TAG,"REGISTRO");

            List<Cliente> cliente = clienteDAO.obtenerClientes();
            for (Cliente e:cliente){
                Log.i(TAG,e.toString());
            }

        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "NO REGISTRO");
        }

        //ACTUALIZANDO
        cliente1.setId(1);
        cliente1.setName("ALDO");
        cliente1.setLastname("VASQUEZ");
        cliente1.setAdress("VILLA SALVADOR");
        cliente1.setAge(21);

        int actualizando = clienteDAO.actualizarCliente(cliente1);

        if (actualizando>0){
            Log.i(TAG,"ACTUALIZO");

            List<Cliente> clientes = clienteDAO.obtenerClientes();
            Log.i(TAG,"existen "+clientes.size());
            for (Cliente e:clientes) {
                Log.i(TAG, e.toString());
            }
        }

        int eliminando = clienteDAO.eliminarCliente(1);

        if(eliminando>0){
            Log.i(TAG,"SI HAY DATA");

            List<Cliente> clientes = clienteDAO.obtenerClientes();
            Log.i(TAG,"existen "+clientes.size());
            for (Cliente e:clientes) {
                Log.i(TAG, e.toString());
            }
        }
       else {
            Log.i(TAG,"No se elimino");
        }

    }
}
