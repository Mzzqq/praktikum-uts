package uts_dua;

import java.util.List;

public class Admin extends Pengguna{
    public Admin(String nama){
        super(nama);
    }

    @Override
    public void identifikasi() {
        System.out.println("Selamat datang " + nama + "! Anda sebagai admin");
    }

    public void tambahBuku(List<Buku> daftarBuku, Buku buku){
        daftarBuku.add(buku);
        System.out.println("Buku berhasil ditambahkan");
    }


}
