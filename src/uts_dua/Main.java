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
            Admin admin = (Admin) pengguna;
            System.out.println("\nMenu Admin");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Lihat Buku");
            System.out.print("Pilih opsi (1/2/3): ");
            int menuAdmin = scanner.nextInt();
            scanner.nextLine();

            switch (menuAdmin) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan genre: ");
                    String genre = scanner.nextLine();
                    admin.tambahBuku(daftarBuku,
                            new Buku(judul,
                                    penulis,
                                    genre));
                    break;
                case 2:
                    System.out.print("Masukkan judul yang ingin dihapus: ");
                    String hapusBuku = scanner.nextLine();
                    Buku bukuHapus = null;
                    for (Buku buku: daftarBuku) {
                        if (buku.getJudul().equalsIgnoreCase(hapusBuku)) {
                            bukuHapus = buku;
                            break;
                        }
                    }

                    if (bukuHapus != null) {
                        admin.hapusBuku(daftarBuku, bukuHapus);
                    } else {
                        System.out.println("Buku tidak ditemukan");
                    }
                    break;
                case 3:
                    Admin.lihatBuku(daftarBuku);
                    break;
                default:
                    System.out.println("Input tidak valid");
            }
        } else if (pengguna instanceof User) {
            User user = (User) pengguna;
            System.out.println("\nMenu Pengguna");
            System.out.println("1. Lihat buku");
            System.out.print("Pilih opsi (1): ");
            int inputUser = scanner.nextInt();
            scanner.nextLine();

            switch (inputUser) {
                case 1:
                    user.lihatBuku(daftarBuku);
                    break;
                default:
                    System.out.println("Input tidak valid");
            }
        }
    }
}
