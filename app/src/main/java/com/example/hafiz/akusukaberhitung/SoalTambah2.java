package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoalTambah2 extends AppCompatActivity {

    private Button pilihan1, pilihan2,pilihan3;
    private TextView nilai;
    private int totalNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_tambah2);

        Intent intent=getIntent();
        totalNilai=intent.getIntExtra("totalNilai",0);

        nilai=(TextView) findViewById(R.id.nilai);
        nilai.setText(String.valueOf(totalNilai));

        pilihan1=(Button) findViewById(R.id.jawaban1);
        pilihan2=(Button) findViewById(R.id.jawaban2);
        pilihan3=(Button) findViewById(R.id.jawaban3);

        pilihan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalNilai=totalNilai+1;
                Intent intent=new Intent(SoalTambah2.this, SoalTambah3.class);
                intent.putExtra("totalNilai", totalNilai);
                startActivity(intent);
            }
        });
        pilihan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SoalTambah2.this, SoalTambah3.class);
                intent.putExtra("totalNilai", totalNilai);
                startActivity(intent);
            }
        });

        pilihan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SoalTambah2.this, SoalTambah3.class);
                intent.putExtra("totalNilai", totalNilai);
                startActivity(intent);
            }
        });
    }
}