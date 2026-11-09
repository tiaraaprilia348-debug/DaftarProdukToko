package kelas.controller;

import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class KatalogController {
    @FXML private FlowPane productPane;
    @FXML private TextField searchField;
    @FXML private ComboBox<String> categoryFilter;
    private final NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    @FXML
    private void initialize() {
        categoryFilter.getItems().setAll("Semua Kategori", "Makanan", "Minuman");
        categoryFilter.setValue("Semua Kategori");
        tampilkanProduk();
    }

    @FXML
    private void cariProduk() { tampilkanProduk(); }

    @FXML
    private void resetFilter() {
        searchField.clear();
        categoryFilter.setValue("Semua Kategori");
        tampilkanProduk();
    }

    @FXML
    private void bukaForm() { Navigator.show("/kelas/form.fxml"); }

    @FXML
    private void bukaDaftar() { Navigator.show("/kelas/daftar.fxml"); }

    private void tampilkanProduk() {
        productPane.getChildren().clear();
        String kata = searchField == null || searchField.getText() == null
                ? "" : searchField.getText().trim().toLowerCase();
        String kategori = categoryFilter == null ? "Semua Kategori" : categoryFilter.getValue();

        for (Produk p : DataProduk.semua()) {
            boolean cocokNama = p.getNama().toLowerCase().contains(kata);
            boolean cocokKategori = kategori == null || kategori.equals("Semua Kategori")
                    || kategori.equals(p.getKategori());
            if (cocokNama && cocokKategori) {
                VBox card = new VBox(9);
                card.getStyleClass().add("product-card");
                card.setPadding(new Insets(18));
                card.setPrefWidth(255);
                Label icon = new Label(p.getKategori().equals("Makanan") ? "🍞" : "🥤");
                icon.getStyleClass().add("product-icon");
                Label nama = new Label(p.getNama());
                nama.getStyleClass().add("product-name");
                Label kode = new Label(p.getKode() + "  •  " + p.getKategori());
                kode.getStyleClass().add("muted-text");
                Label harga = new Label(rupiah.format(p.getHarga()));
                harga.getStyleClass().add("product-price");
                javafx.scene.control.Button detail = new javafx.scene.control.Button("Lihat Detail");
                detail.getStyleClass().add("primary-button");
                detail.setOnAction(e -> DetailController.setProdukTerpilih(p));
                detail.setOnAction(e -> {
                    DetailController.setProdukTerpilih(p);
                    Navigator.show("/kelas/detail.fxml");
                });
                card.getChildren().addAll(icon, nama, kode, harga, detail);
                productPane.getChildren().add(card);
            }
        }
        if (productPane.getChildren().isEmpty()) {
            Label kosong = new Label("Produk tidak ditemukan.");
            kosong.getStyleClass().add("muted-text");
            productPane.getChildren().add(kosong);
        }
    }
}
