package src.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import src.Controllers.ConverterTypeController;

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
    private Button backButton;

    @FXML
    private void initialize() {
        Image backIcon = new Image(getClass().getResourceAsStream("../Pictures/back-button.png"));

        // Create an ImageView with the icon
        ImageView backView = new ImageView(backIcon);

        // Set the size of the ImageView
        backView.setFitWidth(32);
        backView.setFitHeight(32);

        // Set the graphic of the switchButton & helpButton
        backButton.setGraphic(backView);

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
                System.err.println("Error: " + e); // Handle or log the exception as needed
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

    @FXML
    private void GoBack() {
        try {
            // Load the converter type FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/converterType.fxml"));
            Parent root = loader.load();
            ConverterTypeController controller = loader.getController();

            // Get the stage of the current scene
            Stage stage = (Stage) base64TextArea.getScene().getWindow();
            controller.setStage(stage);

            // Replace the current scene with the converter type scene
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

}
