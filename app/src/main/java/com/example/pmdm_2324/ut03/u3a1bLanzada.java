package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3a1bLanzada extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1b_lanzada);

        tv = findViewById(R.id.u3a1tvSaludo);

        Bundle info =  getIntent().getExtras();
        String sInfo = info.getString(u3a1aLanza.INFO_NOMBRE);

        tv.setText(tv.getText() + sInfo);
    }
}