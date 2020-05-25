package com.example.sarthakmishra.studysit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
    private CardView performancecard,examdetailscard,studymaterialscard,aboutcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        studymaterialscard=(CardView)findViewById(R.id.facultycard);
        examdetailscard=(CardView)findViewById(R.id.newscard);
        performancecard=(CardView)findViewById(R.id.aboutcard);
        aboutcard=(CardView)findViewById(R.id.teamcard);
        studymaterialscard.setOnClickListener(this);
        examdetailscard.setOnClickListener(this);
        performancecard.setOnClickListener(this);
        aboutcard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId())
        {
            case R.id.facultycard :i=new Intent(this,studymaterialscard.class);
                startActivity(i);
                break;
            case R.id.newscard :i=new Intent(this,examdetailscard.class);
                startActivity(i);
                break;
            case R.id.aboutcard :i=new Intent(this,performancecard.class);
                startActivity(i);
                break;
            case R.id.teamcard :i=new Intent(this,aboutcard.class);
                startActivity(i);
                break;
            default:break;
        }
    }
}
