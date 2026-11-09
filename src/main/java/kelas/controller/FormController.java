package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {
    @FXML private TextField namaField;
    @FXML private TextField hargaField;
    @FXML private ComboBox<String> kategoriBox;
    @FXML private Label pesanLabel;

    @FXML
    private void initialize() {
        kategoriBox.getItems().setAll("Makanan", "Minuman");
        kategoriBox.setValue("Makanan");
    }

    @FXML
    private void simpanProduk() {
        String nama = namaField.getText() == null ? "" : namaField.getText().trim();
        String hargaText = hargaField.getText() == null ? "" : hargaField.getText().trim();

        if (nama.isEmpty()) {
            pesanLabel.setText("Nama produk tidak boleh kosong.");
            return;
        }
        double harga;
        try {
            harga = Double.parseDouble(hargaText);
        } catch (NumberFormatException ex) {
            pesanLabel.setText("Harga harus berupa angka.");
            return;
        }
        if (harga <= 0) {
            pesanLabel.setText("Harga harus lebih dari 0.");
            return;
        }
        DataProduk.tambah(new Produk(DataProduk.kodeBaru(), nama, kategoriBox.getValue(), harga));
        Navigator.show("/kelas/katalog.fxml");
    }

    @FXML
    private void kembali() { Navigator.show("/kelas/katalog.fxml"); }
}
