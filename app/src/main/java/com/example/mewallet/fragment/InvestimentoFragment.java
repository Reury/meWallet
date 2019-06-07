package com.example.mewallet.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mewallet.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InvestimentoFragment extends Fragment {


    private EditText mesesInvestidos,valorInvestido;
    private TextView resultadoPoup,resultadoTesouro;
    private Button calcular;
    private double taxa,montante,capital,taxa2;

    /*
    TR = REMUNERACAO BASICA DA SELIC
    LEMRANDO QUE OCORRERA REMUNERACAO ADICIONAL A DEPENDER DA TAXA SELIC
    * */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_investimento, container, false);


        mesesInvestidos = view.findViewById(R.id.mesesInvestidos);
        valorInvestido = view.findViewById(R.id.valorInvestido);
        resultadoPoup = view.findViewById(R.id.resultadoPoupanca);
        resultadoTesouro = view.findViewById(R.id.resultadoTesouro);
        calcular = view.findViewById(R.id.buttonInvestir);
        taxa = (float) 1.005;
        taxa2 = (float) 1.01;


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String investido = valorInvestido.getText().toString();
                capital = Double.parseDouble(investido);
                String m = mesesInvestidos.getText().toString();
                double prazo = Double.parseDouble(m);
                montante = Math.pow(taxa,prazo);
                montante = montante * capital;
                String resultado;
                resultado = "O valor recebido em poupança e: R$";
                resultado = resultado + Double.toString(montante);

                resultadoPoup.setText(resultado);


                investido = valorInvestido.getText().toString();
                capital = Double.parseDouble(investido);
                m = mesesInvestidos.getText().toString();
                prazo = Double.parseDouble(m);
                montante = Math.pow(taxa2,prazo);
                montante = montante * capital;
                String resultado2;
                resultado2 = "O valor no tesouro 2035 e: R$";
                resultado2 = resultado2 + Double.toString(montante);

                resultadoTesouro.setText(resultado2);
            }
        });

        return view;
    }


}
