package com.example.mysqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText kode,nama,harga;
    Button save,update,delete,pindah;
    TextView hasil;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kode = (EditText)findViewById(R.id.editTextKode);
        nama= (EditText) findViewById(R.id.editTextNama);
        harga= (EditText) findViewById(R.id.editTextHarga);
        save = (Button)findViewById(R.id.btnSave);
        pindah = (Button)findViewById(R.id.btn_page2);
        hasil =(TextView) findViewById(R.id.textViewhasil);
        update = (Button) findViewById(R.id.btnUpdate);
        delete = (Button) findViewById(R.id.btnDel);


//         db = openOrCreateDatabase("toko.db",MODE_PRIVATE,null);
//                db.execSQL("create table if not exists barang("+
//                        " kode varchar, nama varchar, harga varchar)");
//
//        Cursor c = db.rawQuery("select * from barang",null);
//        String hhh ="";
//        hasil.setText("");
//
//        if (c.moveToFirst())
//        do {
//            String kk = c.getString(c.getColumnIndex("kode"));
//            String nn = c.getString(c.getColumnIndex("nama"));
//            String hh = c.getString(c.getColumnIndex("harga"));
//            hhh=hhh+"\n"+kk+" "+nn+" "+hh;
//        }while (c.moveToNext());
//        hasil.setText(hhh);
//
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String kk1 = k.getText().toString();
//                String nn1 = n.getText().toString();
//                String hh1 = h.getText().toString();
//                db.execSQL("insert into barang values ('"+kk1+"'+nn1+'"+hh1+"')");
//            // refres data
//                Cursor c = db.rawQuery("select * from barang",null);
//                String hhh ="";
//                hasil.setText("");
//
//                if (c.moveToFirst())
//                    do {
//                        String kk = c.getString(c.getColumnIndex("kode"));
//                        String nn = c.getString(c.getColumnIndex("nama"));
//                        String hh = c.getString(c.getColumnIndex("harga"));
//                        hhh=hhh+"\n"+kk+" "+nn+" "+hh;
//                    }while (c.moveToNext());
//                hasil.setText(hhh);
//
//            }
//        }); @string/app_name

        db = openOrCreateDatabase("toko", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS barang(" +
                "kode varchar, nama varchar, harga varchar)");

        Cursor c = db.rawQuery("SELECT * FROM barang", null);
        String hhh = "";
        hasil.setText("");

        if (c.moveToFirst())
            do {
                String kk = c.getString(c.getColumnIndex("kode"));
                String nn = c.getString(c.getColumnIndex("nama"));
                String hh = c.getString(c.getColumnIndex("harga"));
                hhh = hhh + " " + kk + " " + nn + " " + hh + "\n";
            } while (c.moveToNext());

        hasil.setText(hhh);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kk1 = kode.getText().toString();
                String nn1 = nama.getText().toString();
                String hh1 = harga.getText().toString();
                db.execSQL("INSERT INTO barang VALUES('"+ kk1 +"', '"+ nn1 +"', '"+ hh1 +"')");

                Cursor c = db.rawQuery("SELECT * FROM barang", null);
                String hhh = "";
                hasil.setText("");

                if (c.moveToFirst())
                    do {
                        String kk = c.getString(c.getColumnIndex("kode"));
                        String nn = c.getString(c.getColumnIndex("nama"));
                        String hh = c.getString(c.getColumnIndex("harga"));
                        hhh = hhh + " " + kk + " " + nn + " " + hh + "\n";
                    } while (c.moveToNext());

                hasil.setText(hhh);
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String kk1 = kode.getText().toString();
                String nn1 = nama.getText().toString();
                String hh1 = harga.getText().toString();
                db.execSQL("UPDATE barang SET nama ='" +nn1+"',nama='"+nn1+"',harga = '"+hh1+"' where kode ='"+kk1+"'");

                Cursor c = db.rawQuery("SELECT * FROM barang", null);
                String hhh = "";
                hasil.setText("");

                if (c.moveToFirst())
                    do {
                        String kk = c.getString(c.getColumnIndex("kode"));
                        String nn = c.getString(c.getColumnIndex("nama"));
                        String hh = c.getString(c.getColumnIndex("harga"));
                        hhh = hhh + " " + kk + " " + nn + " " + hh + "\n";
                    } while (c.moveToNext());

                hasil.setText(hhh);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String kk1 = kode.getText().toString();
                String nn1 = nama.getText().toString();
                String hh1 = harga.getText().toString();
                db.execSQL("DELETE FROM barang WHERE (kode = '"+kk1+"')");

                Cursor c = db.rawQuery("SELECT * FROM barang", null);
                String hhh = "";
                hasil.setText("");

                if (c.moveToFirst())
                    do {
                        String kk = c.getString(c.getColumnIndex("kode"));
                        String nn = c.getString(c.getColumnIndex("nama"));
                        String hh = c.getString(c.getColumnIndex("harga"));
                        hhh = hhh + " " + kk + " " + nn + " " + hh + "\n";
                    } while (c.moveToNext());

                hasil.setText(hhh);

            }
        });

        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(getApplicationContext(),MainActivity1.class);
                startActivity(pindah);
            }
        });

    }
}
