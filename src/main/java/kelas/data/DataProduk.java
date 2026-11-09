package kelas.data;

import java.util.ArrayList;
import java.util.List;
import kelas.model.Produk;

public final class DataProduk {
    private static final List<Produk> PRODUK = new ArrayList<>();

    static {
        PRODUK.add(new Produk("PRD001", "Roti Cokelat", "Makanan", 8000));
        PRODUK.add(new Produk("PRD002", "Susu UHT", "Minuman", 6500));
        PRODUK.add(new Produk("PRD003", "Keripik Kentang", "Makanan", 12000));
    }

    private DataProduk() {}

    public static List<Produk> semua() { return PRODUK; }

    public static void tambah(Produk produk) { PRODUK.add(produk); }

    public static Produk cariKode(String kode) {
        return PRODUK.stream()
                .filter(p -> p.getKode().equals(kode))
                .findFirst().orElse(null);
    }

    public static String kodeBaru() {
        return String.format("PRD%03d", PRODUK.size() + 1);
    }
}
