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

    public void hapusBuku(List<Buku> daftarBuku, Buku buku){
        daftarBuku.remove(buku);
        System.out.println("Buku berhasil dihapus");
    }

    public static void lihatBuku(List<Buku> daftarBuku){
        System.out.println("\nDaftar Buku");
        for (Buku buku: daftarBuku){
            System.out.println(buku);
        }
    }

}
