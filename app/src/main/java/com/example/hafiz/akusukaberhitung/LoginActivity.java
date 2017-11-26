package com.example.hafiz.akusukaberhitung;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btn1;
    private TextView regis;
    private FirebaseAuth auth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail =(EditText) findViewById(R.id.email);
        inputPassword =(EditText) findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
        onStart();

        btn1=(Button) findViewById(R.id.login_button);
        regis=(TextView) findViewById(R.id.goto_regis);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Passoword", Toast.LENGTH_SHORT).show();
                    return;
                }

                final ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Membuka Akun");
                progressDialog.show();

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            if (password.length() < 6) {
                                inputPassword.setError(getString(R.string.minimum_password));
                                } else {
                                Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                            }
                        } else if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Intent intent = new Intent(LoginActivity.this, QuizMainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mUser=FirebaseAuth.getInstance().getCurrentUser();
        updateUI(mUser);
    }

    public void updateUI(FirebaseUser user){
        if (user!=null){
            Intent i = new Intent(LoginActivity.this,QuizMainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
