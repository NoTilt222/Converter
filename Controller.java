package src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button switchButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button backButton;

    // Initialize method called after FXML loading
    @FXML
    public void initialize() {
        // Load your icon image
        Image icon = new Image(getClass().getResourceAsStream("Pictures/cycle.png"));
        Image question = new Image(getClass().getResourceAsStream("Pictures/question.png"));
        Image backIcon = new Image(getClass().getResourceAsStream("Pictures/back-button.png"));

        // Create an ImageView with the icon
        ImageView iconView = new ImageView(icon);
        ImageView questionView = new ImageView(question);
        ImageView backView = new ImageView(backIcon);

        // Set the size of the ImageView
        iconView.setFitWidth(32);
        iconView.setFitHeight(32);
        backView.setFitWidth(32);
        backView.setFitHeight(32);
        questionView.setFitWidth(32);
        questionView.setFitHeight(32);

        // Set the graphic of the switchButton & helpButton
        switchButton.setGraphic(iconView);
        backButton.setGraphic(backView);
        helpButton.setGraphic(questionView);
    }

    @FXML
    private TextArea textInput; // TextArea for input text

    @FXML
    private TextArea morseOutput; // TextArea for output Morse code

    MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator(); // Instance of MorseCodeTranslator

    boolean morseToText = false; // Flag to indicate whether translation should be Morse to text or vice versa

    // Method to update the Morse code translation based on input text
    @FXML
    void updateMorseCode(ActionEvent event) {
        if(morseToText){
            morseOutput.setText(morseCodeTranslator.morseToText(textInput.getText()));
        }else {
            morseOutput.setText(morseCodeTranslator.textToMorse(textInput.getText()));
        }
    }

    // Method to switch between Morse to text translation and vice versa
    @FXML
    void switchStyle(ActionEvent event) {
        String text = textInput.getText();
        String morse = morseOutput.getText();
        morseToText = !morseToText;
        morseOutput.setText(text);
        textInput.setText(morse);
    }

    @FXML
    void showGroepsledenModal(ActionEvent event){
        try {
            // Load the modal FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("groepsleden.fxml"));
            Parent root = loader.load();

            // Create a new stage for the modal
            Stage groepStage = new Stage();
            groepStage.initModality(Modality.APPLICATION_MODAL);
            groepStage.setTitle("Groepsleden");
            groepStage.setScene(new Scene(root));

            // Show the modal
            groepStage.showAndWait();
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

    @FXML
    void Clear(){
        textInput.clear();
        morseOutput.clear();
    }

    @FXML
    void showHelpModal(ActionEvent event)  {
        try {
            // Load the help modal FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("helpModal.fxml"));
            Parent root = loader.load();

            // Create a new stage for the help modal
            Stage helpStage = new Stage();
            helpStage.initModality(Modality.APPLICATION_MODAL);
            helpStage.setTitle("Help");
            helpStage.setScene(new Scene(root));

            // Show the help modal
            helpStage.showAndWait();
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

    @FXML
    private void GoBack() {
        try {
            // Load the converter type FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("converterType.fxml"));
            Parent root = loader.load();
            ConverterTypeController controller = loader.getController();

            // Get the stage of the current scene
            Stage stage = (Stage) switchButton.getScene().getWindow();
            controller.setStage(stage);

            // Replace the current scene with the converter type scene
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

}
