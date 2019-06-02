package com.example.mewallet.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mewallet.R;
import com.example.mewallet.model.Receita;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Receita> extrato;

    public Adapter(List<Receita> extrato) {
        this.extrato = extrato;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemExtrato = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_receita,viewGroup,false);

        return new MyViewHolder(itemExtrato);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        Receita conta = extrato.get(i);
        String categoria = conta.getCategoria();
        String valor = conta.getValor();
        myViewHolder.receita.setText(categoria);
        if(conta.getCategoria().equals("Debito")){
            myViewHolder.valor.setText("R$ " + "-"+ valor);
        }else{
            myViewHolder.valor.setText("R$" + valor);
        }


    }

    @Override
    public int getItemCount() {

        return this.extrato.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView receita;
        //TextView descricao;
        TextView valor;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            receita = itemView.findViewById(R.id.receita);
            valor = itemView.findViewById(R.id.editValor);
        }
    }

}
