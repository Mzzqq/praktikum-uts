package uts_dua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Buku> daftarBuku = new ArrayList<>();
        daftarBuku.add(new Buku("Design pattern", "Hawari", "Programming"));
        daftarBuku.add(new Buku("Domain Driven Development", "Reza", "Tutorial"));
        daftarBuku.add(new Buku("AC", "Avi", "Language"));

        System.out.print("Masukkan nama anda: ");
        String namaPengguna = scanner.nextLine();

        System.out.print("Pilih status anda (User/Admin): ");
        String status = scanner.nextLine();

        Pengguna pengguna;

        if (status.equalsIgnoreCase("User")) {
            pengguna = new User(namaPengguna);
        } else if (status.equalsIgnoreCase("Admin")) {
            pengguna = new Admin(namaPengguna);
        } else {
            System.out.println("Status tidak valid");
            return;
        }

        pengguna.identifikasi();

        if (pengguna instanceof Admin) {

        }
    }
}
