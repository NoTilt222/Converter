package src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelpModalController {
    @FXML
    private Text helpLabel;

    public void initialize() {
        helpLabel.setText("Klik op de 'Clear' knop om de tekstvelden te legen. Klik op de 'Groepsleden' knop om de namen van de " +
                "groepsleden te zien");
    }
}
