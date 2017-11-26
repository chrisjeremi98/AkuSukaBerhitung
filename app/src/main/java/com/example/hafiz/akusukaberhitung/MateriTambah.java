package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MateriTambah extends AppCompatActivity {

    private Button goToTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_tambah);

        goToTambah=(Button) findViewById(R.id.quiztambah);

        goToTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MateriTambah.this, SoalTambah1.class);
                startActivity(intent);
            }
        });
    }
}
