package Aplikasi_Lelang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Transaksi_Lelang {

    private ArrayList<Integer> HargaPenawaran = new ArrayList<Integer>();
    private ArrayList<String> NamaPenawar = new ArrayList<String>();
    private ArrayList<Integer> IdPenawar = new ArrayList<Integer>();

    Scanner input = new Scanner(System.in);

    public Transaksi_Lelang(Masyarakat Masyarakat, Petugas Petugas, Barang Barang) {
        System.out.println("---------------------------------------");
        System.out.println(" Selamat Datang Di Aplikasi Pelelangan ");
        System.out.println("---------------------------------------");
        int confirm;

        do {
            System.out.println("Option : \n 1. Lelang \n 2. Keluar");
            System.out.print("Pilihan Anda \t: ");
            confirm = input.nextInt();
            if (confirm == 1) {

                System.out.println("List Barang : "
                        + "\n 1. Rumah 15x20m "
                        + "\n 2. iPhone 6 Pink Diamond "
                        + "\n 3. MacBook Pro");
                System.out.print("\nMasukan ID Barang Yang Ingin Di Lelang \t: ");
                int IdBarang = input.nextInt();

                System.out.println("Barang Yang Akan Di Lelang Adalah \t: " 
                        + Barang.getBarang(IdBarang - 1));
                if (!Barang.getStatus(IdBarang - 1)) {
                    System.out.println("Anda Ingin Mengubah Item : " 
                            + Barang.getBarang(IdBarang - 1) 
                            + "\nMenjadi Bisa Di Tawar ? [Y|N]");
                    System.out.print("Pilihan Anda \t: ");
                    String Option = input.next();
                    
                    if (Option.equalsIgnoreCase("Y")) {
                        Barang.setStatus(IdBarang - 1, true);
                        System.out.println("\nItem : " 
                                + Barang.getBarang(IdBarang - 1) 
                                + " Kondisi Barang " 
                                + Barang.getStatus(IdBarang - 1));
                        
                        if (Barang.getStatus(IdBarang - 1)) {
                            System.out.println("Barang Dapat Di Lelang");
                            System.out.println("Maksimal 3x Penawaran");
                            int max = 0;

                            do {
                                System.out.print("\nID Pelelang \t\t: ");
                                int id = input.nextInt();
                                if (id < 1 || id > 3) {
                                    System.out.println("ID Tidak Terdaftar");
                                    System.out.println("Silahkan Masukan ID Anda");
                                } else {
                                    System.out.println("Masukan Penawaran Anda.(Minimal Penawaran " 
                                            + Barang.getHarga(IdBarang - 1) + ")");
                                    System.out.print("Harga Penawaran \t: ");
                                    int HargaTawar = input.nextInt();

                                    if (HargaTawar > Barang.getHarga(id - 1)) {
                                        HargaPenawaran.add(HargaTawar);
                                        IdPenawar.add(id - 1);
                                    } else if (HargaTawar <= Barang.getHarga(id - 1)) {
                                        System.out.println("Harga Penawaran Kurang");
                                        max--;
                                    }

//                                    if (HargaTawar <= Barang.getHarga(id - 1)) {
//                                        System.out.println("Harga Penawaran Kurang");
//                                        max--;
//                                    } else if (HargaTawar > Barang.getHarga(id - 1)) {
//                                        HargaPenawaran.add(HargaTawar);
//                                        IdPenawar.add(id - 1);
//                                    }
                                    max++;
                                }
                            } while (max != 3);
                            if (max == 3) {
                                Barang.setStatus(IdBarang - 1, false);
                                int maxValue = Collections.max(HargaPenawaran);
                                int getIndex = HargaPenawaran.indexOf(maxValue);
                                int winner = IdPenawar.get(getIndex);
                                System.out.println(
                                        "-----------------------------------------------"
                                        + "\nPetugas Pelelangan\t: " + Petugas.getNama(0)
                                        + "\nPemenang Lelang \t: " + Masyarakat.getNama(winner)
                                        + "\nBarang Yang Terjual \t: " + Barang.getBarang(IdBarang - 1)
                                        + "\nDengan Harga Beli \t: " + maxValue
                                        + "\n-----------------------------------------------" + "\n");
                                Barang.Remove(IdBarang - 1);
                            }
                        }
                    } else if (Option.equalsIgnoreCase("N")) {
                        System.out.println("Silahkan Pilih Option Anda\n");
                    } else {
                        System.out.println("!!! ERROR !!! \nSalah Input \n");
                    }
                } else {
                    System.out.println("!!! ERROR !!!");
                }
            }
        } while (confirm != 2);
        System.out.println("--------------------------------"
                + "\nKeluar Dari Aplikasi Pelelangan "
                + "\nTerima Kasih Atas Kunjungan Anda"
                + "\n--------------------------------");
    }
}
