package src.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ConverterTypeController {

    @FXML
    private ChoiceBox<String> converterType;
    @FXML
    private Button groupButton;
    private Stage stage; // Reference to the stage

    public void initialize() {
        converterType.getItems().addAll("Morse", "Image to Base64");

        // Load your icon image
        Image groupIcon = new Image(getClass().getResourceAsStream("../Pictures/group.png"));

        // Create an ImageView with the icon
        ImageView groupView = new ImageView(groupIcon);

        // Set the size of the ImageView
        groupView.setFitWidth(32);
        groupView.setFitHeight(32);

        // Set the graphic of the switchButton & helpButton
        groupButton.setGraphic(groupView);
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
            Parent root = FXMLLoader.load(getClass().getResource("../Views/morseView.fxml"));
            stage.setTitle("Morse Converter");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println("Error loading Morse view: " + e);
        }
    }

    private void loadImageToBase64View() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../Views/imageToBase64View.fxml"));
            stage.setTitle("Image to Base64 Converter");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading Image to Base64 view: " + e);
        }
    }

    @FXML
    void showGroepsledenModal(ActionEvent event){
        try {
            // Load the modal FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/groepsleden.fxml"));
            Parent root = loader.load();

            // Create a new stage for the modal
            Stage groepStage = new Stage();
            groepStage.initModality(Modality.APPLICATION_MODAL);
            groepStage.setTitle("Groepsleden");
            groepStage.setScene(new Scene(root));

            // Show the modal
            groepStage.showAndWait();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

}
