package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MateriKurang extends AppCompatActivity {
    private Button kurang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_kurang);

        kurang=(Button) findViewById(R.id.quizkurang);

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MateriKurang.this,SoalKurang1.class);
                startActivity(intent);
            }
        });
    }
}
