package pulseanddecibels.jp.buzbiznew.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.util.Utils;

/**
 * Created by Diarmaid Lindsay on 2016/06/08.
 * Copyright Pulse and Decibels 2016
 */
public class LoginActivity extends AppCompatActivity {
    EditText editUserName;
    EditText editPassword;
    Button buttonLogin;
    TextView textForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        Utils.goFullScreen(this);
        setContentView(R.layout.activity_login);

        editUserName = (EditText) findViewById(R.id.edit_username);
        editPassword = (EditText) findViewById(R.id.edit_password);
        buttonLogin = (Button) findViewById(R.id.button_login);
        textForgotPassword = (TextView) findViewById(R.id.text_forgot_password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
}
