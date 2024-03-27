import java.util.Scanner;

public class MahasiswaMain07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jumMhs = 5;

        PencarianMhs07 data = new PencarianMhs07(jumMhs);

        System.out.println("------------------------------------------");
        System.out.println("Masukkan data mahasiswa secara urut dari NIM Terkecil hingga Terbesar : ");
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("---------------------------------------");
            System.out.print("Nim\t: ");
            int nim = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nama\t : ");
            String nama = scanner.nextLine();
            System.out.print("Umur\t : ");
            int umur = scanner.nextInt();
            System.out.print("IPK\t : ");
            double ipk = scanner.nextDouble();

            Mahasiswa07 m = new Mahasiswa07(nim, nama, umur, ipk);
            data.tambah(m);
        }

        System.out.println("---------------------------------------");
        System.out.println("Data keseluruhan Mahasiswa : ");
        data.tampil();

        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan Nama Mahasiswa yang dicari: ");
        System.out.print("Nama : ");
        String cari = scanner.next();

        System.out.println("========================================");
        System.out.println("Menggunakan Binary Search");

        int[] posisi = data.FindBinarySearchByName(cari, 0, jumMhs - 1, 0);

        // Periksa apakah hasil pencarian lebih dari satu
        if (posisi.length == 0) {
            System.out.println("Data dengan nama " + cari + " tidak ditemukan");
        } else if (posisi.length == 1) {
            data.tampilPosisiNama(cari, posisi);
            data.tampilDataNama(cari, posisi);
        } else {
            System.out.println("Peringatan: Data dengan nama " + cari + " ditemukan lebih dari satu");
            data.tampilPosisiNama(cari, posisi);
            data.tampilDataNama(cari, posisi);
        }
    }
}
