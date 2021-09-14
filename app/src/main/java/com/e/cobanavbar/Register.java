package com.e.cobanavbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Register extends AppCompatActivity {
    Button regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regist = findViewById(R.id.btn);
        Toolbar tbar = findViewById(R.id.toolbar);

        setSupportActionBar(tbar);
        regist.setOnClickListener(v -> {
            AlertDIalogValidasi(v);
        });

    }
    public void AlertDIalogValidasi(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Confirm Data");

        alertDialogBuilder.setMessage("Apa anda yakin data yang anda masukkan benar ?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Ya", (arg0, arg1) -> {
            openSnackbar(v);
            Intent daftar = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(daftar);
        });

        alertDialogBuilder.setNegativeButton("Tidak", (dialog, which) -> {
            Toast.makeText(Register.this,"Silahkan benarkan data anda",Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void openSnackbar(View view) {
        Snackbar snackbar = Snackbar.make(view, "Pendaftaran Sukses", Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.teal_200));
        snackbar.show();
    }
}