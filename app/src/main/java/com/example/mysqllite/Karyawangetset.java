package com.example.mysqllite;

public class Karyawangetset {
    String kode,nama,email;

    public Karyawangetset(String kode, String nama, String email) {
        this.kode = kode;
        this.nama = nama;
        this.email = email;
    }

    public Karyawangetset() {
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
