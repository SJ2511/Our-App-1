package com.example.dell.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etusername = null;
    EditText etpassword = null;
    Button blogin = null;
    TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logindao logindao1 = new Logindao();
//        logindao1.addREcords(this);
        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        blogin = (Button) findViewById(R.id.blogin);
        registerLink = (TextView) findViewById(R.id.bnewhere);

        registerLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(MainActivity.this, NewHere.class);
                MainActivity.this.startActivity(registerIntent);

            }
        });


    }

    public void onButtonClick(View v)

    {
        if (etusername.getText().toString() == null || etusername.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(MainActivity.this, "Fields missing", Toast.LENGTH_SHORT).show();
        }
        else if (etpassword.getText().toString()==null|| etpassword.getText().toString().equalsIgnoreCase(""))
        {
            Toast.makeText(MainActivity.this, "Password missing", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean IsTrue;
            Logindao logindao = new Logindao();
            Log.d("MainActivity", etusername.getText().toString() + etpassword.getText().toString());
            IsTrue = logindao.login(this, etusername.getText().toString(), etpassword.getText().toString());
            if (IsTrue) {
                        Intent intent= new Intent(                 "com.example.dell.intents.LandingPageActivity"

                );
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Incorrect Username or password", Toast.LENGTH_SHORT).show();
            }

        }
    }
}






