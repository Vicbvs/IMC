package com.dev.mendes.android_imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtPeso;
    private EditText edtAltura;
    private TextView result;
    private Button btnCalcular;
    private double imc;
    private double peso;
    private double altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = (EditText) findViewById(R.id.edt_peso);
        edtAltura = (EditText) findViewById(R.id.edt_altura);
        btnCalcular = (Button) findViewById(R.id.btn_calcular);

        // Responsavel pelo click do botao
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });


    }

    public void calcularIMC() {
        // Pega os valores recebido e calcula o imc
        peso = Double.parseDouble(edtPeso.getText().toString().replace(",", "."));
        altura = Double.parseDouble(edtAltura.getText().toString().replace(",", "."));
        double alturaQuadrado = altura * altura;
        imc = peso / alturaQuadrado;

        // Transfere para a outra activity com o valor calculado
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("resultado", imc);
        intent.putExtras(bundle);
        startActivity(intent);

    }


}
