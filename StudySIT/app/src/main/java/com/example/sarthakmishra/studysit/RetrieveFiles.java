package com.example.sarthakmishra.studysit;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class RetrieveFiles extends AppCompatActivity {

    Button choose,upload;
    Uri pdfs;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_files);
        firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseStorage=FirebaseStorage.getInstance();

        choose=(Button)findViewById(R.id.choosebtn);
        upload=(Button)findViewById(R.id.uploadbtn);


        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(RetrieveFiles.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectpdf();
                }
                else {
                    ActivityCompat.requestPermissions(RetrieveFiles.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }


                }
        });


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pdfs!=null)
                    uploadfile(pdfs);
                else
                    error();
            }
        });
    }
    private void error(){
        Toast.makeText(this,"Select a file",Toast.LENGTH_LONG).show();
    }

    private void uploadfile(Uri pdfs){

        progressDialog= new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading file...");
        progressDialog.setProgress(0);
        progressDialog.show();

        final String fileName=System.currentTimeMillis()+"";
        StorageReference storageReference= firebaseStorage.getReference();
        storageReference.child("UPLOADS").child(fileName).putFile(pdfs)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        String url= taskSnapshot.getDownloadUrl().toString();
                        DatabaseReference reference=firebaseDatabase.getReference();
                        reference.child(fileName).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                    Toast.makeText(RetrieveFiles.this, "File Successfully uploaded", Toast.LENGTH_SHORT).show();

                                else {
                                    Toast.makeText(RetrieveFiles.this, "File couldn't uploaded", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RetrieveFiles.this, "File couldn't uploaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                        int currentprogress=(int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                        progressDialog.setProgress(currentprogress);
                    }
                });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==9&& grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectpdf();
        }
        else
        {
            Toast.makeText(this,"Please give permission.",Toast.LENGTH_LONG).show();
        }
    }

    public void selectpdf(){

        Intent intent=new Intent();
        intent.setType("applications/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
       startActivityForResult(intent,86);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==86&& resultCode==RESULT_OK && data!=null){
   pdfs=data.getData();
        }
        else{
            Toast.makeText(this,"Please select a file.",Toast.LENGTH_LONG).show();
        }
    }
}