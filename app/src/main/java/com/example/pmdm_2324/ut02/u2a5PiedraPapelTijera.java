package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

import com.example.pmdm_2324.R;

public class u2a5PiedraPapelTijera extends AppCompatActivity {
    TextView tvContadorJugador, tvContadorMaquina, tvResultado;
    Button btReiniciar;
    ImageView ivPiedra, ivPapel, ivTijera, ivMaquinaElige;

    View.OnClickListener manejador;
    Random numeroRandom = new Random();

    public enum Juego{
        PIEDRA, PAPEL, TIJERA
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a5_piedra_papel_tijera);

        tvContadorJugador = findViewById(R.id.u2a5tvPuntoJugador);
        tvContadorMaquina = findViewById(R.id.u2a5tvPuntoMaquina);
        tvResultado = findViewById(R.id.u2a5tvResultado);
        btReiniciar = findViewById(R.id.u2a5btReiniciar);
        ivPiedra = findViewById(R.id.u2a5ivPiedra);
        ivPapel = findViewById(R.id.u2a5ivPapel);
        ivTijera = findViewById(R.id.u2a5ivTijera);
        ivMaquinaElige = findViewById(R.id.u2a5ivMaquinaElige);
        int numeroAleatorio = numeroRandom.nextInt(3);
        Juego eleccionMaquina = Juego.values()[numeroAleatorio];

        manejador = (View elQuePulsas) -> {
            ImageView seleccion = (ImageView) elQuePulsas;
            Juego eleccionJugador = null;

            if(elQuePulsas == ivPiedra){
                eleccionJugador = Juego.PIEDRA;
            }else if(elQuePulsas == ivPapel){
                eleccionJugador = Juego.PAPEL;
            }else if(elQuePulsas == ivTijera){
                eleccionJugador = Juego.TIJERA;
            }

            if (eleccionJugador == eleccionMaquina) {
                tvResultado.setText("¡¡Empate!!");


            } else if ((eleccionJugador == Juego.PIEDRA && eleccionMaquina == Juego.TIJERA) ||
                    (eleccionJugador == Juego.PAPEL && eleccionMaquina == Juego.PIEDRA) ||
                    (eleccionJugador == Juego.TIJERA && eleccionMaquina == Juego.PAPEL)) {
                tvResultado.setText("¡Has ganado!");

                // Convierte la cadena a un número
                int contadorJugador = Integer.parseInt(tvContadorJugador.getText().toString());

                // Incrementa el contador en 1
                contadorJugador++;

                // Actualiza el TextView con el nuevo valor
                tvContadorJugador.setText(String.valueOf(contadorJugador));
            } else {
                tvResultado.setText("La máquina gana...");
                int contadorMaquina = Integer.parseInt(tvContadorMaquina.getText().toString());

                // Incrementa el contador en 1
                contadorMaquina++;

                // Actualiza el TextView con el nuevo valor
                tvContadorMaquina.setText(String.valueOf(contadorMaquina));
            }
        };

        ivPiedra.setOnClickListener(manejador);
        ivPapel.setOnClickListener(manejador);
        ivTijera.setOnClickListener(manejador);

    }
}