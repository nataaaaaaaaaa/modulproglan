import java.util.ArrayList;
import java.util.List;

class Makanan {
    private String nama;
    private int harga;

    public Makanan(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return nama + " - Rp" + harga;
    }
}

class Pesanan {
    private List<Makanan> menu;
    private List<Makanan> pesanan;
    private List<Integer> jumlah;

    public Pesanan() {
        menu = new ArrayList<>();
        pesanan = new ArrayList<>();
        jumlah = new ArrayList<>();
    }

    public void tambahMenu(Makanan makanan) {
        menu.add(makanan);
    }

    public void pesanMakanan(String namaMakanan, int jumlahPesanan) {
        for (Makanan makanan : menu) {
            if (makanan.getNama().equalsIgnoreCase(namaMakanan)) {
                pesanan.add(makanan);
                jumlah.add(jumlahPesanan);
                System.out.println("Pesanan: " + jumlahPesanan + " x " + makanan.getNama() + " berhasil ditambahkan.");
                return;
            }
        }
        System.out.println("Makanan tidak ditemukan di menu.");
    }

    public int totalHarga() {
        int total = 0;
        for (int i = 0; i < pesanan.size(); i++) {
           total += pesanan.get(i).getHarga() * jumlah.get(i);
        }
        return total;
    }

    public void cetakNota() {
        System.out.println("\n----- Nota Pemesanan -----");
        for (int i = 0; i < pesanan.size(); i++) {
            Makanan makanan = pesanan.get(i);
            System.out.println(makanan.getNama() + " x " + jumlah.get(i) + " - Rp" + (makanan.getHarga() * jumlah.get(i)));
        }
        System.out.println("Total Harga: Rp" + totalHarga());
        System.out.println("--------------------------");
    }
}

public class Restoran {
    public static void main(String[] args) {
        Pesanan restoran = new Pesanan();

        // Menambah makanan ke menu
        restoran.tambahMenu(new Makanan("Nasi Goreng", 20000));
        restoran.tambahMenu(new Makanan("Ayam Penyet", 25000));
        restoran.tambahMenu(new Makanan("Sate Ayam", 30000));

        // Memesan makanan
        restoran.pesanMakanan("Nasi Goreng", 2);
        restoran.pesanMakanan("Ayam Penyet", 1);
        restoran.pesanMakanan("Sate Ayam", 3);

        // Mencetak nota pemesanan
        restoran.cetakNota();
    }
}
