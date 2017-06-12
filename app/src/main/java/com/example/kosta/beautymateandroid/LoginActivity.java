package com.example.kosta.beautymateandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private EditText idEdit;
    private EditText pwEdit;
    private CheckBox autoCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences("login_info", Context.MODE_PRIVATE);
        String id = prefs.getString("id", "");
        if (!id.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        idEdit = (EditText) findViewById(R.id.idEdit);
        pwEdit = (EditText) findViewById(R.id.pwEdit);
        autoCheck = (CheckBox) findViewById(R.id.autoCheck);

        findViewById(R.id.cancelBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idEdit.setText("");
                pwEdit.setText("");
            }
        });
        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerId = String.valueOf(idEdit.getText());
                new LoginCheckTask().execute("http://10.0.2.2:8080/BeautyMateOrigin/customer/customer/login");
            }
        });
    }

    private class LoginCheckTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection http = null;
            InputStream is = null;
            String checkStr = null;
            try {
                URL url = new URL(params[0]);
                http = (HttpURLConnection) url.openConnection();
                http.setReadTimeout(10000 /* milliseconds */);
                http.setConnectTimeout(15000 /* milliseconds */);
                http.setRequestMethod("POST");
                http.connect();

                //스트림열림
                is = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                checkStr = reader.readLine();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return checkStr;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("true")) {

                if (autoCheck.isChecked()) {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("id", idEdit.getText().toString());
                    editor.putString("pw", pwEdit.getText().toString());
                    editor.apply();
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "일치하는 회원이 없습니다", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
