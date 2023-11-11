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

        int opsiUtama;
        do {
            System.out.println("\nMenu Utama");
            System.out.println("1. Masuk sebagai User");
            System.out.println("2. Masuk sebagai Admin");
            System.out.println("3. Keluar dari Aplikasi");
            System.out.print("Pilih opsi (1/2/3): ");
            opsiUtama = scanner.nextInt();
            scanner.nextLine();  // Membersihkan newline

            switch (opsiUtama) {
                case 1:
                    System.out.print("Masukkan nama anda: ");
                    namaPengguna = scanner.nextLine();
                    pengguna = new User(namaPengguna);
                    pengguna.identifikasi();

                    User user = (User) pengguna;
                    int inputUser;
                    do {
                        System.out.println("\nMenu Pengguna");
                        System.out.println("1. Lihat buku");
                        System.out.println("2. Keluar dari Menu Pengguna");
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
                    break;

                case 2:
                    System.out.print("Masukkan nama anda: ");
                    namaPengguna = scanner.nextLine();
                    pengguna = new Admin(namaPengguna);
                    pengguna.identifikasi();

                    Admin admin = (Admin) pengguna;
                    int menuAdmin;
                    do {
                        System.out.println("\nMenu Admin");
                        System.out.println("1. Tambah Buku");
                        System.out.println("2. Hapus Buku");
                        System.out.println("3. Lihat Buku");
                        System.out.println("4. Keluar dari Menu Admin");
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
                    break;

                case 3:
                    System.out.println("Keluar dari Aplikasi.");
                    break;

                default:
                    System.out.println("Input tidak valid");
            }
        } while (opsiUtama != 3);
    }
}
