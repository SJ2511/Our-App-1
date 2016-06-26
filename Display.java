package com.example.dell.intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by DELL on 6/21/2016.
 */
public class Display extends Activity{
    @Override
    protected  void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
       final EditText etusername= (EditText) findViewById(R.id.etusername);
       final TextView welcomeMessage= (TextView) findViewById(R.id.welcomemsg);

    }
}
