package uts_satu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama hewan (Kucing/Anjing): ");
        String jenisHewan = scanner.nextLine();

        Hewan hewan;

        if (jenisHewan.equalsIgnoreCase("Kucing")) {
            hewan = new Kucing();
        } else if (jenisHewan.equalsIgnoreCase("Anjing")) {
            hewan = new Anjing();
        } else {
            System.out.println(jenisHewan + " bukan mamalia.");
            return;
        }

        hewan.bersuara();
        System.out.println(jenisHewan + " adalah mamalia.");

    }
}

