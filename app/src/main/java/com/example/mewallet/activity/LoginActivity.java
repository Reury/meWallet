package com.example.mewallet.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mewallet.R;
import com.example.mewallet.config.ConfiguracaoFirebase;
import com.example.mewallet.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class LoginActivity extends AppCompatActivity {


    private EditText campoEmail,campoSenha;
    private Button botaoEntrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoEntrar = findViewById(R.id.buttonEntrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if(!textoEmail.isEmpty()){
                    if(!textoSenha.isEmpty()){
                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        validarLogin();

                    }else{
                        Toast.makeText(LoginActivity.this,
                                "Preencha a senha",
                                Toast.LENGTH_LONG).show();


                    }
                }else{
                    Toast.makeText(LoginActivity.this,
                            "Prencha o email",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public  void validarLogin(){
        autenticacao = ConfiguracaoFirebase.getFireBaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            abrirTelaPrincipal();
                        }else{
                            String excecao ="";
                            try{
                                throw task.getException();
                            }catch (FirebaseAuthInvalidUserException e){
                                excecao = "Parece que vc ainda não fez seu cadastro!";
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                excecao = "Email ou senha ta Errado Visse" ;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(LoginActivity.this,
                                    excecao,
                                    Toast.LENGTH_LONG).show();



                            Toast.makeText(LoginActivity.this,"erro ao fazer login"
                                    ,Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void abrirTelaPrincipal(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
