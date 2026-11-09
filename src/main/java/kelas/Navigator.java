package kelas;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class Navigator {
    private static Stage stage;

    private Navigator() {}

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void show(String fxml) {
        try {
            Parent root = FXMLLoader.load(Navigator.class.getResource(fxml));
            Scene scene = new Scene(root, 1000, 700);
            stage.setScene(scene);
            stage.setMinWidth(850);
            stage.setMinHeight(620);
        } catch (IOException | RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("Tidak dapat membuka halaman: " + fxml, ex);
        }
    }
}
