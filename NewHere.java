package com.example.dell.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewHere extends AppCompatActivity
{
    EditText etname= null;
    EditText etusername= null;
    EditText etpassword= null;
    EditText etconfirmpassword= null;
    Button bregister;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_here);
        final Logindao logindao= new Logindao();

        etname= (EditText) findViewById(R.id.etname);
        etusername= (EditText) findViewById(R.id.etusername);
         etpassword= (EditText) findViewById(R.id.etpassword);
         etconfirmpassword= (EditText) findViewById(R.id.etconfirmpassword);
         bregister= (Button) findViewById(R.id.bregister);
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd= etpassword.getText().toString();
                String confirmPwd = etconfirmpassword.getText().toString();
                String name= etname.getText().toString();
                String username= etusername.getText().toString();

                if (!(pwd.equals(confirmPwd))) {
                    Toast.makeText(NewHere.this, "Confirmed password and passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    logindao.saveDataRegistered(getApplicationContext(), name,username,pwd);
                    Intent setSignUpIntent= new Intent(NewHere.this,MainActivity.class);
                    NewHere.this.startActivity(setSignUpIntent);

                }

            }
        });


    }

    public void onRegisterCLick(View view)
    {

    }


}





