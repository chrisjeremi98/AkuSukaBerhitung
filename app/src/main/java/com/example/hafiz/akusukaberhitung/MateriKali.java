package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MateriKali extends AppCompatActivity {
    private Button kali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_kali);
        kali=(Button) findViewById(R.id.quizkali);

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MateriKali.this,SoalKali1.class);
                startActivity(intent);
            }
        });
    }
}
