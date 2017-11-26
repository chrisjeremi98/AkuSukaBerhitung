package com.example.hafiz.akusukaberhitung;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private TextView btnLogin;
    private EditText inputEmail, inputPassword, inputUsername;
    private Button buatakun;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase  mDatabase;
    private DatabaseReference mRef;
    private FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();

        buatakun = (Button) findViewById(R.id.buatakun);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        inputUsername=(EditText) findViewById(R.id.username);
        btnLogin=(TextView) findViewById(R.id.goto_login);

        buatakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                final String username= inputUsername.getText().toString().trim();


                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password Terlalu Pendek", Toast.LENGTH_SHORT).show();
                    return;
                }

                final ProgressDialog progressDialog=new ProgressDialog(RegistrationActivity.this, R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Membuat Akun");
                progressDialog.show();

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(RegistrationActivity.this, "Registrasi Sukses:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Registrasi gagal" + task.getException(),Toast.LENGTH_SHORT).show();
                        } else {
                            progressDialog.dismiss();
                            onAuthSucces(task.getResult().getUser(), username);
                            startActivity(new Intent(RegistrationActivity.this, QuizMainActivity.class));
                            finish();
                        }
                    }
                });
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

    }
    public void onAuthSucces(FirebaseUser user ,String username){
        String email=user.getEmail();
        String userId= user.getUid();
        User newUser =new User();
        newUser.setEmail(email);
        newUser.setName(username);
        mRef.child("users").child(userId).push().setValue(newUser);
    }

}

