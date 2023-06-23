import java.util.Scanner;
import java.util.LinkedList;

class Barang {
    String nama;
    int harga;

    public Barang(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}


public class BesiTua {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Barang> daftarBarang = new LinkedList<>();

        int pilihan = 0;
        while (pilihan != 4) {
            System.out.println("Menu:");
            System.out.println("1.Tampilkan Daftar Barang");
            System.out.println("2.Cari Barang");
            System.out.println("3.Tambah Barang");
            System.out.println("4.Hitung Total Harga");
            System.out.println("5.Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    tampilBarang(daftarBarang);
                    break;
                case 2:
                    System.out.print("Masukkan nama barang yang akan dicari: ");
                    input.nextLine();
                    String namaBarang = input.nextLine();
                    boolean ditemukan = cariBarang(daftarBarang, namaBarang);
                    if (ditemukan) {
                        System.out.println("Barang " + namaBarang + " ditemukan.");
                    } else {
                        System.out.println("Barang " + namaBarang + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nama barang: ");
                    input.nextLine();
                    String nama = input.nextLine();
                    System.out.print("Masukkan harga barang: ");
                    int harga = input.nextInt();
                    tambahBarang(daftarBarang, nama, harga);
                    break;
                case 4:
                    int totalHarga = hitungTotalHarga(daftarBarang);
                    System.out.println("Total Harga Barang: " + totalHarga);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    public static void tampilBarang(LinkedList<Barang> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang yang tersedia.");
        } else {
            System.out.println("Daftar Barang Tersedia:");
            for (Barang barang : daftarBarang) {
                System.out.println("Nama: " + barang.nama + ", Harga: " + barang.harga);
            }
        }
    }
//searching
    public static boolean cariBarang(LinkedList<Barang> daftarBarang, String nama) {
        for (Barang barang : daftarBarang) {
            if (barang.nama.equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public static void tambahBarang(LinkedList<Barang> daftarBarang, String nama, int harga) {
        Barang barangBaru = new Barang(nama, harga);
        daftarBarang.add(barangBaru);
        System.out.println("Barang berhasil ditambahkan: " + nama);
    }

    public static int hitungTotalHarga(LinkedList<Barang> daftarBarang) {
        int total = 0;
        for (Barang barang : daftarBarang) {
            total += barang.harga;
        }
        return total;
    }
}
