package kelas.controller;

import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {
    private static Produk produkTerpilih;
    @FXML private Label kodeLabel;
    @FXML private Label namaLabel;
    @FXML private Label kategoriLabel;
    @FXML private Label hargaLabel;

    public static void setProdukTerpilih(Produk produk) {
        produkTerpilih = produk;
    }

    @FXML
    private void initialize() {
        if (produkTerpilih != null) {
            NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            kodeLabel.setText(produkTerpilih.getKode());
            namaLabel.setText(produkTerpilih.getNama());
            kategoriLabel.setText(produkTerpilih.getKategori());
            hargaLabel.setText(rupiah.format(produkTerpilih.getHarga()));
        }
    }

    @FXML private void kembali() { Navigator.show("/kelas/katalog.fxml"); }
}
