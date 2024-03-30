package src;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ConverterTypeController {

    @FXML
    private ChoiceBox<String> converterType;
    private Stage stage; // Reference to the stage

    public void initialize() {
        converterType.getItems().addAll("Morse", "Image to Base64");
    }

    // Method to set the stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void loadConverter() {
        String selectedConverter = converterType.getSelectionModel().getSelectedItem();
        if (selectedConverter != null) {
            if (selectedConverter.equals("Morse")) {
                loadMorseView();
            } else if (selectedConverter.equals("Image to Base64")) {
                loadImageToBase64View();
            }
        }
    }

    private void loadMorseView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("morseView.fxml"));
            stage.setTitle("Morse Converter");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println("Error loading Morse view: " + e);
        }
    }

    private void loadImageToBase64View() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("imageToBase64View.fxml"));
            stage.setTitle("Image to Base64 Converter");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println("Error loading Image to Base64 view: " + e);
        }
    }

}
