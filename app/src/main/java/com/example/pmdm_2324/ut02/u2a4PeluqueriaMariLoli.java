package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.pmdm_2324.R;
import android.app.DatePickerDialog;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.TimePickerDialog;
import java.util.Calendar;

public class u2a4PeluqueriaMariLoli extends AppCompatActivity {

    Button btFecha, btHora, btPideYa;
    EditText etNombre, etTelefono, etDni;
    TextView tvFechaSeleccionada, tvHoraSeleccionada, tvNombre, tvTelefono, tvDni, tvCita, tvCitaConfirmada, tvError;
    ImageView ivConfirmacion;
    String citaConfirmada, hora, dia;


    private TimePickerDialog.OnTimeSetListener timePickerDialogListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a4_peluqueria_mari_loli);

        btFecha = findViewById(R.id.idBtnPickDate);
        btPideYa = findViewById(R.id.u2a4btPideYa);
        btHora = findViewById(R.id.idBtnPickTime);
        tvFechaSeleccionada = findViewById(R.id.idTVSelectedDate);
        tvHoraSeleccionada = findViewById(R.id.idTVSelectedTime);
        tvNombre = findViewById(R.id.u2a4tvNombreCompleto);
        tvTelefono = findViewById(R.id.u2a4tvTelefono);
        tvDni = findViewById(R.id.u2a4tvDni);
        tvCita = findViewById(R.id.u2a4tvPideCita);
        tvError = findViewById(R.id.u2a4tvError);
        etNombre = findViewById(R.id.u2a4etNombre);
        etTelefono = findViewById(R.id.u2a4etTelefono);
        etTelefono.setInputType(InputType.TYPE_CLASS_NUMBER);
        etDni = findViewById(R.id.u2a4etDni);
        ivConfirmacion = findViewById(R.id.u2a4ivConfirmacion);
        ivConfirmacion.setVisibility(View.GONE);
        tvCitaConfirmada = findViewById(R.id.u2a4tvCitaConfirmada);
        tvCitaConfirmada.setVisibility(View.GONE);

        timePickerDialogListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // Lógica para manejar adecuadamente las horas seleccionadas por el usuario
                String formattedTime;
                if (hourOfDay == 0) {
                    formattedTime = (minute < 10) ? "12:0" + minute + " am" : "12:" + minute + " am";
                } else if (hourOfDay > 12) {
                    formattedTime = (minute < 10) ? (hourOfDay - 12) + ":0" + minute + " pm" : (hourOfDay - 12) + ":" + minute + " pm";
                } else if (hourOfDay == 12) {
                    formattedTime = (minute < 10) ? "12:0" + minute + " pm" : "12:" + minute + " pm";
                } else {
                    formattedTime = (minute < 10) ? hourOfDay + ":0" + minute + " am" : hourOfDay + ":" + minute + " am";
                }
                tvHoraSeleccionada.setText(formattedTime);
            }
        };

        btFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene la instancia del calendario
                final Calendar c = Calendar.getInstance();

                // Obtiene el año, mes y día
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // Crea un diálogo del selector de fecha
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        u2a4PeluqueriaMariLoli.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year1, int monthOfYear, int dayOfMonth) {
                                // Establece la fecha en el TextView
                                dia = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1;
                                tvFechaSeleccionada.setText(dia);
                            }
                        },
                        year, month, day);
                // Muestra el diálogo de selección de fecha
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                datePickerDialog.show();
            }
        });

        btHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene la hora actual
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                tvError.setText("");
                btPideYa.setEnabled(true);

                // Crea un diálogo del selector de tiempo
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        u2a4PeluqueriaMariLoli.this,
                        (view, hourOfDay, minuteOfDay) -> {
                            if(hourOfDay < 9 || hourOfDay >= 14){
                                tvError.setText("");
                                tvError.setText("El horario introducido no pertenece a nuestro horario de apertura");
                                btPideYa.setEnabled(false);
                            }
                    // Lógica para manejar adecuadamente las horas seleccionadas por el usuario
                            String amPm;
                            if (hourOfDay == 0) {
                                amPm = "am";
                                hora = (minuteOfDay < 10) ? "12:0" + minuteOfDay + " am" : "12:" + minuteOfDay + " am";
                            } else if (hourOfDay > 12) {
                                amPm = "pm";
                                hora = (minuteOfDay < 10) ? (hourOfDay - 12) + ":0" + minuteOfDay + " pm" : (hourOfDay - 12) + ":" + minuteOfDay + " pm";
                            } else if (hourOfDay == 12) {
                                amPm = "am";
                                hora = (minuteOfDay < 10) ? "12:0" + minuteOfDay + " pm" : "12:" + minuteOfDay + " pm";
                            } else {
                                amPm = "pm";
                                hora = (minuteOfDay < 10) ? hourOfDay + ":0" + minuteOfDay + " am" : hourOfDay + ":" + minuteOfDay + " am";
                            }

                    // Puedes hacer lo que desees con formattedTime aquí mismo
                    // Por ejemplo, mostrarlo en un TextView
                    tvHoraSeleccionada.setText(hora);
                },
                        hour,
                        minute,
                        false);
                // Muestra el diálogo de selección de tiempo
                timePickerDialog.show();
            }
        });

        btPideYa.setOnClickListener((View v) -> {
            citaConfirmada = "Cita confirmada\n";
            if(!TextUtils.isEmpty(etNombre.getText())){
                citaConfirmada += String.valueOf(etNombre.getText()) + "\n";
            }else{
                tvError.setText("");
                tvError.setText("Introduzca un nombre");
                return;
            }

            if(!TextUtils.isEmpty(etTelefono.getText())){
                citaConfirmada += String.valueOf(etTelefono.getText()) + "\n";
            }else{
                tvError.setText("");
                tvError.setText("Introduzca un teléfono");
                return;
            }

            if(String.valueOf(etDni.getText()).matches("[0-9]{1,8}[A-Z]")){
                citaConfirmada += "DNI: " + String.valueOf(etDni.getText()) + "\n";
                tvError.setText("");
            }else {
                tvError.setText("");
                tvError.setText("Introduzca un DNI válido");
                return;
            }

            citaConfirmada += "Dia: " + dia + "\n";
            citaConfirmada += "Hora: " + hora;
            tvCitaConfirmada.setText(citaConfirmada);

            btPideYa.setVisibility(View.GONE);
            btHora.setVisibility(View.GONE);
            btFecha.setVisibility(View.GONE);
            tvHoraSeleccionada.setVisibility(View.GONE);
            tvFechaSeleccionada.setVisibility(View.GONE);
            etDni.setVisibility(View.GONE);
            etTelefono.setVisibility(View.GONE);
            etNombre.setVisibility(View.GONE);
            tvNombre.setVisibility(View.GONE);
            tvTelefono.setVisibility(View.GONE);
            tvDni.setVisibility(View.GONE);
            tvCita.setVisibility(View.GONE);
            ivConfirmacion.setVisibility(View.VISIBLE);
            tvCitaConfirmada.setVisibility(View.VISIBLE);
        });
    }
}