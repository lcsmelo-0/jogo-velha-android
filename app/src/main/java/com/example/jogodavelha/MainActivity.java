package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        if(getJogadorAtual() == X){
            setJogadorAtual(BOLINHA);
            ((Button)v).setText(BOLINHA);
        } else{
            setJogadorAtual(X);
            ((Button)v).setText(X);
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
