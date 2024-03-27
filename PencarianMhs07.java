public class PencarianMhs07 {
    Mahasiswa07 listMhs[];
    int idx;

    public PencarianMhs07(int jumMhs) {
        listMhs = new Mahasiswa07[jumMhs];
    }

    void tambah(Mahasiswa07 m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh !!");
        }
    }

    void tampil() {
        for (Mahasiswa07 m : listMhs) {
            if (m != null) {
                m.tampil();
                System.out.println("---------------------------------------");
            }
        }
    }

    public int[] FindBinarySearchByName(String cari, int left, int right, int count) {
        if (right >= left) {
            int mid = (left + right) / 2;
            int comparison = listMhs[mid].nama.compareToIgnoreCase(cari);
    
            if (comparison == 0) {
                // Jika nama yang ditemukan sama dengan yang dicari
                int[] positions = new int[1];
                positions[0] = mid;
                return positions;
            } else if (comparison > 0) {
                // Jika nama yang ditemukan lebih besar dari yang dicari
                return FindBinarySearchByName(cari, left, mid - 1, count);
            } else {
                // Jika nama yang ditemukan lebih kecil dari yang dicari
                return FindBinarySearchByName(cari, mid + 1, right, count);
            }
        }
        return new int[0];
    }
    
    void tampilPosisiNama(String x, int[] pos) {
        if (pos.length == 0) {
            System.out.println("Data dengan nama " + x + " tidak ditemukan");
        } else if (pos.length == 1) {
            System.out.println("Data dengan nama " + x + " ditemukan pada indeks " + pos[0]);
        } else {
            System.out.println("Data dengan nama " + x + " ditemukan pada indeks:");
            for (int i : pos) {
                System.out.println(i);
            }
        }
    }

    void tampilDataNama(String x, int[] pos) {
        if (pos.length == 0) {
            System.out.println("Data dengan nama " + x + " tidak ditemukan");
        } else if (pos.length == 1) {
            System.out.println("Data dengan nama " + x + " ditemukan pada indeks:");
            for (int i : pos) {
                System.out.println("Nim\t : " + listMhs[i].nim);
                System.out.println("Nama\t : " + listMhs[i].nama);
                System.out.println("Umur\t : " + listMhs[i].umur);
                System.out.println("IPK\t : " + listMhs[i].ipk);
                System.out.println("---------------------------------------");
            }
        } else {
            System.out.println("Peringatan: Data dengan nama " + x + " ditemukan lebih dari satu");
        }
    }
}
