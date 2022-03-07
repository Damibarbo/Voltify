package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondaActivity extends AppCompatActivity {
    Intent i;
    ListView brani;
    Button btnEsporta, btnImporta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconda);
        btnEsporta =(Button) findViewById(R.id.esporta);
        btnImporta=(Button) findViewById(R.id.importa);

        i=getIntent();
        brani=(ListView) findViewById(R.id.listaBrani);
        String braniRicevuti=i.getStringExtra("brani");
        String[] temp=braniRicevuti.split("\n");
        ArrayList<String> canzoni = new ArrayList<String>();
        for(int i=0;i<temp.length;i++) {
            canzoni.add(temp[i]);
        }
        ArrayAdapter<String> adBrani=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,canzoni);
        brani.setAdapter(adBrani);


        GestoreFile gf = new GestoreFile();

        btnEsporta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeFile="braniEsportati.txt";
                String str = gf.esporta(nomeFile,canzoni.toString(),getApplicationContext());
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        btnImporta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String braniImportati = gf.importa(getApplicationContext());
                String[] canzImportate =braniImportati.split("\n");
                for(int i=0; i<canzImportate.length ; i++) {
                    canzoni.add(canzImportate[i]);
                }
                adBrani.notifyDataSetChanged();
            }
        });
    }
}


