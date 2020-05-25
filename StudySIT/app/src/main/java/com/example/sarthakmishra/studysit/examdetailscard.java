package com.example.sarthakmishra.studysit;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class examdetailscard extends AppCompatActivity {
Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examdetailscard);
   b1=(Button)findViewById(R.id.button2);

   b1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent i=new Intent(examdetailscard.this,Firstyr.class);
           startActivity(i);
       }
   });
        b2=(Button)findViewById(R.id.button3);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(examdetailscard.this,Secondyr.class);
                startActivity(i);
            }
        });
        b3=(Button)findViewById(R.id.button4);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(examdetailscard.this,Thirdyr.class);
                startActivity(i);
            }
        });
        b4=(Button)findViewById(R.id.button5);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(examdetailscard.this,Fourthyr.class);
                startActivity(i);
            }
        });

            }
    public void back(View view)
    {
        Intent i=new Intent(examdetailscard.this,Homepage.class);
        startActivity(i);
    }

    }

