package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String QUADRADO = "quadrado";
    private final String BOLINHA = "0";
    private final String X = "X";
    private String jogadorAtual = X;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(getLayoutInflater().inflate(R.layout.activity_main, null));
        setContentView(getView());
    }

    public Button getQuadrado(int tagNum){
        return (Button)getView().findViewWithTag(QUADRADO + tagNum);
    }

    public void jogadaQuadrado (View v){
        if(((Button)v).getText().equals("")){
            if(getJogadorAtual() == X){
                setJogadorAtual(BOLINHA);
                ((Button)v).setText(BOLINHA);
            } else{
                setJogadorAtual(X);
                ((Button)v).setText(X);
            }
        } else{
            Toast.makeText(getView().getContext(), "Escolha outro quadrado", Toast.LENGTH_LONG).show();
        }
    }

    public void novoJogo(View v){
        ((Button)findViewById(R.id.botaoAcao)).setText("Recomeçar");
        Toast.makeText(getView().getContext(), "Novo jogo iniciado", Toast.LENGTH_LONG).show();

        for(int i = 1; i<= 9; i++){
            if(getQuadrado(i) != null){
                getQuadrado(i).setText("");
                getQuadrado(i).setEnabled(true);
            }
        }
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(String jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }
}
