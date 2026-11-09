package kelas.controller;

import java.text.NumberFormat;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {
    @FXML private TableView<Produk> produkTable;
    @FXML private TableColumn<Produk, String> kodeColumn;
    @FXML private TableColumn<Produk, String> namaColumn;
    @FXML private TableColumn<Produk, String> kategoriColumn;
    @FXML private TableColumn<Produk, Double> hargaColumn;
    @FXML private TextField searchField;

    @FXML
    private void initialize() {
        kodeColumn.setCellValueFactory(new PropertyValueFactory<>("kode"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kategoriColumn.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        hargaColumn.setCellValueFactory(new PropertyValueFactory<>("harga"));
        tampilkanSemua();
    }

    private void tampilkanSemua() {
        String kata = searchField == null || searchField.getText() == null
                ? "" : searchField.getText().trim().toLowerCase();
        produkTable.setItems(FXCollections.observableArrayList(
                DataProduk.semua().stream()
                        .filter(p -> p.getNama().toLowerCase().contains(kata))
                        .toList()));
    }

    @FXML private void cari() { tampilkanSemua(); }
    @FXML private void kembali() { Navigator.show("/kelas/katalog.fxml"); }

    @FXML
    private void lihatDetail() {
        Produk terpilih = produkTable.getSelectionModel().getSelectedItem();
        if (terpilih != null) {
            DetailController.setProdukTerpilih(terpilih);
            Navigator.show("/kelas/detail.fxml");
        }
    }
}
