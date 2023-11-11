package uts_dua;

public class Admin extends Pengguna{
    public Admin(String nama){
        super(nama);
    }

    @Override
    public void identifikasi() {
        System.out.println("Selamat datang " + nama + "! Anda sebagai admin");
    }
}
