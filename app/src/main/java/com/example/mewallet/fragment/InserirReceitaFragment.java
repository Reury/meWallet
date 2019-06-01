package com.example.mewallet.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.mewallet.R;
import com.example.mewallet.helper.ReceitaDAO;
import com.example.mewallet.model.Receita;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InserirReceitaFragment extends Fragment {
    public List<Receita> getReceita() {
        return receita;
    }

    public void setReceita(List<Receita> receita) {
        this.receita = receita;
    }

    private List<Receita> receita = new ArrayList<>();
    private View view;
    private Button inserir;
    private TextInputEditText editValor;
    private  TextInputEditText editCategoria;
    private ToggleButton toggleCredito;
    private ToggleButton toggleDebito;
    private String categoriaSelecionada;


    public List<Receita> gerarExtrato(List<Receita> extrato, String tipo, String valor){
//
//
        Receita receita = new Receita(tipo,valor);
        extrato.add(receita);

        return  extrato;
    }




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
        inserir = view.findViewById(R.id.insere);

        editValor = view.findViewById(R.id.editValor);
        editCategoria = view.findViewById(R.id.Receita);
        toggleCredito = view.findViewById(R.id.toggleReceita);
        toggleDebito = view.findViewById(R.id.toggleDespesa);


        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleCredito.isChecked()){
                    toggleDebito.setChecked(false);
                    toggleDebito.setSelected(false);
                    categoriaSelecionada = "Credito";
                }else if(toggleDebito.isChecked()){
                    toggleCredito.setSelected(false);
                    categoriaSelecionada = "Debito";
                }
                ReceitaDAO receitaDAO = new ReceitaDAO(getActivity().getApplicationContext());
                Receita receita = new Receita();
                receita.setDescricao(editCategoria.getText().toString());
                receita.setCategoria(categoriaSelecionada);
                receita.setValor(editValor.getText().toString());
                receitaDAO.salvar(receita);
                getActivity().getSupportFragmentManager().getPrimaryNavigationFragment();
            }
        });

        return view;
    }




}
