package com.example.rkdeado;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View genButton = findViewById(R.id.btnGen);
        TextView genText = (TextView) findViewById(R.id.txvPass);
        EditText edSite = (EditText) findViewById(R.id.edtSite);
        EditText edPhrase = (EditText) findViewById(R.id.edtPhrase);
        
        genButton.setOnClickListener(new PassGen(edSite, edPhrase, genText));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
