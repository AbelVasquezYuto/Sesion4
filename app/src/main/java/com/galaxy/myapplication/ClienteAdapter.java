package com.galaxy.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.galaxy.myapplication.model.Cliente;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder> {

    private List<Cliente> clientes;

    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_item,parent,false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, int position) {
        Cliente cliente=clientes.get(position);
        holder.mTv_name.setText(cliente.getName());
        holder.mTv_lastname.setText(cliente.getLastname());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ClienteViewHolder extends RecyclerView.ViewHolder{

        TextView mTv_name, mTv_lastname;
        Button mBt_editar;

        public ClienteViewHolder(View itemView){
            super(itemView);

            mTv_name = itemView.findViewById(R.id.Tv_name);
            mTv_lastname = itemView.findViewById(R.id.Tv_last_name);
            mBt_editar = itemView.findViewById(R.id.Bt_editar);

        }



    }

}
