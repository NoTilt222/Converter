package src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private Button switchButton;

    // Initialize method called after FXML loading
    @FXML
    public void initialize() {
        // Load your icon image
        Image icon = new Image(getClass().getResourceAsStream("cycle.png"));
        // Create an ImageView with the icon
        ImageView iconView = new ImageView(icon);
        // Set the size of the ImageView
        iconView.setFitWidth(32);
        iconView.setFitHeight(32);
        // Set the graphic of the switchButton
        switchButton.setGraphic(iconView);
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
}
