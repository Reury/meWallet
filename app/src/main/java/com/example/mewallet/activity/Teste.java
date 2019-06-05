package com.example.mewallet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mewallet.R;
import com.example.mewallet.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.app.NavigationPolicy;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class Teste extends IntroActivity {


    private FirebaseAuth autenticacao;


    @Override
    protected void onStart() {
        super.onStart();
        verificarSeUsuarioLogado();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_teste);

//        setButtonBackVisible(false);
//        setButtonNextVisible(false);
//
//        addSlide(new SimpleSlide.Builder().title("Primeiro SLide")
//                .description("Intro")
//                .image(R.drawable.um)
//                .background(android.R.color.holo_orange_light)
//                .build()
//        );
//        addSlide(new SimpleSlide.Builder().title("Segundo SLide")
//                .description("Seguinte")
//                .image(R.drawable.dois)
//                .background(android.R.color.holo_orange_light)
//                .build()
//        );

        setNavigationPolicy(new NavigationPolicy() {
            @Override public boolean canGoForward(int position) {
                return true;
            }

            @Override public boolean canGoBackward(int position) {
                return false;
            }
        });
        verificarSeUsuarioLogado();

        setButtonNextVisible(false);
        setButtonBackVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_1)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_2)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_3)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_cadastro)
                .build()
        );






    }


    public void btEntrar(View view){
        startActivity(new Intent(this,LoginActivity.class));

    }


    public  void btCadastrar(View view){
        startActivity(new Intent(this, CadastroActivity.class));

    }
    public void  verificarSeUsuarioLogado(){

        autenticacao = ConfiguracaoFirebase.getFireBaseAutenticacao();
        if(autenticacao.getCurrentUser() != null){
            abrirTelaPrincipal();
        }
    }

    public void abrirTelaPrincipal(){
        startActivity(new Intent(this,MainActivity.class));
    }

}
