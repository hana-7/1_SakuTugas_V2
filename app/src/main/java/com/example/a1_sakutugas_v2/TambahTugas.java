package com.example.a1_sakutugas_v2;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class TambahTugas extends AppCompatActivity {
    Button btnSimpan;
    TextView tvKeteranganTugas, tvNamaTugas, tvDeadline, tvDatePicker;
    EditText inputKeteranganTugas, inputNamaTugas;
    ImageView buttonDatePicker;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_tugas);

        btnSimpan = findViewById(R.id.btnSimpan);
        tvKeteranganTugas = findViewById(R.id.tvKeteranganTugas);
        tvNamaTugas = findViewById(R.id.tvNamaTugas);
        tvDeadline = findViewById(R.id.tvDeadline);
        tvDatePicker = findViewById(R.id.tvDatePicker);
        inputKeteranganTugas = findViewById(R.id.inputKeteranganTugas);
        inputNamaTugas = findViewById(R.id.inputNamaTugas);
        buttonDatePicker = findViewById(R.id.buttonDatePicker);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        TambahTugas.this, android.R.style.Theme_Holo_Dialog_MinWidth, setListener, year, month, day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "-" + month + "-" + year;
                tvDatePicker.setText(date);
            }
        };
    }
}