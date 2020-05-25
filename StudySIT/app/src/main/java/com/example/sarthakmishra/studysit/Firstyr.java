package com.example.sarthakmishra.studysit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Firstyr extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstyr);
        b1=(Button)findViewById(R.id.btna);
        b2=(Button)findViewById(R.id.btnb);
        b3=(Button)findViewById(R.id.btnc);
        b4=(Button)findViewById(R.id.btnd);
        b5=(Button)findViewById(R.id.btne);
        b6=(Button)findViewById(R.id.btnf);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Firstyr.this,FirstyrA.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Firstyr.this,FirstyrB.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Firstyr.this,FirstyrC.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Firstyr.this,FirstyrD.class);
                startActivity(i);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Firstyr.this,FirstyrE.class);
                startActivity(i);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Firstyr.this,RetrieveFiles.class);
                startActivity(i);
            }
        });

    }
    public void back(View view)
    {
        Intent i=new Intent(Firstyr.this,Homepage.class);
        startActivity(i);
    }
}