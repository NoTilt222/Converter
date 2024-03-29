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


    // Initialize method called after FXML loading
    @FXML
    public void initialize() {
        // Load your icon image
        Image icon = new Image(getClass().getResourceAsStream("cycle.png"));
        Image question = new Image(getClass().getResourceAsStream("question.png"));

        // Create an ImageView with the icon
        ImageView iconView = new ImageView(icon);
        ImageView questionView = new ImageView(question);

        // Set the size of the ImageView
        iconView.setFitWidth(32);
        iconView.setFitHeight(32);
        questionView.setFitWidth(32);
        questionView.setFitHeight(32);

        // Set the graphic of the switchButton & helpButton
        switchButton.setGraphic(iconView);
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
        morseToText = !morseToText;
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

}
