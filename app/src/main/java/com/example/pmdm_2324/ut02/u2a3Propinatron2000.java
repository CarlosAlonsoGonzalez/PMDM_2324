package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdm_2324.R;

import java.text.DecimalFormat;

public class u2a3Propinatron2000 extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btBorrarUlt, btClear, btCalcular;
    TextView tvCuenta, tvTotal;
    RadioButton rbBien, rbMal, rbRegular;
    View.OnClickListener manejador;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a3_propinatron2000);

        bt1 = findViewById(R.id.u2a3btUno);
        bt2 = findViewById(R.id.u2a3btDos);
        bt3 = findViewById(R.id.u2a3btTres);
        bt4 = findViewById(R.id.u2a3btCuatro);
        bt5 = findViewById(R.id.u2a3btCinco);
        bt6 = findViewById(R.id.u2a3btSeis);
        bt7 = findViewById(R.id.u2a3btSiete);
        bt8 = findViewById(R.id.u2a3btOcho);
        bt9 = findViewById(R.id.u2a3btNueve);
        bt0 = findViewById(R.id.u2a3btCero);
        btBorrarUlt = findViewById(R.id.u2a3btBorrarUlt);
        btClear = findViewById(R.id.u2a3btClear);
        btCalcular = findViewById(R.id.u2a3btCalcular);
        tvCuenta = findViewById(R.id.u2a3tvCuenta);
        tvTotal = findViewById(R.id.u2a3tvTotall);
        rbBien = findViewById(R.id.u2a3rbBien);
        rbRegular = findViewById(R.id.u2a3rbRegular);
        rbMal = findViewById(R.id.u2a3rbMal);


        manejador = (View elQuePulsas) -> {
            Button seleccion = (Button)elQuePulsas;
            if(elQuePulsas == btBorrarUlt){
                String cuenta = tvCuenta.getText().toString();
                cuenta = cuenta.substring(0, cuenta.length() - 1);
                tvCuenta.setText(cuenta);
            }else if(elQuePulsas == btClear){
                tvCuenta.setText("");
                tvTotal.setText("");
                rbBien.setChecked(false);
                rbRegular.setChecked(false);
                rbMal.setChecked(false);
            }else
                tvCuenta.append(seleccion.getText());

        };

        bt1.setOnClickListener(manejador);
        bt2.setOnClickListener(manejador);
        bt3.setOnClickListener(manejador);
        bt4.setOnClickListener(manejador);
        bt5.setOnClickListener(manejador);
        bt6.setOnClickListener(manejador);
        bt7.setOnClickListener(manejador);
        bt8.setOnClickListener(manejador);
        bt9.setOnClickListener(manejador);
        bt0.setOnClickListener(manejador);
        btBorrarUlt.setOnClickListener(manejador);
        btClear.setOnClickListener(manejador);

        btCalcular.setOnClickListener((View v) -> {
            double cuenta = Double.parseDouble(tvCuenta.getText().toString());
            String total;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            if(rbBien.isChecked()){
                cuenta = cuenta * 1.20;
                total = decimalFormat.format(cuenta);
                tvTotal.setText(total + "€");
            }else if(rbRegular.isChecked()){
                cuenta = cuenta * 1.10;
                total = decimalFormat.format(cuenta);
                tvTotal.setText(total + "€");
            }else if(rbMal.isChecked()){
                tvTotal.setText(tvCuenta.getText() + "€");

            }
        });


    }
}