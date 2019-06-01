package com.example.mewallet.fragment;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.method.NumberKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mewallet.R;
import com.example.mewallet.helper.DbHelper;
import com.example.mewallet.helper.TarefaDAO;
import com.example.mewallet.model.Receita;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InserirReceitaFragment extends Fragment {
    private List<Receita> receita = new ArrayList<>();
    private View view;
    private Button inserir;
    private TextInputEditText editValor;


    public List<Receita> getExtrato() {
        return extrato;
    }

    public void setExtrato(List<Receita> extrato) {
        this.extrato = extrato;
    }

    private List<Receita> extrato = new ArrayList<>();
    public InserirReceitaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_receita, container, false);
        inserir = view.findViewById(R.id.insert);

        editValor = view.findViewById(R.id.editValor);
        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TarefaDAO tarefaDAO = new TarefaDAO(getActivity());
                Receita receita = new Receita();
                receita.setReceita("credito");
                receita.setValor(editValor.toString());
                tarefaDAO.salvar(receita);
            }
        });

        return view;
    }




}
