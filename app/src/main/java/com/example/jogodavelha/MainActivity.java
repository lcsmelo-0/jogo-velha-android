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
    int[][] estadoFinal = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},

            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},

            {1, 5, 9},
            {3, 5, 7},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(getLayoutInflater().inflate(R.layout.activity_main, null));
        setContentView(getView());
    }

    public Button getQuadrado(int tagNum){
        return (Button)getView().findViewWithTag(QUADRADO + tagNum);
    }

    public void habilitarQuadrado(boolean bool){
        for(int i = 1; i <=9; i++){
            if(getQuadrado(i) != null){
                getQuadrado(i).setEnabled(bool);
            }
        }
    }

    public void verificarFinal(){
        for(int x =0; x<=7; ++x){
            String s1 = getQuadrado(estadoFinal[x][0]).getText().toString();
            String s2 = getQuadrado(estadoFinal[x][1]).getText().toString();
            String s3 = getQuadrado(estadoFinal[x][2]).getText().toString();

            if(!s1.equals("") && !s2.equals("") && !s3.equals("")){
                if(s1.equals(s2) && (s2.equals(s3))){
                    Toast.makeText(getView().getContext(), "Venceu o jogador " + this.jogadorAtual, Toast.LENGTH_LONG).show();
                    this.habilitarQuadrado(false);
                }
            }
        }
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
            this.verificarFinal();
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
                habilitarQuadrado(true);            }
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
