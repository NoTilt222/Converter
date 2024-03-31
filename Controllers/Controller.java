package src.Controllers;

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
import src.MorseCodeTranslator;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

public class Controller {

    @FXML
    private Button switchButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button backButton;
    @FXML
    private Button playSoundButton;
    private Requirements _requirements;

    // Initialize method called after FXML loading
    @FXML
    public void initialize() {
         _requirements = new Requirements();

        // Load your icon image
        Image icon = new Image(getClass().getResourceAsStream("../Pictures/cycle.png"));
        Image question = new Image(getClass().getResourceAsStream("../Pictures/question.png"));
        Image backIcon = new Image(getClass().getResourceAsStream("../Pictures/back-button.png"));
        Image speakerIcon = new Image(getClass().getResourceAsStream("../Pictures/speaker.png"));

        // Create an ImageView with the icon
        ImageView iconView = new ImageView(icon);
        ImageView questionView = new ImageView(question);
        ImageView backView = new ImageView(backIcon);
        ImageView speakerView = new ImageView(speakerIcon);
        // Set the size of the ImageView
        iconView.setFitWidth(32);
        iconView.setFitHeight(32);
        backView.setFitWidth(32);
        backView.setFitHeight(32);
        questionView.setFitWidth(32);
        questionView.setFitHeight(32);
        speakerView.setFitWidth(32);
        speakerView.setFitHeight(32);
        // Set the graphic of the switchButton & helpButton
        switchButton.setGraphic(iconView);
        backButton.setGraphic(backView);
        helpButton.setGraphic(questionView);
        playSoundButton.setGraphic(speakerView);
    }

    @FXML
    private TextArea Input; // TextArea for input text

    @FXML
    private TextArea Output; // TextArea for output Morse code

    MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator(); // Instance of MorseCodeTranslator

    // Method to update the Morse code translation based on input text
    @FXML
    void updateMorseCode(ActionEvent event) {
        _requirements.convert(Input, Output);
    }

    // Method to switch between Morse to text translation and vice versa
    @FXML
    void switchStyle(ActionEvent event) {
        _requirements.swap(Input, Output);
    }

    @FXML
    public void Clear(){
        _requirements.clear(Input, Output);
    }

    @FXML
    void showHelpModal(ActionEvent event)  {
        try {
            // Load the help modal FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/helpModal.fxml"));
            Parent root = loader.load();

            // Create a new stage for the help modal
            Stage helpStage = new Stage();
            helpStage.initModality(Modality.APPLICATION_MODAL);
            helpStage.setTitle("Help");
            helpStage.setScene(new Scene(root));

            // Show the help modal
            helpStage.showAndWait();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    @FXML
    void showExampleModal(ActionEvent event)  {
        try {
            // Load the help modal FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/examplesModal.fxml"));
            Parent root = loader.load();

            // Create a new stage for the help modal
            Stage stage = new Stage();
            stage.setTitle("Examples");
            stage.setScene(new Scene(root));

            // Show the help modal
            stage.showAndWait();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    @FXML
    private void GoBack() {
        try {
            // Load the converter type FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/converterType.fxml"));
            Parent root = loader.load();
            ConverterTypeController controller = loader.getController();

            // Get the stage of the current scene
            Stage stage = (Stage) switchButton.getScene().getWindow();
            controller.setStage(stage);

            // Replace the current scene with the converter type scene
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    @FXML
    void playMorseSound(ActionEvent event) {
        try {
            String morse = Input.getText();
            if(!morse.matches(".*[a-z].*")){
                morse = Output.getText();
            }

            final int DOT = 200, DASH = DOT * 3, FREQ = 800;
            for (char c : morse.toUpperCase().toCharArray()) {
                for (char note : (Character.isLetterOrDigit(c) ?
                        (Character.isLetter(c) ? morseCodeTranslator.morse[Character.toUpperCase(c) - 'A'].toCharArray() : morseCodeTranslator.morse[c - '0' + 26].toCharArray()) :
                        new char[]{'\n'})) {
                    try (SourceDataLine sdl = AudioSystem.getSourceDataLine(new AudioFormat(8000F, 8, 1, true, false))) {
                        sdl.open(sdl.getFormat());
                        sdl.start();
                        for (int i = 0; i < (note == '.' ? DOT : DASH) * 8; i++) {
                            sdl.write(new byte[]{(byte) (Math.sin(i / (8000F / FREQ) * 2.0 * Math.PI) * 127.0)}, 0, 1);
                        }
                        sdl.drain();
                    }
                    Thread.sleep(DOT / 5);
                }
            }
        } catch (Exception e){
            System.err.println("Error: " + e);
        }
    }
}
