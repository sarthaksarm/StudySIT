package com.example.sarthakmishra.studysit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class performancecard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performancecard);
        main();
    }
    public void main()
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://asys.sit.ac.in/meritsmartuniv/"));
        startActivity(browserIntent);
    }
}
