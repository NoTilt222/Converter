package src;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageToBase64Controller {

    @FXML
    private TextArea base64TextArea;

    @FXML
    private Button uploadButton;

    private FileChooser fileChooser;
    private String base64String;

    @FXML
    private void initialize() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        base64String = null;
    }

    @FXML
    private void uploadImage() {
        Stage stage = (Stage) base64TextArea.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                base64String = Base64.getEncoder().encodeToString(bytes);
                inputStream.close();
                uploadButton.setText("Image uploaded✔ "); // Update button text
            } catch (IOException e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
        }
    }

    @FXML
    private void Clear() {
        base64String = null;
        base64TextArea.clear();
        uploadButton.setText("Upload Image");
    }
    @FXML
    private void convertToBase64() {
        base64TextArea.setText(base64String);
    }
}
