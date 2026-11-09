package kelas;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Navigator.setStage(stage);
        stage.setTitle("Daftar Produk Toko");
        Navigator.show("/kelas/katalog.fxml");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
