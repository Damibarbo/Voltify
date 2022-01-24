package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondaActivity extends AppCompatActivity {
    Intent i;
    TextView brani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconda);

        i=getIntent();
        brani=(TextView) findViewById(R.id.listaBrani);
        String braniRicevuti=i.getStringExtra("brani");
        Toast.makeText(getApplicationContext(),braniRicevuti,Toast.LENGTH_LONG).show();
    }
}

