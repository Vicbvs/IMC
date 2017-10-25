package com.dev.mendes.android_imc;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView txtResultadoImc;
    private TextView txtSituacao;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResultadoImc = (TextView) findViewById(R.id.txt_resultado_imc);
        txtSituacao = (TextView) findViewById(R.id.txt_situacao);

        // Recupera o valor do imc recebido da outra activity
        Bundle bundle = getIntent().getExtras();
        double  resultado = bundle.getDouble("resultado");
        DecimalFormat formato = new DecimalFormat("#.##");
        resultado = Double.valueOf(formato.format(resultado));
        txtResultadoImc.setText(String.valueOf(resultado));

        // Verifica o valor do imc com a situacao
        if (resultado < 17) {
            txtSituacao.setText(R.string.muito_abaixo_peso);
        } else if (resultado > 17 && resultado < 18.49){
            txtSituacao.setText(R.string.abaixo_peso);
        } else if (resultado > 18.5 && resultado < 24.99){
            txtSituacao.setText(R.string.peso_normal);
        } else if (resultado > 25 && resultado <  29.99){
            txtSituacao.setText(R.string.acima_do_peso);
        } else if (resultado > 30 && resultado < 34.99){
            txtSituacao.setText(R.string.obesidade_1);
        } else  if (resultado > 35 && resultado < 39.99){
            txtSituacao.setText(R.string.obesidade_2);
        } else if (resultado > 40) {
            txtSituacao.setText(R.string.obesidade_3);
        }

    }
}
