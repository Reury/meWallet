package com.example.mewallet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.mewallet.R;
import com.example.mewallet.adapter.Adapter;
import com.example.mewallet.helper.ReceitaDAO;
import com.example.mewallet.helper.RecyclerItemClickListener;
import com.example.mewallet.model.Pessoa;
import com.example.mewallet.model.Receita;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtratoFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Receita> extrato = new ArrayList<>();
    private TextView saldoExtrato;

    public ExtratoFragment() {
        // Required empty public constructor
    }

//    public List<Receita> gerarExtrato(List<Receita> extrato, String tipo, String valor){
////
////        este metodo foi criado para testar o recyclerView
////
////
//        Receita receita = new Receita(tipo,valor);
//        extrato.add(receita);
//
////
////        Receita receita1 = new Receita("credito", "150,00");
////        this.extrato.add(receita1);
////        Receita receita2 = new Receita("debito", "20");
////        this.extrato.add(receita2);
////        Receita receita3 = new Receita("credito", "35,00");
////        this.extrato.add(receita3);
////        Receita receita4 = new Receita("credito", "35,00");
////        this.extrato.add(receita4);
////        Receita receita5 = new Receita("credito", "35,00");
////        this.extrato.add(receita5);
////        Receita receita6 = new Receita("credito", "3500,00");
////        this.extrato.add(receita6);
////        Receita receita7 = new Receita("debito", "40");
////        this.extrato.add(receita7);
////        Receita receita8 = new Receita("debito", "30");
////        this.extrato.add(receita8);
////        Receita receita9 = new Receita("debito", "120");
////        this.extrato.add(receita9);
////        Receita receita10 = new Receita("debito", "200");
////        this.extrato.add(receita10);
////        Receita receita11 = new Receita("debito", "20");
////        this.extrato.add(receita11);
//
//        return  extrato;
//    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_extrato, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        saldoExtrato = view.findViewById(R.id.saldoExtrato);

        Pessoa cliente = new Pessoa(0);
        double saldo;
        String saldoR;


        //listagem para exemplo
        //InserirReceitaFragment receita = new InserirReceitaFragment();
        //gerarExtrato();


        //Listar Tarefas

        // configurar adapter
        ReceitaDAO receita = new ReceitaDAO(getActivity().getApplicationContext());
        extrato = receita.listar();
        saldo = receita.soma();
        saldoR = Double.toString(saldo);
        saldoExtrato.setText("R$ "+saldoR);
        Adapter adapter = new Adapter(extrato);

        // configurar RecylerView
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


        //adicionar evento de clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity().getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Log.i("clique", "onItemClick");
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Log.i("clique", "onLongItemClick");

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                ));


        return view;
    }

}
