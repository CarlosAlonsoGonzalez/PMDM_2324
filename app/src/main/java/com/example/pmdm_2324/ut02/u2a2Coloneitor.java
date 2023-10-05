package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u2a2Coloneitor extends AppCompatActivity {

    SeekBar sbVerde;
    SeekBar sbRojo;
    SeekBar sbAzul;
    Button bt;
    TextView tv;
    Switch sw;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a2_coloneitor);

        sbVerde = findViewById(R.id.u2a2sbverde);
        sbRojo = findViewById(R.id.u2a2sbRojo);
        sbAzul = findViewById(R.id.u2a2sbAzul);
        bt = findViewById(R.id.u2a2btGenerar);
        tv = findViewById(R.id.u2a2tvRango);
        sw = findViewById(R.id.u2a2swBlancoONegro);
        et = findViewById(R.id.u2a2etNombre);

        bt.setOnClickListener((View v) ->{
            int rangoV = sbVerde.getProgress();
            int rangoR = sbRojo.getProgress();
            int rangoA = sbAzul.getProgress();
            int colorM = Color.rgb(rangoR,rangoV,rangoA);
            String colorNombre = et.getText().toString();
            tv.setBackgroundColor(colorM);
            tv.setText(colorNombre);

            if(sw.isChecked()) {
                tv.setTextColor(Color.BLACK);
            }else
                tv.setTextColor(Color.WHITE);

        });

    }

}