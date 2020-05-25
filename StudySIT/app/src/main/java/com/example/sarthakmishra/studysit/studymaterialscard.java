package com.example.sarthakmishra.studysit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class studymaterialscard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studymaterialscard);

    }
    public void open(View view)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1cR4N57R_SNWIH0MZc2F1OqeaCKi3aKWM"));
        startActivity(i);
    }
    public void open2(View view)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1q1FdmcgO6h7RAbol3lcWP92hjROuiggs"));
        startActivity(i);
    }
    public void open3(View view)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1bZaXHwx3573vLI6Eh8IFv-ZCdcj1Azyr"));
        startActivity(i);
    }
    public void open4(View view)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1usL8vM77JjdSfAmidA5wUOibH9uORYFd"));
        startActivity(i);
    }
    public void back(View view)
    {
        Intent i=new Intent(studymaterialscard.this,Homepage.class);
        startActivity(i);
    }
}
