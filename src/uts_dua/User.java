package uts_dua;

import java.util.List;

public class User extends Pengguna{
    public User(String nama){
        super(nama);
    }

    @Override
    public void identifikasi() {
        System.out.println("Selamat datang " + nama + "! Anda sebagai pengguna");
    }

    public void lihatBuku(List<Buku> daftarBuku){
        System.out.println("\nDaftar Buku");
        for (Buku buku: daftarBuku){
            System.out.println(buku);
        }
    }
}
