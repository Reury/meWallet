package com.example.mewallet.config;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguracaoFirebase {

    private static FirebaseAuth autenticacao;


    // retorna a instancia do FireBase auth
    public static FirebaseAuth getFireBaseAutenticacao(){
        if(autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }

        return  autenticacao;
    }




}
