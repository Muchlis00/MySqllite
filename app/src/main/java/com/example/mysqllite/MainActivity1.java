package com.example.mysqllite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity1 extends AppCompatActivity {
    EditText kode,nama,harga;
    Button save,update,delete;
    TextView hasil;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        kode = (EditText)findViewById(R.id.editTextKode);
        nama= (EditText) findViewById(R.id.editTextNama);
        harga= (EditText) findViewById(R.id.editTextHarga);
        save = (Button)findViewById(R.id.btnSave);
        hasil =(TextView) findViewById(R.id.textViewhasil);
        update = (Button) findViewById(R.id.btnUpdate);
        delete = (Button) findViewById(R.id.btnDel);

        final DatabaseHalper dbx = new DatabaseHalper(this);
        List<Karyawangetset> xxx = dbx.tampildatakaryawan();
        String hhh="";
        for (Karyawangetset x:xxx){
            hhh = hhh+"\n"+x.getKode()+" "+x.getNama()+ " "+x.getEmail();
        }
        hasil.setText(hhh);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbx.tambahkaryawan(new Karyawangetset(kode.getText().toString(),nama.getText().toString(),harga.getText().toString()));
                List<Karyawangetset> xxx = dbx.tampildatakaryawan();
                String hhh="";
                for (Karyawangetset x:xxx){
                    hhh = hhh+"\n"+x.getKode()+" "+x.getNama()+ " "+x.getEmail();
                }
                hasil.setText(hhh);
            }
        });



    }
}
