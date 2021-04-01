package com.example.kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView cv;
    Button maps;
    Button message;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv = findViewById(R.id.cv);
        maps = findViewById(R.id.maps);
        message = findViewById(R.id.message);
        exit = findViewById(R.id.shutdown);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(a);
                finish();
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("geo:-5.132380875543826, 119.48852085543615"));
                if (a.resolveActivity(getPackageManager()) != null) {
                    startActivity(a);
                }
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Intent.ACTION_DIAL);
                a.setData(Uri.parse("tel:+6282195008936"));
                if (a.resolveActivity(getPackageManager()) != null) {
                    startActivity(a);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilkan();
            }
        });

    }

    private void tampilkan(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Peringatan !!!");
        alertDialogBuilder
                .setMessage("Apakah Anda Yakin Ingin Keluar ?")
                .setCancelable(false)
                .setPositiveButton("Iye",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Ndak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}