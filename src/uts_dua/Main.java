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

        String namaPengguna, status;
        Pengguna pengguna;

        do {
            System.out.print("Masukkan nama anda: ");
            namaPengguna = scanner.nextLine();

            System.out.print("Pilih status anda (User/Admin): ");
            status = scanner.nextLine();

            if (status.equalsIgnoreCase("User")) {
                pengguna = new User(namaPengguna);
            } else if (status.equalsIgnoreCase("Admin")) {
                pengguna = new Admin(namaPengguna);
            } else {
                System.out.println("Status tidak valid");
                continue;
            }

            pengguna.identifikasi();

            if (pengguna instanceof Admin) {
                Admin admin = (Admin) pengguna;
                int menuAdmin;

                do {
                    System.out.println("\nMenu Admin");
                    System.out.println("1. Tambah Buku");
                    System.out.println("2. Hapus Buku");
                    System.out.println("3. Lihat Buku");
                    System.out.println("4. Keluar");
                    System.out.print("Pilih opsi (1/2/3/4): ");
                    menuAdmin = scanner.nextInt();
                    scanner.nextLine();

                    switch (menuAdmin) {
                        case 1:
                            System.out.print("Masukkan judul buku: ");
                            String judul = scanner.nextLine();
                            System.out.print("Masukkan penulis: ");
                            String penulis = scanner.nextLine();
                            System.out.print("Masukkan genre: ");
                            String genre = scanner.nextLine();
                            admin.tambahBuku(daftarBuku, new Buku(judul, penulis, genre));
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
                        case 4:
                            System.out.println("Keluar dari Menu Admin.");
                            break;
                        default:
                            System.out.println("Input tidak valid");
                    }
                } while (menuAdmin != 4);
            } else if (pengguna instanceof User) {
                User user = (User) pengguna;
                int inputUser;

                do {
                    System.out.println("\nMenu Pengguna");
                    System.out.println("1. Lihat buku");
                    System.out.println("2. Keluar");
                    System.out.print("Pilih opsi (1/2): ");
                    inputUser = scanner.nextInt();
                    scanner.nextLine();

                    switch (inputUser) {
                        case 1:
                            user.lihatBuku(daftarBuku);
                            break;
                        case 2:
                            System.out.println("Keluar dari Menu Pengguna.");
                            break;
                        default:
                            System.out.println("Input tidak valid");
                    }
                } while (inputUser != 2);
            }
        } while (true);
    }
}
