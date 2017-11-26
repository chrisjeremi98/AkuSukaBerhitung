package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalSkorActivity extends AppCompatActivity {
    private TextView textNilai;
    private int totalNilai;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_skor);

        button=(Button) findViewById(R.id.go_to_menu);

        Intent intent=getIntent();
        totalNilai=intent.getIntExtra("totalNilai",0);

        textNilai=(TextView) findViewById(R.id.total_nilai);
        textNilai.setText(String.valueOf(totalNilai));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TotalSkorActivity.this, QuizMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
