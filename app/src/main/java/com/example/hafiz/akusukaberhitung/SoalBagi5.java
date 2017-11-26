package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoalBagi5 extends AppCompatActivity {
    private Button pilihan1, pilihan2, pilihan3;
    private TextView nilai;
    private int totalNilai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_bagi5);

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

                Intent intent=new Intent(SoalBagi5.this, TotalSkorActivity.class);
                intent.putExtra("totalNilai", totalNilai);
                startActivity(intent);
            }
        });
        pilihan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SoalBagi5.this, TotalSkorActivity.class);
                intent.putExtra("totalNilai", totalNilai);
                startActivity(intent);
            }
        });

        pilihan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalNilai=totalNilai+1;
                Intent intent=new Intent(SoalBagi5.this, TotalSkorActivity.class);
                intent.putExtra("totalNilai", totalNilai);
                startActivity(intent);
            }
        });

    }
}
