package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuizMainActivity extends AppCompatActivity {

    private ImageButton soal, profil;
    private FirebaseAuth mAuth ;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        soal=(ImageButton) findViewById(R.id.go_to_menu_materi);
        profil=(ImageButton) findViewById(R.id.go_to_profile);

        soal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizMainActivity.this,MenuMateri.class));
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizMainActivity.this, ProfileActivity.class));
            }
        });
    }
}









