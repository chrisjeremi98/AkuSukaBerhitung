package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MateriBagi extends AppCompatActivity {
    private Button bagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_bagi);
        bagi=(Button) findViewById(R.id.quizbagi);

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MateriBagi.this,SoalBagi1.class);
                startActivity(intent);
            }
        });
    }
}
