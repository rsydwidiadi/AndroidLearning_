package com.example.widiadi.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Widiadi on 19-Dec-17.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String UNAME = "admin";
    private static final String PASS = "password";

    @BindView(R.id.etUsername)
    EditText username;
    @BindView(R.id.etPassword)
    EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
        ButterKnife.bind(LoginActivity.this);
        //Button btnLogin = (Button) findViewById(R.id.btnLogin);
        //username = (EditText) findViewById(R.id.etUsername);
    }

    @OnClick(R.id.btnLogin)
    void gotoLogin() {
        if (validatePassword()) {
            String u = username.getText().toString();
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            i.putExtra("username", u);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, "Username/Password Tidak Valid", Toast.LENGTH_LONG).show();
        }

    }

    private boolean validatePassword() {
        String u = username.getText().toString();
        String p = password.getText().toString();

        if (u.equals(UNAME) && p.equals(PASS)) {
            return true;
        } else {
            return false;
        }
    }
}
      /*  btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = username.getText().toString();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("username", u);
                startActivity(i);
                finish();
            }

        });

    } */


