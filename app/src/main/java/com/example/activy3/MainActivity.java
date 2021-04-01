package com.example.activy3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    EditText edEmail, edPassword;

    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(),ActivtyDaftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btSignin);

        edEmail = findViewById(R.id.edEmail);

        edPassword = findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        nama = edEmail.getText().toString();

        password = edPassword.getText().toString();

        String email = "admin@gmail.com";

        String pass = "123";

        if(nama.isEmpty() || password.isEmpty()) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Email dan Password Wajib diisi",
                    Toast.LENGTH_LONG);

            t.show();
        }else {

            if (nama.equals(email) && password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        ":Login Sukses",
                        Toast.LENGTH_LONG);
                t.show();

                Bundle b = new Bundle();

                b.putString("a", nama.trim());

                b.putString("b", password.trim());

                Intent i = new Intent(getApplicationContext(), ActivtyHasil.class);

                i.putExtras(b);

                startActivity(i);
            }else{
                Toast t = Toast.makeText(getApplicationContext(),
                        "Login gagal", Toast.LENGTH_LONG);

                t.show();
            }
        }
    }
        });
    }}