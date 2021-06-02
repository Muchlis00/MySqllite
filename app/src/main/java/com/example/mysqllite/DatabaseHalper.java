package com.example.mysqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHalper extends SQLiteOpenHelper {
    public DatabaseHalper(@Nullable Context context) {
        super(context, "toko.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS karyawan(" +
                "kode varchar, nama varchar, email varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists karyawan");
        onCreate(db);
    }
    void tambahkaryawan(Karyawangetset Karyawangetset) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues isikar = new ContentValues();
        isikar.put("kode",Karyawangetset.getKode());
        isikar.put("nama",Karyawangetset.getNama());
        isikar.put("email",Karyawangetset.getEmail());
        db.insert("karyawan",null,isikar);
        db.close();
    }

    public List<Karyawangetset> tampildatakaryawan() {
        List<Karyawangetset> xxx = new ArrayList<Karyawangetset>();
        String Sqlnya = "select * from karyawan";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(Sqlnya, null);

        if (c.moveToFirst()){
            do {
                Karyawangetset yyy = new Karyawangetset();
                yyy.setKode(c.getString(0));
                yyy.setNama(c.getString(1));
                yyy.setEmail(c.getString(2));
                xxx.add(yyy);
            } while (c.moveToNext());

    }
        return xxx;
    }

    void updatekaryawan(Karyawangetset Karyawangetset){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues isikar = new ContentValues();
//        isikar.put("kode",karyawangetset.getKode());
        isikar.put("nama",Karyawangetset.getNama());
        isikar.put("email",Karyawangetset.getEmail());
        db.update("karyawan",isikar,"kode=?",new String[]{String.valueOf(Karyawangetset.getKode())});
        db.close();
    }
    void deletekaryawan(Karyawangetset Karyawangetset){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues isikar = new ContentValues();
        db.delete("karyawan","kode=?",new String[]{String.valueOf(Karyawangetset.getKode())});
        db.close();
    }
}
